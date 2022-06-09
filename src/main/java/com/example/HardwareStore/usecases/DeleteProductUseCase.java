package com.example.HardwareStore.usecases;

import com.example.HardwareStore.mapper.ProductMapper;
import com.example.HardwareStore.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public DeleteProductUseCase(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper=productMapper;
    }

    public Mono<Void> deleteProductById(String id){
        return productRepository.deleteById(id);
    }
}
