package com.example.HardwareStore.usescases;

import com.example.HardwareStore.collection.Bill;
import com.example.HardwareStore.dto.BillDTO;
import com.example.HardwareStore.mapper.BillMapper;
import com.example.HardwareStore.repository.BillRepository;
import com.example.HardwareStore.usecases.GetAllBillsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@SpringBootTest
public class GetAllBillsUseCaseTest {

    private GetAllBillsUseCase getAllBillsUseCase;

    @Autowired
    private BillMapper billMapper;

    @Mock
    BillRepository billRepository;

    @BeforeEach
    void setUp() {
        getAllBillsUseCase = new GetAllBillsUseCase(billRepository, billMapper);
    }

    @Test
    void getBillUseCase() {

        Bill bill = new Bill(
                "x",
                "X",
                "X",
                "X",
                4,
                8
        );

        Bill bill1 = new Bill(
                "y",
                "y",
                "y",
                "y",
                3,
                9
        );

        Mockito.when(billRepository.findAll()).thenReturn(Flux.just(bill,bill1));
        Flux<BillDTO> flux = getAllBillsUseCase.getAllBills();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(billRepository).findAll();
    }

}
