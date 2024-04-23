package com.enviro365.enviro365.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
//Data makes the getters, setters, ToString and the constructors
@Data
@Entity
//makes the table for the H2 database
public class WasteCategory {

    @GeneratedValue
    @Id
    private Long id;

    private String name;


}
