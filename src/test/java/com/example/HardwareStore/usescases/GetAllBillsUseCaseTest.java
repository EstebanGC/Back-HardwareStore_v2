package com.example.HardwareStore.usescases;

import com.example.HardwareStore.collection.Bill;
import com.example.HardwareStore.collection.Product;
import com.example.HardwareStore.collection.Provider;
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

import java.util.ArrayList;
import java.util.List;


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

        Provider provider = new Provider(
                "w",
                "w",
                "w",
                "w"
        );

        Provider provider1 = new Provider(
                "u",
                "u",
                "u",
                "u"
        );
        Provider provider2 = new Provider(
                "m",
                "m",
                "m",
                "m"
        );

        Provider provider3 = new Provider(
                "q",
                "q",
                "q",
                "q"
        );

        Product product = new Product(
                "b",
                "b",
                8,
                "b",
                0,
                0,
                20,
                50,
                provider
        );

        Product product1 = new Product(
                "h",
                "h",
                5,
                "h",
                0,
                0,
                20,
                50,
                provider1
        );

        Product product2 = new Product(
                "b",
                "b",
                8,
                "b",
                0,
                0,
                20,
                50,
                provider
        );

        Product product3 = new Product(
                "p",
                "p",
                5,
                "p",
                0,
                0,
                20,
                50,
                provider1
        );

        List<Product> listproducts = new ArrayList<>();
        listproducts.add(product);
        listproducts.add(product1);

        List<Product> listproducts1 = new ArrayList<>();
        listproducts1.add(product2);
        listproducts1.add(product3);


        Bill bill = new Bill(
                "x",
                "X",
                "X",
                "X",
                listproducts,
                8
        );

        Bill bill1 = new Bill(
                "y",
                "y",
                "y",
                "y",
                listproducts1,
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
