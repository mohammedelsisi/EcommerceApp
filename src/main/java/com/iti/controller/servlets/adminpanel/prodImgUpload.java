package com.iti.controller.servlets.adminpanel;

import com.iti.model.DTO.UserDTO;
import com.iti.service.ProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/firstImageUpload")
@MultipartConfig
public class prodImgUpload extends HttpServlet {


    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //TODO change Path to another place on the servver
            Part filePart = request.getPart("firstImg");
            String realPath = request.getServletContext().getRealPath("");
            String fileName = filePart.getSubmittedFileName();
            String toSave = "layout/images/products/";
            PrintWriter out = response.getWriter();
            try {
                filePart.write(realPath+toSave+fileName);
            } catch (FileNotFoundException fne) {
                out.println("Error While Uploading Your File");
            }


        }

        private String getFileExtension(String name) {

            int lastIndexOf = name.lastIndexOf(".");
            return name.substring(lastIndexOf);
        }


}
