package com.iti.model.utils;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class BreadCrumbTag extends SimpleTagSupport {
    private String dir;
    private String parentDir;
    private String fontIcon;
    private String pageTitle;

    public String getFontIcon() {
        return fontIcon;
    }

    public void setFontIcon(String fontIcon) {
        this.fontIcon = fontIcon;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getParentDir() {
        return parentDir;
    }

    public void setParentDir(String parentDir) {
        this.parentDir = parentDir;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<div class=\"d-sm-flex align-items-center justify-content-between mb-4\">");
        out.println("<h1 class=\"h3 mb-0 text-gray-800\"><i class=\""+fontIcon+"\"></i> "+pageTitle+"</h1>");
        out.println("<ol class=\"breadcrumb\">");
        out.println("<li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>");
        out.println("<li class=\"breadcrumb-item \" aria-current=\"page\">"+parentDir+"</li>");
        out.println("<li class=\"breadcrumb-item active\" aria-current=\"page\">"+dir+"</li>");
        out.println("</ol>");
        out.println("</div>");

    }
}
