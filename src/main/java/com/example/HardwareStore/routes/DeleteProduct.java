package com.example.HardwareStore.routes;

import com.example.HardwareStore.dto.ProductDTO;
import com.example.HardwareStore.usecases.DeleteProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProduct {

    @Bean

    @RouterOperation(operation = @Operation(description = "Delete product ", operationId = "deleteProduct", tags = "Product",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDTO.class)))))

    public RouterFunction<ServerResponse> deleteProductRouter(DeleteProductUseCase deleteProductUseCase){
        return route(DELETE("/delete/product/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteProductUseCase.deleteProductById(request.pathVariable("id"))
                        .flatMap(notused -> ServerResponse.status(HttpStatus.ACCEPTED).build()));
    }
}
