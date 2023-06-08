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

    private String clientId="AZKm_B4_6Rr9J-vqII4vd0T4RJ4K9uHOZ4uky4wdail6mjvOROhsU2fK_J6Kneft4t301i7PKfpzWbp4";
    private String clientSecret="EOgIir-o8iivoMxRI4yG0h9deF34sJW1nv50XBS3id4evh0yQboUTOC1qtPA9nNgtTAoXFjkxlci3pM0";
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
