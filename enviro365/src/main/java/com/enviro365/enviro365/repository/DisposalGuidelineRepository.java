package com.enviro365.enviro365.repository;

import com.enviro365.enviro365.entity.DisposalGuideline;
import com.enviro365.enviro365.entity.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    List<DisposalGuideline> findByWasteCategory_Id(Long categoryId);
}