package com.example.creditSuisseProject.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MvcConfig implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        Path postUploadDir = Paths.get("./post-images");
        String postUploadPath = postUploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/post-images/**").addResourceLocations("file:/" + postUploadPath + "/");
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    //    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
    //        Path uploadDir = Paths.get(dirName);
    //        String uploadPath = uploadDir.toFile().getAbsolutePath();
    //
    //        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
    //
    //        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
    //    }
}
