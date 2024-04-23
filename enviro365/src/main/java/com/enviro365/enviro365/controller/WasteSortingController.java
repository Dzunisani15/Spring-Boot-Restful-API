package com.enviro365.enviro365.controller;

import com.enviro365.enviro365.entity.DisposalGuideline;
import com.enviro365.enviro365.entity.RecyclingTip;
import com.enviro365.enviro365.entity.WasteCategory;
import com.enviro365.enviro365.service.DisposalGuidelineService;
import com.enviro365.enviro365.service.RecyclingTipService;
import com.enviro365.enviro365.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class WasteSortingController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @Autowired
    private RecyclingTipService recyclingTipService;

    // Get all waste categories
    @GetMapping("/wasteCategories")
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories(@RequestParam("type") String type) {
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllWasteCategories();
        return ResponseEntity.ok(wasteCategories);
    }

    // Create a new waste category
    @PostMapping("/wasteCategories")
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        WasteCategory createdCategory = wasteCategoryService.createWasteCategory(wasteCategory);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // Update a waste category
    @PutMapping("/wasteCategories/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(
            @PathVariable Long id,
            @Valid @RequestBody WasteCategory wasteCategory) {
        WasteCategory updatedCategory = wasteCategoryService.updateWasteCategory(id, wasteCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete a waste category
    @DeleteMapping("/wasteCategories/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }

    // Get all disposal guidelines for a waste category
    @GetMapping("/wasteCategories/{categoryId}/disposalGuidelines")
    public ResponseEntity<List<DisposalGuideline>> getDisposalGuidelinesByCategoryId(@PathVariable Long categoryId) {
        List<DisposalGuideline> disposalGuidelines = disposalGuidelineService.getDisposalGuidelinesByCategoryId(categoryId);
        return ResponseEntity.ok(disposalGuidelines);
    }

    // Create a new disposal guideline for a waste category
    @PostMapping("/wasteCategories/{categoryId}/disposalGuidelines")
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(
            @PathVariable Long categoryId,
            @Valid @RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline createdGuideline = disposalGuidelineService.createDisposalGuideline(categoryId, disposalGuideline);
        return new ResponseEntity<>(createdGuideline, HttpStatus.CREATED);
    }

    // Update a disposal guideline
    @PutMapping("/disposalGuidelines/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(
            @PathVariable Long id,
            @Valid @RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline updatedGuideline = disposalGuidelineService.updateDisposalGuideline(id, disposalGuideline);
        return ResponseEntity.ok(updatedGuideline);
    }

    // Delete a disposal guideline
    @DeleteMapping("/disposalGuidelines/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }

    // Get all recycling tips for a waste category
    @GetMapping("/wasteCategories/{categoryId}/recyclingTips")
    public ResponseEntity<List<RecyclingTip>> getRecyclingTipsByCategoryId(@PathVariable Long categoryId) {
        List<RecyclingTip> recyclingTips = recyclingTipService.getRecyclingTipsByCategoryId(categoryId);
        return ResponseEntity.ok(recyclingTips);
    }

    // Create a new recycling tip for a waste category
    @PostMapping("/wasteCategories/{categoryId}/recyclingTips")
    public ResponseEntity<RecyclingTip> createRecyclingTip(
            @PathVariable Long categoryId,
            @Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip createdTip = recyclingTipService.createRecyclingTip(categoryId, recyclingTip);
        return new ResponseEntity<>(createdTip, HttpStatus.CREATED);
    }

    // Update a recycling tip
    @PutMapping("/recyclingTips/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(
            @PathVariable Long id,
            @Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip updatedTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);
        return ResponseEntity.ok(updatedTip);
    }

    // Delete a recycling tip
    @DeleteMapping("/recyclingTips/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}