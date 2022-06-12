package com.example.HardwareStore.usecases;


import com.example.HardwareStore.dto.ReceiptDTO;
import com.example.HardwareStore.mapper.ReceiptMapper;
import com.example.HardwareStore.repository.ReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class
CreateReceiptUseCase {

    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    public Mono<ReceiptDTO> createReceipt(ReceiptDTO receiptDTO) {
        return receiptRepository.save(receiptMapper.fromReceipDTOToReceipt(receiptDTO))
                .map(receiptMapper::fromReceiptToReceiptDTO);
    }
}
