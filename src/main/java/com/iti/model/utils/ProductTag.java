package com.iti.model.utils;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class ProductTag extends SimpleTagSupport {
    private String img;
    private String desc;
    private String src;
    private double price;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<div>");
        out.println(" <div class=\"block-4 text-center border\">");
        out.println("     <figure class=\"block-4-image\">");
        out.println(" <a href="+src+"> <img src="+img+" alt=\"Image placeholder\" class=\"img-fluid\"></a>");
        out.println("</figure>");
        out.println("<div class=\"block-4-text p-4\">");
        //out.println(" <h3><a href=\"#\">"+src+"</a></h3>");
        out.println("  <p class=\"mb-0\">"+desc+"</p>");
        out.println("  <p class=\"text-primary font-weight-bold\">"+"$"+price+"</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");



    }
}
