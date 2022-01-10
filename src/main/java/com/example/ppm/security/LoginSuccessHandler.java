package com.example.ppm.security;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.ppm.model.MyUserDetails;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
         
        String redirectURL = request.getContextPath();
         
        if (userDetails.hasRole("Admin_Role")) {
        	System.out.print("hiii admin");
            redirectURL += "/admin_home";
        } else if (userDetails.hasRole("Manager_Role")) {
        	System.out.print("hiii manager");
            redirectURL += "/manager_home";
        } else if (userDetails.hasRole("Employee_Role")) {
            redirectURL += "/employee_home";
        }
         
        response.sendRedirect(redirectURL);
         
    }

}
