package com.example.HardwareStore.usescases;

import com.example.HardwareStore.collection.Product;
import com.example.HardwareStore.collection.Provider;
import com.example.HardwareStore.collection.Receipt;
import com.example.HardwareStore.dto.ProductDTO;
import com.example.HardwareStore.dto.ReceiptDTO;
import com.example.HardwareStore.repository.ProductRepository;
import com.example.HardwareStore.repository.ReceiptRepository;
import com.example.HardwareStore.usecases.CreateProductUseCase;
import com.example.HardwareStore.usecases.CreateReceiptUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class CreateReceiptUseCaseTest {

    @MockBean
    private CreateReceiptUseCase createReceiptUseCase;

    @Mock
    ReceiptRepository receiptRepository;

    @Test
    public void createReceiptTest(){

        Provider provider = new Provider(
                "w",
                "w",
                "w",
                "w"
        );

        Product product = new Product(
                "a",
                "a",
                150.2,
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
                150.2,
                "b",
                0,
                0,
                20,
                50,
                provider
        );

        Receipt receipt = new Receipt(
                "x",
                5,
                product1,
                "x"
        );

        ReceiptDTO receiptDTO = new ReceiptDTO();

        receiptDTO.setId(receiptDTO.getId());
        receiptDTO.setProviders(receiptDTO.getProviders());
        receiptDTO.setUnits(receiptDTO.getUnits());
        receiptDTO.setProductId(receiptDTO.getProductId());
        receiptDTO.setDate(receiptDTO.getDate());


        StepVerifier.create(Mono.just(Mockito.when(createReceiptUseCase.createReceipt(receiptDTO))
                        .thenReturn(Mono.just(receiptDTO))))
                .expectComplete();
    }
}
