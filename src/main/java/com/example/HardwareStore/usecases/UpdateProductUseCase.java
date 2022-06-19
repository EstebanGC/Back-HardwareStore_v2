package com.example.HardwareStore.usecases;

import com.example.HardwareStore.dto.ProductDTO;
import com.example.HardwareStore.mapper.ProductMapper;
import com.example.HardwareStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UpdateProductUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Mono<ProductDTO> putProduct(ProductDTO productDTO){
        return productRepository.save(productMapper.fromProductDTOToProduct(productDTO)).map(productMapper::fromProductToProductDTO);
    }
}
