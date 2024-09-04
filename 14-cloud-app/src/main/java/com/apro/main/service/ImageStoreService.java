package com.apro.main.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.apro.main.entity.ImageStore;
import com.apro.main.repository.ImageStoreRepo;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ImageStoreService {
	@Autowired
	ImageStoreRepo imageStoreRepo;
	
    @Autowired
    private Cloudinary cloudinary;
    
	public ImageStore addImage(String url) {
		ImageStore imageStore = new ImageStore();
		imageStore.setImageUrl(url);
		return imageStoreRepo.save(imageStore);
	}
	
	public ImageStore getImage(Integer imageId) {
		return imageStoreRepo.findById(imageId).orElseThrow(()-> new NullPointerException());
	}


    public ImageStore uploadImage(MultipartFile file) throws IOException {
        Map<String,Object> data =  cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
         String url = (String) data.get("secure_url");
         ImageStore  imageDB =this.addImage(url);
         return imageDB;
    }
}
