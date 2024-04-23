package com.enviro365.enviro365.entity;

import jakarta.persistence.*;
import lombok.Data;

//Data makes the getters, setters, ToString and the constructors
@Data
@Entity
//makes the table for the H2 database
public class DisposalGuideline {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private WasteCategory wasteCategory;


    private String guideline;


}