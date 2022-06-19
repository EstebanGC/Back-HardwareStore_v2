package com.example.HardwareStore.dto;


import com.example.HardwareStore.collection.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReceiptDTO {

    private String id;
    private Provider providers;
    private Integer units;
    private String productId;
    private String date;

    public ReceiptDTO(){

    }

}


