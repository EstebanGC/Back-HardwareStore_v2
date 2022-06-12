package com.example.HardwareStore.usescases;

import com.example.HardwareStore.collection.Provider;
import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.repository.ProviderRepository;
import com.example.HardwareStore.usecases.CreateProviderUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class CreateProviderUseCaseTest {

    @MockBean
    private CreateProviderUseCase createProviderUseCase;

    @Mock
    ProviderRepository providerRepository;

    @Test
    public void createProviderTest(){

        Provider provider = new Provider(
                "X",
                "X",
                "X",
                "X"
        );

        ProviderDTO providerDTO = new ProviderDTO();

        providerDTO.setId(provider.getId());
        providerDTO.setProviderName(provider.getProviderName());
        providerDTO.setEmail(provider.getEmail());
        providerDTO.setPassport(provider.getPassport());


        StepVerifier.create(Mono.just(Mockito.when(createProviderUseCase.createProvider(providerDTO))
                        .thenReturn(Mono.just(providerDTO))))
                .expectComplete();
    }
}
