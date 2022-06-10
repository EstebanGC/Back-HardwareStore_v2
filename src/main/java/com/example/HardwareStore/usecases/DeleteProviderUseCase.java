package com.example.HardwareStore.usecases;

import com.example.HardwareStore.mapper.ProductMapper;
import com.example.HardwareStore.mapper.ProviderMapper;
import com.example.HardwareStore.repository.ProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProviderUseCase {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public DeleteProviderUseCase(ProviderRepository providerRepository, ProviderMapper providerMapper){
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
    }

    public Mono<Void> deleteProviderById(String id) {
        return providerRepository.deleteById(id);
    }
}
