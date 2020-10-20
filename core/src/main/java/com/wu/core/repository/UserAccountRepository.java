package com.wu.core.repository;

import com.wu.common.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author nullacc
 */
public interface UserAccountRepository extends JpaSpecificationExecutor<CustomerAccount>, JpaRepository<CustomerAccount, Long>{

    CustomerAccount findByTel(String phone);


}
