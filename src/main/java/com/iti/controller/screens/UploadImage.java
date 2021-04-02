package com.iti.controller.screens;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.iti.model.DTO.UserDTO;
import com.iti.service.ProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadImage")
@MultipartConfig
public class UploadImage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO change Path to another place on the servver
        Part filePart = request.getPart("ChosenUserImageName");
        String realPath = request.getServletContext().getRealPath("");
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("currentUser");
        String fileName = filePart.getSubmittedFileName();
        String property = System.getProperty("user.home");
        System.out.println(property);
        System.out.println("###"+property);
        String toSave = "layout/images/users/";
        String image =userDTO.getId() + getFileExtension(fileName);
        PrintWriter out = response.getWriter();
        try {
            filePart.write(realPath+toSave+image);
        } catch (FileNotFoundException fne) {
            out.println("Error While Uploading Your File");
        }
        userDTO.setImage(toSave+image);
        ProfileService.getInstance().editProfile(userDTO);
    }

    private String getFileExtension(String name) {

        int lastIndexOf = name.lastIndexOf(".");
        return name.substring(lastIndexOf);
    }

}
