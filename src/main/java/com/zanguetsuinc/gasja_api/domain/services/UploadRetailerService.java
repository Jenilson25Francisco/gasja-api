package com.zanguetsuinc.gasja_api.domain.services;

import com.cloudinary.Cloudinary;
import com.zanguetsuinc.gasja_api.domain.exceptions.BusinessException;
import com.zanguetsuinc.gasja_api.domain.models.Retailer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UploadRetailerService {

    private final Cloudinary cloudinary;
    private final getRetailerService getRetailerService;

    public UploadRetailerService(Cloudinary cloudinary, getRetailerService getRetailerService) {
        this.cloudinary = cloudinary;
        this.getRetailerService = getRetailerService;
    }

    @SuppressWarnings("unchecked")
    public Retailer uploadImage(UUID retailerId, MultipartFile file) throws IOException {
        List<String> allowedExtensions = List.of("jpg", "jpeg", "png", "gif", "webp");

        Retailer retailer = getRetailerService.getStation(retailerId);

        if (file.getOriginalFilename() != null){
            String[] fileNameParts = file.getOriginalFilename().split("\\.");
            String fileExtension = fileNameParts[fileNameParts.length - 1].toLowerCase();

            if (!allowedExtensions.contains(fileExtension)) {
                throw new BusinessException("Estenção de arquivo não permitida. Apenas arquivos JPG, JPEG, PNG, GIF e WEBP são aceitos.");
            }
        }

        try {
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of("folder", "gasja/retailers"));
            String imageUrl = uploadResult.get("secure_url").toString();
            retailer.setImageUrl(imageUrl);
            return retailer;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
