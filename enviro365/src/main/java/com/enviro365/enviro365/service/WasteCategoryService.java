package com.enviro365.enviro365.service;

import com.enviro365.enviro365.ResourceNotFoundException;
import com.enviro365.enviro365.entity.WasteCategory;
import com.enviro365.enviro365.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    public List<WasteCategory> getAllWasteCategories() {
        return repository.findAll();
    }

    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return repository.save(wasteCategory);
    }

    public WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory) {
        WasteCategory existingCategory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste Category not found with id: " + id));
        existingCategory.setName(wasteCategory.getName());
        return repository.save(existingCategory);
    }

    public void deleteWasteCategory(Long id) {
        repository.deleteById(id);
    }
}
