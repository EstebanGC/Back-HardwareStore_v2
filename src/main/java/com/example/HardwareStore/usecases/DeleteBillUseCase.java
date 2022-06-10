package com.example.HardwareStore.usecases;


import com.example.HardwareStore.mapper.BillMapper;
import com.example.HardwareStore.repository.BillRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteBillUseCase {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    public DeleteBillUseCase(BillRepository billRepository, BillMapper billMapper) {
        this.billRepository=billRepository;
        this.billMapper=billMapper;
    }
    public Mono<Void> deleteBillById(String id){
        return billRepository.deleteById(id);
    }
}
