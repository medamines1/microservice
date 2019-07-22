package com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;

@Data
@Slf4j
@Service
public class KeycloackTokensService {


    @Value("${keycloak-host}")
    private  String serverUrl ;


        public  KeycloakToken getToken(String userName , String password)  {

             OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            StringReader stringReader = new StringReader("application/x-www-form-urlencoded");
            String ch = "username="+userName+"&password="+password+"&client_id=ewallet-app-web&grant_type=password&undefined=";
            RequestBody body = (RequestBody) RequestBody.create(mediaType, ch);

            Request request = new Request.Builder()
                    .url(serverUrl+"/auth/realms/ewallet/protocol/openid-connect/token")
                    .post(body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String tokenString = null;
            try {
                tokenString = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (! response.isSuccessful()) {
                log.info("----------------- " + response.toString());
                throw new RuntimeException("request isn't successful");
            }
            JsonObject jsonObject = new JsonParser().parse(tokenString).getAsJsonObject();

            KeycloakToken keycloakToken = KeycloakToken.builder()
                    .accessToken(jsonObject.get("access_token").getAsString())
                    .AccessToken_expires_in(jsonObject.get("expires_in").getAsString())
                    .refresh_token(jsonObject.get("refresh_token").getAsString())
                    .refresh_token_expires_in(jsonObject.get("refresh_expires_in").getAsString())
                    .build();
            return keycloakToken;

        }

        public  String getAccessToken(String username , String password)
        {
            ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
            resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
            resourceDetails.setAccessTokenUri(serverUrl + "/auth/realms/ewallet/protocol/openid-connect/token");


            resourceDetails.setClientId("ewallet-app-web");
            //resourceDetails.setClientSecret("df56fa11-19df-4929-95bf-4884163e2896");


            resourceDetails.setUsername(username);
            resourceDetails.setPassword(password);
            resourceDetails.setGrantType("password");

            OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);

            String token =  template.getAccessToken().toString();


            System.out.println("Token: " + token);
            return  token;
        }
    }
