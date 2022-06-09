package com.example.HardwareStore.usecases;

import com.example.HardwareStore.dto.ProductDTO;import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.mapper.ProductMapper;
import com.example.HardwareStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@AllArgsConstructor
public class GetAllProductsUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Flux<ProductDTO> getAllProducts() {
        return productRepository.findAll().map(productMapper::fromProductToProductDTO);
    }
}
