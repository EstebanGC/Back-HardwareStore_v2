package com.example.HardwareStore.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "provider")
public class Provider {

    @Id
    private String id;
    private String providerName;
    private String email;
    private String passport;
}
