//package com.wu.common.utils;
////
////import com.wu.common.exception.ExceptionEnum;
////import com.wu.common.exception.ServiceException;
////import com.wu.common.utils.jwt.Audience;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//import java.security.Key;
//import java.util.Date;
//
///**
// * @ClassName JwtTokenUtil
// * @Description
// * @Author wuhjie
// * @Data 2020/10/15 2:18 pm
// * @Version 1.0
// **/
//public class JwtTokenUtil {
//
//    private static Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
//
//    public static final String AUTH_HEADER_KEY = "authToken";
//
//    public static final String AUTH_USER_ID = "auth_user_id";
////    private static byte[] DatatypeConverter;
//
//    /**
//     * analysis jwt
//     * @param jsonWebToken
//     * @param base64Security
//     * @return
//     */
//    public static Claims parseJWT(String jsonWebToken, String base64Security) {
//        return Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
//                .parseClaimsJws(jsonWebToken).getBody();
//    }
//
//    public static String creatJWT(Long userId, String username, com.wu.common.utils.Audience audience) {
//        try {
//            //加密方法
//            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//            long nowMillis = System.currentTimeMillis();
//            Date now = new Date(nowMillis);
//
//            //making security key
//            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
//            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//            // adding jwc parameters
//            /**
//             * setSubject: owner of current JWT
//             * setIssuer: sender of current JWT
//             * setIssuedAt: sending time
//             * setAudience: receiver of current JWT
//             */
//            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWt")
//                    .claim("userId", userId)
//                    .setSubject(username)
//                    .setIssuer(audience.getClientId())
//                    .setIssuedAt(new Date())
//                    .setAudience(audience.getName())
//                    .signWith(signatureAlgorithm, signingKey);
//
//            // expire time dor token
//            int tTlMillis = audience.getExpireSecond() * 1000;
//            if (tTlMillis >= 0) {
//                long expMillis = nowMillis + tTlMillis;
//                Date exp = new Date(expMillis);
//                builder.setExpiration(exp).setNotBefore(now);
//            }
//            return builder.compact();
//        } catch (Exception e) {
//            log.error("signature failed: {}", e.getMessage());
//            e.printStackTrace();
//            throw ServiceException.build(ExceptionEnum.NOT_LOGGED, e);
//        }
//    }
//
//    /**
//     * get user name from token
//     * @param token
//     * @param base64Security
//     * @return
//     */
//    public static String getUsername(String token, String base64Security) {
//        return parseJWT(token, base64Security).getSubject();
//    }
//
//    /**
//     * get userId from token
//     * @param token
//     * @param base64Security
//     * @return
//     */
//    public static Long getUserId(String token, String base64Security) {
//        Long userId = parseJWT(token, base64Security).get("userId", Long.class);
//        return userId;
//    }
//
//    /**
//     * if expires
//     * @param token
//     * @param base64Security
//     * @return
//     */
//    public static boolean isExpiration(String token, String base64Security) {
//        return parseJWT(token, base64Security).getExpiration().before(new Date());
//    }
//}
