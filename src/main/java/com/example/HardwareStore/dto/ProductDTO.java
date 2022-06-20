package com.example.HardwareStore.dto;

import com.example.HardwareStore.collection.Product;
import com.example.HardwareStore.collection.Provider;
import com.example.HardwareStore.mapper.ProductMapper;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.List;

@Data
public class ProductDTO {

    private String id;
    private String productName;
    private Integer productPrice;
    private String productDescription;
    private Integer sold;
    private Integer minUnits;
    private Integer maxUnits;
    private Integer availableUnits;
    private Provider providers;

    public ProductDTO() {

    }

}


