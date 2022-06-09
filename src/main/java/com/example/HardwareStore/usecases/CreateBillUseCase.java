package com.example.HardwareStore.usecases;


import com.example.HardwareStore.dto.BillDTO;
import com.example.HardwareStore.mapper.BillMapper;
import com.example.HardwareStore.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateBillUseCase {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    public Mono<BillDTO> createBill(BillDTO billDTO){
        return billRepository.save(billMapper.fromBillDTOToBill(billDTO)).map(billMapper::fromBillToBillDTO);
    }

}
