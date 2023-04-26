package com.msscbeerinventoryservice.service;

import com.msscbeerinventoryservice.web.model.BeerOrderDto;

public interface AllocationService {

    Boolean allocateOrder (BeerOrderDto beerOrderDto);

    void deallocateOrder (BeerOrderDto beerOrderDto);
}
