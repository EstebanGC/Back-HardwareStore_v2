package com.example.HardwareStore.usecases;


import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.mapper.ProductMapper;
import com.example.HardwareStore.mapper.ProviderMapper;
import com.example.HardwareStore.repository.ProductRepository;
import com.example.HardwareStore.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProvidersUseCase {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public Flux<ProviderDTO> getAllProviders() {
        return providerRepository.findAll().map(providerMapper::fromProviderToProviderDTO);
    }
}
