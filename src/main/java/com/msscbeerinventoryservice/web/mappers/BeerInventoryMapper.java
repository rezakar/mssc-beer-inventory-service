package com.msscbeerinventoryservice.web.mappers;

import com.msscbeerinventoryservice.domain.BeerInventory;
import com.msscbeerinventoryservice.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.OffsetDateTime;
import java.util.UUID;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    @Mappings({
            @Mapping(source = "beerId", target = "id"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "lastModifiedDate", target = "lastModifiedDate"),
            @Mapping(source = "beerId", target = "beerId"),
            @Mapping(source = "upc", target = "upc"),
            @Mapping(source = "quantityOnHand", target = "quantityOnHand")
    })
    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
