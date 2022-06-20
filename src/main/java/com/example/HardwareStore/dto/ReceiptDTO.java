package com.example.HardwareStore.dto;

import com.example.HardwareStore.collection.Product;
import com.example.HardwareStore.collection.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class ReceiptDTO {

    private String id;
    private Integer units;
    private Product product;
    private String date;

    public ReceiptDTO(){

    }

}


