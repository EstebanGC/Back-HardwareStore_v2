package com.example.HardwareStore.usecases;

import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.mapper.ProviderMapper;
import com.example.HardwareStore.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateProviderUseCase {


    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public Mono<ProviderDTO> createProvider(ProviderDTO providerDTO){
        return providerRepository.save(providerMapper.fromProviderDTOToProvider(providerDTO)).map(providerMapper::fromProviderToProviderDTO);
    }
}

