package com.msscbeerinventoryservice.web.controller;

import com.msscbeerinventoryservice.domain.BeerInventory;
import com.msscbeerinventoryservice.repository.BeerInventoryRepository;
import com.msscbeerinventoryservice.web.mappers.BeerInventoryMapper;
import com.msscbeerinventoryservice.web.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerInventoryMapper beerInventoryMapper;

    @GetMapping("api/v1/beer/inventories/{beerId}")
    List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId){
        log.debug("Finding Inventory for beerId:" + beerId);
        System.out.println(beerInventoryRepository.findAllByBeerId(beerId));

        return beerInventoryRepository.findAllByBeerId(beerId)
                .stream()
                .map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }

    @GetMapping("api/v1/beer/inventory/{beerId}")
    BeerInventoryDto getBeersById(@PathVariable UUID beerId){
        log.debug("Finding Inventory for beerId:" + beerId);
//        System.out.println(beerInventoryRepository.findByBeerId(beerId).getUpc());
//        return beerInventoryRepository.findByBeerId(beerId);

        return beerInventoryMapper.beerInventoryToBeerInventoryDto(beerInventoryRepository.findByBeerId(beerId));
    }

    @GetMapping("api/v1/beer/inventory/{upc}/upc")
    List<BeerInventoryDto> getBeerByUpc(@PathVariable String upc){
        log.debug("Finding Inventory for beerId:" + upc);
        System.out.println(beerInventoryRepository.findByUpc(upc));

        return beerInventoryRepository.findByUpc(upc)
                .stream()
                .map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }
}
