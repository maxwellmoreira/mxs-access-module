package com.mxs.factory.security;

import com.mxs.facade.UserFacade;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Component
public class JwtFilterSecurityFactory extends GenericFilterBean {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtProviderSecurityFactory jwtProviderSecurityFactory;

    @Autowired
    private UserFacade userFacade;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        logger.info("do filter...");
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if (token != null && jwtProviderSecurityFactory.validateToken(token)) {
            String userLogin = jwtProviderSecurityFactory.getLoginFromToken(token);
            UserModel userModel = new UserModel.Builder().username(userLogin).build();
            //List<UserModel> userModelOptionalList = this.userFacade.findUser(userModel);
            //UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
            //SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}