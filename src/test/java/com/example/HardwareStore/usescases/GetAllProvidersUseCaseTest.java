package com.example.HardwareStore.usescases;


import com.example.HardwareStore.collection.Provider;
import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.mapper.ProviderMapper;
import com.example.HardwareStore.repository.ProviderRepository;
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
class GetAllProvidersUseCaseTest {

    private GetAllProvidersUseCase getAllProvidersUseCase;

    @Autowired
    private ProviderMapper providerMapper;

    @Mock
    ProviderRepository providerRepository;

    @BeforeEach
    void setUp() {
        getAllProvidersUseCase = new GetAllProvidersUseCase(providerRepository, providerMapper);
    }

    @Test
    void getProviderUseCase() {

        Provider provider = new Provider(
                "x",
                "X",
                "X",
                "X"
        );

        Provider provider2 = new Provider(
                "Y",
                "Y",
                "Y",
                "Y"
        );

        Mockito.when(providerRepository.findAll()).thenReturn(Flux.just(provider,provider2));
        Flux<ProviderDTO> flux = getAllProvidersUseCase.getAllProviders();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(providerRepository).findAll();
    }
}
