package com.example.HardwareStore.repository;


import com.example.HardwareStore.collection.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends ReactiveMongoRepository<Receipt, String> {
}
