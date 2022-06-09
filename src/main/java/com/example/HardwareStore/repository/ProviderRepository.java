package com.example.HardwareStore.repository;

import com.example.HardwareStore.collection.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends ReactiveMongoRepository<Provider, String> {

}
