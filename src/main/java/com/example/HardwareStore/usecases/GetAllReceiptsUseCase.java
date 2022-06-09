package com.example.HardwareStore.usecases;

import com.example.HardwareStore.dto.ReceiptDTO;
import com.example.HardwareStore.mapper.ReceiptMapper;
import com.example.HardwareStore.repository.ReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllReceiptsUseCase {

    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    public Flux<ReceiptDTO> getAllReceipts() {
        return receiptRepository.findAll().map(receiptMapper::fromReceiptToReceiptDTO);
    }
}
