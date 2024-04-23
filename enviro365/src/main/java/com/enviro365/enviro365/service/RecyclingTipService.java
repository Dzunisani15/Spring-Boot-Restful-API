package com.enviro365.enviro365.service;

import com.enviro365.enviro365.ResourceNotFoundException;
import com.enviro365.enviro365.entity.RecyclingTip;
import com.enviro365.enviro365.entity.WasteCategory;
import com.enviro365.enviro365.repository.RecyclingTipRepository;
import com.enviro365.enviro365.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public List<RecyclingTip> getRecyclingTipsByCategoryId(Long categoryId) {
        return repository.findByWasteCategory_Id(categoryId);
    }

    public RecyclingTip createRecyclingTip(Long categoryId, RecyclingTip recyclingTip) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Waste Category not found with id: " + categoryId));
        recyclingTip.setWasteCategory(wasteCategory);
        return repository.save(recyclingTip);
    }

    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip) {
        RecyclingTip existingTip = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recycling Tip not found with id: " + id));
        existingTip.setTip(recyclingTip.getTip());
        return repository.save(existingTip);
    }

    public void deleteRecyclingTip(Long id) {
        repository.deleteById(id);
    }
}
