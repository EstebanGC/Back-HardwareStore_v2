package com.example.HardwareStore.collection;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="receipt")
public class Receipt {

    @Id
    private String id;
    private Integer units;
    private Product product;
    private String date;

}