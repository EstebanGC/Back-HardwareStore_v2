package com.example.HardwareStore.usescases;

import com.example.HardwareStore.collection.Product;
import com.example.HardwareStore.collection.Provider;
import com.example.HardwareStore.dto.ProductDTO;
import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.repository.ProductRepository;
import com.example.HardwareStore.repository.ProviderRepository;
import com.example.HardwareStore.usecases.CreateProductUseCase;
import com.example.HardwareStore.usecases.CreateProviderUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class CreateProductUseCaseTest {

    @MockBean
    private CreateProductUseCase createProductUseCase;

    @Mock
    ProductRepository productRepository;

    @Test
    public void createProviderTest(){

        Product product = new Product(
                "x",
                "x",
                4.2,
                "x",
                4,
                20,
                8,
                "x"
        );

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setMinUnits(product.getMinUnits());
        productDTO.setMaxUnits(product.getMaxUnits());
        productDTO.setProviders(product.getProviders());


        StepVerifier.create(Mono.just(Mockito.when(createProductUseCase.createProduct(productDTO))
                        .thenReturn(Mono.just(productDTO))))
                .expectComplete();
    }
}
