package com.example.lc.bootstrap;

import com.example.lc.domain.Beer;
import com.example.lc.repositories.BeerRepository;
import lombok.var;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
    private BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if (beerRepository.count() == 0)
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityOnBrew(200)
                    .upc(337_000_111L)
                    .minOnHand(12)
                    .price(new BigDecimal("12.95"))
                    .build());

        beerRepository.save(Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle("PALE_ALE")
                .quantityOnBrew(200)
                .upc(337_000_121L)
                .minOnHand(12)
                .price(new BigDecimal("12.95"))
                .build());

        System.out.println("Loaded beers: "+beerRepository.count());
    }
}
