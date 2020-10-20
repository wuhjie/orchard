package com.wu.core.service.impl;

import com.wu.common.basic.LoginInfoVo;
import com.wu.common.domain.ApiResponse;
import com.wu.common.entity.CustomerAccount;
import com.wu.common.exception.ExceptionEnum;
import com.wu.common.exception.ServiceException;
import com.wu.common.redis.RedisHelper;
import com.wu.common.utils.Audience;
import com.wu.common.utils.JwtTokenUtil;
import com.wu.core.RequestContextHolder;
import com.wu.core.repository.UserAccountRepository;
import com.wu.core.service.CustomerAccountService;
import io.swagger.annotations.Api;
import io.swagger.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @ClassName CustomerAccountServiceImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/15 1:37 pm
 * @Version 1.0
 **/

@Slf4j
@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

    @Autowired
    private Audience audience;

    @Resource
    UserAccountRepository userAccountRepository;

    @PostConstruct
    public void init() {}

    //todo
    @Override
    public String getCustomerTokenCache(Integer cumstomerId) {
        return RequestContextHolder.getCurrentCustomer().getCustomerId();
    }

    //todo
    @Override
    public void clearToken(Set<Integer> customerIds) {
        for (Integer c : customerIds) {
            RequestContextHolder.removeCurrentUser();
        }
    }

    @Override
    public void logout(String token) throws Exception {
        CustomerAccount customerAccount = RequestContextHolder.getCurrentCustomer();
        RequestContextHolder.removeCurrentUser();
        RedisHelper.remove(customerAccount.getCustomerId());
    }

    @Override
    public LoginInfoVo login(String account, String password) throws Exception {
        CustomerAccount customerAccount = CustomerAccount.builder().customerId(account).password(password).build();
        //todo
        Example<CustomerAccount> example = Example.of(customerAccount);
        List<CustomerAccount> resultList = userAccountRepository.findAll(example);

        if (resultList.size() == 0) {
            throw ServiceException.build(ExceptionEnum.USER_PASSWORD_ERROR);
        }

        customerAccount = resultList.get(0);

        String token = JwtTokenUtil.creatJWT(Long.parseLong(customerAccount.getCustomerId()), account, audience);

        // token cache
        RedisHelper.set(String.valueOf(customerAccount.getId()), token);

        return LoginInfoVo.builder().token(token).expireSecond(audience.getExpireSecond())
                .customerName(customerAccount.getCustomerId()).build();


    }
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public ApiResponse forgetPassword(String phone, String smsCode, String firstPassword, String secondPassword) throws Exception {

        if (firstPassword.equals(secondPassword)) {
            CustomerAccount customerAccount = userAccountRepository.findByTel(phone);
            if (customerAccount != null) {
                String cache = RedisHelper.get(phone, false);
                if (!StringUtils.isEmpty(cache)) {
                    if (smsCode != null && !"".equals(smsCode) && !cache.equals(smsCode)) {
                        customerAccount.setPassword(firstPassword);
                        userAccountRepository.saveAndFlush(customerAccount);
                        RedisHelper.remove(phone);
                        //delete exist token for this customer
                        RequestContextHolder.removeCurrentUser();
                        return ApiResponse.ok();
                    }
                    return ApiResponse.error(500, "error token");
                }
                return ApiResponse.error(500, "token expired or used");
            }
            return ApiResponse.error(500, "tel never signup");
        }
        return ApiResponse.error(500, "passwords aren't same");
    }

}
