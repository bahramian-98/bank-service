package com.example.bank.customer;

import com.example.bank.model.customer.CustomerRequestDTO;
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
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveTest() throws Exception {

        CustomerRequestDTO requestDTO = new CustomerRequestDTO();
        requestDTO.setFirstName("فاطمه");
        requestDTO.setLastName("بهرامیان");
        requestDTO.setMobileNumber("7665554");
        requestDTO.setNationalCode("11111");
        requestDTO.setAddress("سمیرم");

        MvcResult mvcResult = this.mockMvc.perform(post("/customer/save")
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

        MvcResult mvcResult = this.mockMvc.perform(get("/customer?page=1&size=50&sort=created,desc")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("listTest result : " + content);
    }

    @Test
    public void findByNationalCode() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/customer/byNationalCode?nationalCode=5436677777&pageNumber=1&pageSize=50&sort=created,desc")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("findByNationalCode result : " + content);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
