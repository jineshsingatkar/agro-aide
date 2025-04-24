package com.agroaide.repository;

import com.agroaide.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findByCategory(String category);
    List<Crop> findBySellerId(Long sellerId);
    List<Crop> findByAvailableTrue();
    List<Crop> findByLocationContaining(String location);
    List<Crop> findByPriceBetween(Double minPrice, Double maxPrice);
} 