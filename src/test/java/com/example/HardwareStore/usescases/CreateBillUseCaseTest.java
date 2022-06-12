package com.example.HardwareStore.usescases;

import com.example.HardwareStore.collection.Bill;
import com.example.HardwareStore.dto.BillDTO;
import com.example.HardwareStore.repository.BillRepository;
import com.example.HardwareStore.usecases.CreateBillUseCase;
import com.example.HardwareStore.usecases.GetAllBillsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CreateBillUseCaseTest {

    @MockBean
    private CreateBillUseCase createBillUseCase;

    @Mock
    BillRepository billRepository;

    @Test
    public void setCreateBillUseCase() {

        Bill bill = new Bill (
                "X",
                "X",
                "X",
                "X",
                 7,
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
