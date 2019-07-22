package Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import models.MerchantForm;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

public class userUtils {

    private static RestTemplate restTemplate = new RestTemplate();

    public  static MerchantForm getUser(){



        MerchantForm rm = restTemplate.exchange("profile-management-service",
                HttpMethod.GET,null,MerchantForm.class).getBody();

        return rm;
    }


    public static String  getId(String token){
        try {
            DecodedJWT decode = JWT.decode(token);
            return  decode.getClaim("jti").asString();
        } catch (SignatureVerificationException | JWTDecodeException e) {
            e.printStackTrace();
            return null;
        }

    }
}
