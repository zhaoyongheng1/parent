package cn.com.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@SpringCloudApplication
public class AuthClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(AuthClient1Application.class, args);
    }


    @Autowired
    private BaseOAuth2ProtectedResourceDetails baseOAuth2ProtectedResourceDetails;


    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {
        ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails =
                new ResourceOwnerPasswordResourceDetails();

        resourceOwnerPasswordResourceDetails.setClientId(baseOAuth2ProtectedResourceDetails.getClientId());
        resourceOwnerPasswordResourceDetails.setClientSecret(baseOAuth2ProtectedResourceDetails.getClientSecret());
        resourceOwnerPasswordResourceDetails.setAccessTokenUri(baseOAuth2ProtectedResourceDetails.getAccessTokenUri());
        resourceOwnerPasswordResourceDetails.setId(baseOAuth2ProtectedResourceDetails.getId());
        resourceOwnerPasswordResourceDetails.setAuthenticationScheme(baseOAuth2ProtectedResourceDetails.getAuthenticationScheme());
        resourceOwnerPasswordResourceDetails.setClientAuthenticationScheme(baseOAuth2ProtectedResourceDetails.getClientAuthenticationScheme());
        resourceOwnerPasswordResourceDetails.setGrantType(baseOAuth2ProtectedResourceDetails.getGrantType());
        resourceOwnerPasswordResourceDetails.setScope(baseOAuth2ProtectedResourceDetails.getScope());
        resourceOwnerPasswordResourceDetails.setTokenName(baseOAuth2ProtectedResourceDetails.getTokenName());

        OAuth2RestTemplate restTemplate =
                new OAuth2RestTemplate(resourceOwnerPasswordResourceDetails, new DefaultOAuth2ClientContext());
        return restTemplate;
    }

}
