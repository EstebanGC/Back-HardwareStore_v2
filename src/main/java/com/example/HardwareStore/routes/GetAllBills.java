package com.example.HardwareStore.routes;

import com.example.HardwareStore.dto.BillDTO;
import com.example.HardwareStore.dto.ProductDTO;
import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.usecases.GetAllBillsUseCase;
import com.example.HardwareStore.usecases.GetAllProvidersUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllBills {

    @Bean

    @RouterOperation(operation = @Operation(description = "Get bills ", operationId = "getBills", tags = "Bill",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDTO.class)))))


    public RouterFunction<ServerResponse> getAllBillsRouter(GetAllBillsUseCase getAllBillsUseCase) {
        return route(GET("/getallbills"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllBillsUseCase.getAllBills(), BillDTO.class)));
    }
}
