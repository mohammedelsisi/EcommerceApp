package com.iti.model.utils.authentication;

import com.iti.model.DTO.UserDTO;
import com.iti.service.LoginService;
import jakarta.servlet.http.Cookie;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.*;

public class Encryption {

    private static final Encryption encryption = new Encryption();
    Encryptor encryptor;
    public static Encryption getInstance(){
        return encryption;
    }
    private Encryption() {
        encryptor = Encryptor.getEncryptor();
    }

    public UserDTO getUserIfPresent(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Optional<String> xs = Arrays.stream(cookies).filter(e -> e.getName().equals("xs")).map(Cookie::getValue).findFirst();
            if (xs.isPresent()) {
                String[] credentials = encryptor.decrypt(xs.get()).split("@@");
                LoginService loginService = (LoginService) request.getServletContext().getAttribute("LoginService");
                return loginService.getUser(credentials[0], credentials[1]);
            }
        }
        return null;
    }
}
