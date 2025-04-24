package com.agroaide.service;

import com.agroaide.entity.Crop;
import com.agroaide.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CropService {
    @Autowired
    private CropRepository cropRepository;

    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public List<Crop> getCropsByCategory(String category) {
        return cropRepository.findByCategory(category);
    }

    public List<Crop> getCropsBySeller(Long sellerId) {
        return cropRepository.findBySellerId(sellerId);
    }

    public List<Crop> getAvailableCrops() {
        return cropRepository.findByAvailableTrue();
    }

    public List<Crop> searchCropsByLocation(String location) {
        return cropRepository.findByLocationContaining(location);
    }

    public List<Crop> searchCropsByPriceRange(Double minPrice, Double maxPrice) {
        return cropRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public Optional<Crop> getCropById(Long id) {
        return cropRepository.findById(id);
    }

    public Crop updateCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }
} 