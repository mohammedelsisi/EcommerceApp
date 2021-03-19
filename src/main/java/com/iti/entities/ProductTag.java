package com.iti.entities;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class ProductTag extends SimpleTagSupport {
    private String img;
    private String desc;
    private String name;
    private String price;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
// <div class="item">
//                            <div class="block-4 text-center">
//                                <figure class="block-4-image">
//                                    <img src="../../images/cloth_1.jpg" alt="Image placeholder" class="img-fluid">
//                                </figure>
//                                <div class="block-4-text p-4">
//                                    <h3><a href="#">Tank Top</a></h3>
//                                    <p class="mb-0">Finding perfect t-shirt</p>
//                                    <p class="text-primary font-weight-bold">$50</p>
//                                </div>
//                            </div>
//                        </div>
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<div>");
        out.println(" <div class=\"block-4 text-center\">");
        out.println("     <figure class=\"block-4-image\">");
        out.println("  <img src="+img+" alt=\"Image placeholder\" class=\"img-fluid\">");
        out.println("</figure>");
        out.println("<div class=\"block-4-text p-4\">");
        out.println(" <h3><a href=\"#\">"+name+"</a></h3>");
        out.println("  <p class=\"mb-0\">"+desc+"</p>");
        out.println("  <p class=\"text-primary font-weight-bold\">"+price+"</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");



    }
}
