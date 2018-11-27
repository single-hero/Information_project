//package com.hero.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//import java.io.UnsupportedEncodingException;
//
//public class JwtUtil {
//    //创建token
////    public static String creatToken(User user) throws IllegalArgumentException, UnsupportedEncodingException{
////        Algorithm algorithm = Algorithm.HMAC256("secret");
////        String username = user.getUsername();
////        Map<String, Object> map = Maps.newHashMap();
////        map.put("alg", "HS256");
////        map.put("typ", "JWT");
////        String token = JWT.create().withHeader(map)
////                .withClaim("username", username)
////                .withExpiresAt(new Date(System.currentTimeMillis()+360000))
////                .sign(algorithm);
////        return token;
////    }
//
//    //验证jwt
//    public static DecodedJWT verifyJwt(String token){
//        DecodedJWT decodedJWT = null;
//        try{
//            Algorithm algorithm = Algorithm.HMAC256("secret");
//            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
//            decodedJWT = jwtVerifier.verify(token);
//        }catch(IllegalArgumentException e){
//            e.printStackTrace();
//        }catch (UnsupportedEncodingException e){
//            e.printStackTrace();
//        }catch(JWTVerificationException e) {
//            e.printStackTrace();
//        }
//        return decodedJWT;
//    }
//
//    public static void main(String[] args) throws UnsupportedEncodingException{
////        String username = "root";
////        Integer id =1;
////        System.out.println(creatToken(username,id));
////        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MDgxMzgxNDAsInVzZXJJZCI6MSwidXNlcm5hbWUiOiJyb290In0.OeRdHJZKmxFBqIN-A-uSNQK8JyKdzX-wcFR883oMqFA";
////        System.out.println(verifyJwt("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MDgxMzgxNDAsInVzZXJJZCI6MSwidXNlcm5hbWUiOiJyb290In0.OeRdHJZKmxFBqIN-A-uSNQK8JyKdzX-wcFR883oMqFA"));
////        System.out.println(verifyJwt(token).getClaims().get("username").asString());
//    }
//}
