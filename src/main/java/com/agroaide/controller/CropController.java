package com.agroaide.controller;

import com.agroaide.entity.Crop;
import com.agroaide.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping
    public ResponseEntity<?> addCrop(@RequestBody Crop crop) {
        return ResponseEntity.ok(cropService.addCrop(crop));
    }

    @GetMapping
    public ResponseEntity<List<Crop>> getAllCrops() {
        return ResponseEntity.ok(cropService.getAllCrops());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Crop>> getCropsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(cropService.getCropsByCategory(category));
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<Crop>> getCropsBySeller(@PathVariable Long sellerId) {
        return ResponseEntity.ok(cropService.getCropsBySeller(sellerId));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Crop>> getAvailableCrops() {
        return ResponseEntity.ok(cropService.getAvailableCrops());
    }

    @GetMapping("/search/location")
    public ResponseEntity<List<Crop>> searchCropsByLocation(@RequestParam String location) {
        return ResponseEntity.ok(cropService.searchCropsByLocation(location));
    }

    @GetMapping("/search/price")
    public ResponseEntity<List<Crop>> searchCropsByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        return ResponseEntity.ok(cropService.searchCropsByPriceRange(minPrice, maxPrice));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCropById(@PathVariable Long id) {
        return cropService.getCropById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCrop(@PathVariable Long id, @RequestBody Crop crop) {
        crop.setId(id);
        return ResponseEntity.ok(cropService.updateCrop(crop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return ResponseEntity.ok().build();
    }
} 