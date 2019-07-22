package com.proxymit.ewallet.ewalletmanagementprofiles.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


public class userUtils {
    public static String  getId(String token){
        try {
            DecodedJWT decode = JWT.decode(token);
            return  decode.getClaim("sub").asString();
        } catch (SignatureVerificationException | JWTDecodeException e) {
            e.printStackTrace();
            return null;
        }

    }
}
