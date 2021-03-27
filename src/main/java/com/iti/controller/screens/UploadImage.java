package com.iti.controller.screens;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        String path = "F:/ServerFiles/";
        Part filePart = request.getPart("ChosenUserImageName");

        String fileName = filePart.getSubmittedFileName();
        PrintWriter out = response.getWriter();
        try {
            filePart.write(path+fileName);
            out.println("New file " + fileName + " created at " + path);
        } catch (FileNotFoundException fne) {
            out.println("Error While Uploading Your File");
        }
    }


}
