package web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        if(user.getRole().iterator().next().getRole().contains("Admin")){
            httpServletResponse.sendRedirect("/admin");
        }
        else if(user.getRole().iterator().next().getRole().contains("User")){
            httpServletResponse.sendRedirect("/user");
        }
        else {
            httpServletResponse.sendRedirect("/login");
        }


    }
}