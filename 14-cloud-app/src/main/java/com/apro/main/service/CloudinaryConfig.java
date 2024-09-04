package com.apro.main.service;

import com.cloudinary.Cloudinary;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {


    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dg3umcxnh",
            "api_key", "843371164339839",
            "api_secret", "LNiE2E4xyFLjc_tWkxCL5pzhEa0"
        ));
    }
}
