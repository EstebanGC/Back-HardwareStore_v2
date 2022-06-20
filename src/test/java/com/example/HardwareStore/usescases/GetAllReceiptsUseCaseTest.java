package com.example.HardwareStore.usescases;


import com.example.HardwareStore.collection.Product;
import com.example.HardwareStore.collection.Provider;
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
        Provider provider = new Provider(
                "w",
                "w",
                "w",
                "w"
        );

        Provider provider1 = new Provider(
                "n",
                "n",
                "n",
                "n"
        );

        Product product = new Product(
                "a",
                "a",
                150,
                "a",
                0,
                0,
                20,
                50,
                provider
        );
        Product product1 = new Product(
                "b",
                "b",
                150,
                "b",
                0,
                0,
                20,
                50,
                provider
        );
        Receipt receipt = new Receipt(
                "x",
                3,
                product,
                "x"
        );

        Receipt receipt1 = new Receipt(
                "idReceipt2",
                10,
                product1,
                "12/06/22"
        );

        Mockito.when(receiptRepository.findAll()).thenReturn(Flux.just(receipt,receipt1));
        Flux<ReceiptDTO> flux = getAllReceiptsUseCase.getAllReceipts();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(receiptRepository).findAll();
    }
}
