package com.example.HardwareStore.usecases;


import com.example.HardwareStore.dto.BillDTO;
import com.example.HardwareStore.mapper.BillMapper;
import com.example.HardwareStore.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllBillsUseCase {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    public Flux<BillDTO> getAllBills(){
        return billRepository.findAll().map(billMapper::fromBillToBillDTO);
    }
}
