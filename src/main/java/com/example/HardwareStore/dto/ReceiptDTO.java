package com.example.HardwareStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;



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


