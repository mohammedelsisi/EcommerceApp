package com.iti.model.utils.authentication;

import com.iti.model.DTO.UserDTO;
import com.iti.service.LoginService;
import jakarta.servlet.http.Cookie;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.*;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;

public class SavingUserService {

    private static final SavingUserService SAVING_USER_SERVICE = new SavingUserService();
    Encryptor encryptor;

    private SavingUserService() {
        encryptor = Encryptor.getEncryptor();
    }

    public static SavingUserService getInstance() {
        return SAVING_USER_SERVICE;
    }

    public UserDTO getUserIfPresent(HttpServletRequest request) {
        try {

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                Optional<String> xs = Arrays.stream(cookies).filter(e -> e.getName().equals("xp")).map(Cookie::getValue).findFirst();
                if (xs.isPresent()) {
                    String[] credentials = encryptor.decrypt(xs.get());
                    LoginService loginService = (LoginService) request.getServletContext().getAttribute("LoginService");
                    return loginService.getUser(credentials[0], credentials[1]);
                }
            }
        } catch (EncryptionOperationNotPossibleException e) {
            return null;
        }

        return null;
    }

    public void saveUserCredentials(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("userEmail");
        String password = request.getParameter("userPassword");
        Cookie cookie = new Cookie("xp", encryptor.encrypt(email, password));
        cookie.setMaxAge(60 * 60 * 24 * 14);
        response.addCookie(cookie);
    }

    public void extendLoggingTime(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Optional<Cookie> xs = Arrays.stream(cookies).filter(e -> e.getName().equals("xp")).findFirst();
            xs.ifPresent(cookie -> {
                cookie.setMaxAge(60 * 60 * 24 * 14);
                System.out.println(request.getServletPath());
                response.addCookie(cookie);
            });
        }
    }
    // TODO Invalidate User when he logout
    public void invalidateUser(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Optional<Cookie> xs = Arrays.stream(cookies).filter(e -> e.getName().equals("xp")).findFirst();
            xs.ifPresent(cookie -> {
                cookie.setMaxAge(-1);
                cookie.setValue("adasdmkahdukaslbdlasbdlhasbfhlsdvfljasvjlfasvdfha");
                response.addCookie(cookie);
            });
        }
    }


}
