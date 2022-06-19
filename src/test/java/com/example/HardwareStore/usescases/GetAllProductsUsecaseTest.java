package com.example.HardwareStore.usescases;

import com.example.HardwareStore.collection.Product;
import com.example.HardwareStore.collection.Provider;
import com.example.HardwareStore.dto.BillDTO;
import com.example.HardwareStore.dto.ProductDTO;
import com.example.HardwareStore.mapper.ProductMapper;
import com.example.HardwareStore.repository.ProductRepository;
import com.example.HardwareStore.usecases.GetAllProductsUseCase;
import com.example.HardwareStore.usecases.GetAllProvidersUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class GetAllProductsUsecaseTest {

    private GetAllProductsUseCase getAllProductsUseCase;

    @Autowired
    private ProductMapper productMapper;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        getAllProductsUseCase = new GetAllProductsUseCase(productRepository, productMapper);
    }

    @Test
    void getProductsUseCase() {

        Provider provider = new Provider(
                "w",
                "w",
                "w",
                "w"
        );

        Provider provider1 = new Provider(
                "v",
                "v",
                "v",
                "v"
        );
        Product product = new Product (
                "x",
                "x",
                4.2,
                "x",
<<<<<<< HEAD
                2,
=======
                9,
>>>>>>> fc2bb715b47964f86ec4902d04f5a1f6cf0c96dc
                4,
                20,
                8,
                provider
        );

        Product product1 = new Product(
                "y",
                "y",
                3.5,
                "y",
<<<<<<< HEAD
                2,
=======
                8,
>>>>>>> fc2bb715b47964f86ec4902d04f5a1f6cf0c96dc
                5,
                19,
                7,
                provider1
        );

        Mockito.when(productRepository.findAll()).thenReturn(Flux.just(product,product1));
        Flux<ProductDTO> flux = getAllProductsUseCase.getAllProducts();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(productRepository).findAll();
    }
}
