package cn.waicaibao.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.ClientTokenServices;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.OAuth2ClientConfiguration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liyang-macbook on 2016/11/28.
 */
@Component
public class MyLogoutHandler extends SimpleUrlAuthenticationSuccessHandler implements LogoutHandler{
    private static final Logger LOG = LoggerFactory.getLogger(MyLogoutHandler.class);
    private boolean invalidateHttpSession = true;
    private boolean clearAuthentication = true;

    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;


    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

//      clearAuthenticationAttributes(request);


        Assert.notNull(request, "HttpServletRequest required");
        if (invalidateHttpSession) {
          //  request.changeSessionId();
            HttpSession session = request.getSession(false);
            if (session != null) {
//                LOG.debug("Invalidating session: " + session.getId());
//                session.removeAttribute("scopedTarget.oauth2ClientContext");
//                ServletContext sc = session.getServletContext();
//                if(sc!=null){
//                    sc.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//                }
                session.invalidate();
            }

        }


        if (clearAuthentication) {
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(null);
        }

        SecurityContextHolder.clearContext();

    }
}
