package com.example.HardwareStore.mapper;

import com.example.HardwareStore.collection.Receipt;
import com.example.HardwareStore.dto.ReceiptDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ReceiptMapper {

    private final ModelMapper modelMapper;

    public ReceiptMapper(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public ReceiptDTO fromReceiptToReceiptDTO(Receipt receipt) {
        return modelMapper.map(receipt, ReceiptDTO.class);
    }

    public Receipt fromReceipDTOToReceipt(ReceiptDTO receiptDTO){
        return modelMapper.map(receiptDTO, Receipt.class);
    }
}
