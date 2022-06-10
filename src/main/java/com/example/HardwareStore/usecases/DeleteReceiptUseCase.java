package com.example.HardwareStore.usecases;

import com.example.HardwareStore.mapper.ReceiptMapper;
import com.example.HardwareStore.repository.ReceiptRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteReceiptUseCase {

    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    public DeleteReceiptUseCase(ReceiptRepository receiptRepository, ReceiptMapper receiptMapper){
        this.receiptRepository=receiptRepository;
        this.receiptMapper=receiptMapper;
    }

    public Mono<Void> deleteReceiptById(String id){
        return receiptRepository.deleteById(id);
    }
}
