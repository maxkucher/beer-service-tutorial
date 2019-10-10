package com.example.lc.web.controller;

import com.example.lc.domain.Beer;
import com.example.lc.web.model.BeerDto;
import com.example.lc.web.model.BeerStyleEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto dto = getValidBeerDto();
        String beerDtoJSON = mapper.writeValueAsString(dto);
        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString())
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoJSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void updateBeerById() {
    }

    BeerDto getValidBeerDto() {
        return BeerDto
                .builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(1230203101L)
                .build();
    }
}
