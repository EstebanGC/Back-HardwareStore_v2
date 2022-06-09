package com.example.HardwareStore.routes;

import com.example.HardwareStore.dto.ProductDTO;
import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.usecases.GetAllProductsUseCase;
import com.example.HardwareStore.usecases.GetAllProvidersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProducts {

    @Bean
    public RouterFunction<ServerResponse> getAllProductsRouter(GetAllProductsUseCase getAllProductsUseCase) {
        return route(GET("/getallproducts"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProductsUseCase.getAllProducts(), ProductDTO.class)));
    }
}
