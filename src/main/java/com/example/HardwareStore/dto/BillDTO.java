package com.example.HardwareStore.dto;

import com.example.HardwareStore.collection.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
public class BillDTO {

    private String id;
    private String date;
    private String clientName;
    private String sellerName;
    private Integer productsSold;
    private Integer totalSale;

    public BillDTO() {

    }

}

