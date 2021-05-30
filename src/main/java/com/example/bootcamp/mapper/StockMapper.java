package com.example.bootcamp.mapper;

import com.example.bootcamp.model.Stock;
import com.example.bootcamp.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public Stock toEntity(StockDTO obj) {
        Stock stock = new Stock();
        stock.setId(obj.getId());
        stock.setName(obj.getName());
        stock.setPrice(obj.getPrice());
        stock.setVariation(obj.getVariation());
        stock.setDate(obj.getDate());
        return stock;
    }

    public StockDTO toDTO(Stock obj) {
        StockDTO dto = new StockDTO();
        dto.setId(obj.getId());
        dto.setName(obj.getName());
        dto.setPrice(obj.getPrice());
        dto.setVariation(obj.getVariation());
        dto.setDate(obj.getDate());
        return dto;
    }

    public List<StockDTO> toDTO(List<Stock> listStock) {
        // listStock.stream() - does the streaming of the list
        // map - each item
        // this::toDTO - the item/obj is used in the method toDTO above as parameter
        // listStock.stream().map(this::toDTO) - return class Collectors
        // collect(Collectors.toList()) - collect converts to List type => Collectors.toList()
        return listStock.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
