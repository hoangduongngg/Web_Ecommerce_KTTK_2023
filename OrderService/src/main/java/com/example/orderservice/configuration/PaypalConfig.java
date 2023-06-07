package com.example.orderservice.configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaypalConfig {

//    @Value("${paypal.client.id}")
//    private String clientSecret;
//    @Value("${paypal.client.secret}")
//    private String clientId;
//    @Value("${paypal.mode}")
//    private String mode;

    private String clientId="AfhFyzOMaULltBu7IyBMMaclrG1NfZuEfOIheOEaxffXpcUxV7nTVbsAtA2Qs4_173t6qkvjb3vZSgi4";
    private String clientSecret="EKRsCp0E3KFXHWQCZMXLymHqTor9jU8viGmHd85FIKxzNYXzmiz2x841K4CwLF2SS7ncOyjlzY77Pm8B";
    private String mode="sandbox";

    public Map paypalConfig() {
        Map configMap = new HashMap<>();
        configMap.put("mode", mode);
        return configMap;
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalConfig());
//        APIContext context = new APIContext(clientId, clientSecret, mode);
        return context;
    }
}
