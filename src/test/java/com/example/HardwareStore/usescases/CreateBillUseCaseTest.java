package com.example.HardwareStore.usescases;

import com.example.HardwareStore.collection.Bill;
import com.example.HardwareStore.collection.Product;
import com.example.HardwareStore.collection.Provider;
import com.example.HardwareStore.dto.BillDTO;
import com.example.HardwareStore.repository.BillRepository;
import com.example.HardwareStore.usecases.CreateBillUseCase;
import com.example.HardwareStore.usecases.GetAllBillsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CreateBillUseCaseTest {

    @MockBean
    private CreateBillUseCase createBillUseCase;

    @Mock
    BillRepository billRepository;

    @Test
    public void setCreateBillUseCase() {

        Provider provider = new Provider(
                "w",
                "w",
                "w",
                "w"
        );

        Product product = new Product(
                "x",
                "x",
                4,
                "x",
                1,
                4,
                20,
                8,
                provider
        );
        List<Product> products = new ArrayList<>();
        products.add(product);


        Bill bill = new Bill (
                "X",
                "X",
                "X",
                "X",
                products,
                100
        );

        BillDTO billDTO = new BillDTO();

        billDTO.setDate(bill.getDate());
        billDTO.setClientName(bill.getClientName());
        billDTO.setClientName(bill.getClientName());
        billDTO.setSellerName(bill.getSellerName());
        billDTO.setTotalSale(bill.getTotalSale());
    }
}
