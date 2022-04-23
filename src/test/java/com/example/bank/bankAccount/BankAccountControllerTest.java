package com.example.bank.bankAccount;

import com.example.bank.model.bankaccount.BankAccount;
import com.example.bank.model.bankaccount.BankAccountRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class BankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveTest() throws Exception {

        BankAccountRequestDTO requestDTO = new BankAccountRequestDTO();
        requestDTO.setAccountType(BankAccount.AccountType.LOAN);
        requestDTO.setAccountNumber("11111111");
        requestDTO.setCustomerId(2L);

        MvcResult mvcResult = this.mockMvc.perform(post("/bankAccount/save")
                .content(asJsonString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Assertions.assertEquals(HttpStatus.CREATED.value(), mvcResult.getResponse().getStatus());

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("saveTest result : " + content);
    }

    @Test
    public void listTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/bankAccount?page=1&size=20&sort=created,desc")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("listTest result : " + content);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
