package com.example.HardwareStore.usescases;


import com.example.HardwareStore.collection.Receipt;
import com.example.HardwareStore.dto.ReceiptDTO;
import com.example.HardwareStore.mapper.ReceiptMapper;
import com.example.HardwareStore.repository.ReceiptRepository;
import com.example.HardwareStore.usecases.GetAllReceiptsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class GetAllReceiptsUseCaseTest {

    private GetAllReceiptsUseCase getAllReceiptsUseCase;

    @Autowired
    private ReceiptMapper receiptMapper;

    @Mock
    ReceiptRepository receiptRepository;

    @BeforeEach
    void setUp() {
        getAllReceiptsUseCase = new GetAllReceiptsUseCase(receiptRepository, receiptMapper);
    }

    @Test
    void getReceiptUseCase(){

        Receipt receipt = new Receipt(
                "x",
                "x",
                3,
                "x",
                "x"
        );

        Receipt receipt1 = new Receipt(
                "y",
                "y",
                7,
                "y",
                "y"
        );

        Mockito.when(receiptRepository.findAll()).thenReturn(Flux.just(receipt,receipt1));
        Flux<ReceiptDTO> flux = getAllReceiptsUseCase.getAllReceipts();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(receiptRepository).findAll();
    }
}
