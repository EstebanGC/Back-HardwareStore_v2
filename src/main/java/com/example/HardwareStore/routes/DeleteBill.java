package com.example.HardwareStore.routes;

import com.example.HardwareStore.usecases.DeleteBillUseCase;
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
public class DeleteBill {

    @Bean
    public RouterFunction<ServerResponse> deleteBillRouter(DeleteBillUseCase deleteBillUseCase){
        return route(DELETE("/delete/bill/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteBillUseCase.deleteBillById(request.pathVariable("id"))
                        .flatMap(notused -> ServerResponse.status(HttpStatus.ACCEPTED).build()));
    }
}
