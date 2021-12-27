package cn.com.hkr.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * jwt 加密器
 * @author jason
 * @date 2021/10/18-0:29
 */
public class JwtUtils {

    private static final Integer EXPIRE_TIME = 60 * 10 * 1000;


/*
    public static void main(String[] args){
        String secret = "Jason001";

        Map<String ,String> sets = new HashMap<String,String>();
        sets.put("username","贾生");
        sets.put("password","admin");


        String token = getToken(sets, secret);
        System.out.println("您获取的token为：" + token);
        System.out.println("--------------------------提取所有数据：--------------------------");

        Map<String,Claim> datas = getDatas(token);
        for(String key : datas.keySet()){
            System.out.println(key + " = " + datas.get(key).asString());
        }

        System.out.println("-------------------------提取其中username值：---------------------");
        String username = getData(token, "username");
        System.out.println("username" + "=" + username);


        System.out.println("-----------------------加密一个user对象数据--------------------------");
        User user = new User();

        user.setEmail("13552648187@163.com");

        Map maps = new HashMap();

        maps.put("user",user);

        String token1 = getToken(maps, secret);
        System.out.println("token1  :  " + token1);


    }
*/


    /**
     * 校验token秘钥是否是正确的
     * @param token
     * @param username
     * @param ack
     * @return
     */
    public static boolean verify(String token ,String username,String ack){

        try {
            Algorithm algorithm = Algorithm.HMAC256(ack);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            //如果这一步校验失败的话，就会直接抛出异常信息。所有可以通过知否抛出异常信息来看是否验证通过
            DecodedJWT verify = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 通过加密的签名获取其中的数据
     * @param token
     * @return
     */
    public static String getData(String token,String key){

        try {
            //jwt通过token获取数据是不需要进行secret的解密数据的。可以直接通过token来获取里面的数据。
            DecodedJWT decode = JWT.decode(token);
            Claim username = decode.getClaim(key);
            String s = username.asString();
            return s;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 通过token来获取里面的所有数据
     * @param token
     * @return
     */
    public static Map getDatas(String token){

        try {
            DecodedJWT decoded = JWT.decode(token);

            Map<String, Claim> claims = decoded.getClaims();

            return claims;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }




    /***
     * 通过参数和秘钥来获取token数据
     * @param data
     * @param secret
     * @return
     */
    public static String getToken(Map<String, String> data, String secret){
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        Algorithm algorithm = Algorithm.HMAC256(secret);

        JWTCreator.Builder builder = JWT.create().withExpiresAt(date);

        for(String key : data.keySet()){
            builder.withClaim(key, (String) data.get(key));
        }
        return builder.sign(algorithm).toString();

    }

}
