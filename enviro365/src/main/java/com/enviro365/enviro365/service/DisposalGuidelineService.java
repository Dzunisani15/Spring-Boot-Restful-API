package com.enviro365.enviro365.service;

import com.enviro365.enviro365.entity.DisposalGuideline;
import com.enviro365.enviro365.entity.WasteCategory;
import com.enviro365.enviro365.repository.DisposalGuidelineRepository;
import com.enviro365.enviro365.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enviro365.enviro365.ResourceNotFoundException;

import java.util.List;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public List<DisposalGuideline> getDisposalGuidelinesByCategoryId(Long categoryId) {
        return repository.findByWasteCategory_Id(categoryId);
    }

    public DisposalGuideline createDisposalGuideline(Long categoryId, DisposalGuideline disposalGuideline) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Waste Category not found with id: " + categoryId));
        disposalGuideline.setWasteCategory(wasteCategory);
        return repository.save(disposalGuideline);
    }

    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline disposalGuideline) {
        DisposalGuideline existingGuideline = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal Guideline not found with id: " + id));
        existingGuideline.setGuideline(disposalGuideline.getGuideline());
        return repository.save(existingGuideline);
    }

    public void deleteDisposalGuideline(Long id) {
        repository.deleteById(id);
    }
}
