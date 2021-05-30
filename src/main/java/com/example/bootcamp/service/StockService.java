package com.example.bootcamp.service;

import com.example.bootcamp.exceptions.BusinessException;
import com.example.bootcamp.exceptions.NotFoundException;
import com.example.bootcamp.mapper.StockMapper;
import com.example.bootcamp.model.Stock;
import com.example.bootcamp.model.dto.StockDTO;
import com.example.bootcamp.repository.StockRepository;
import com.example.bootcamp.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private StockMapper mapper;

  @Transactional
  public StockDTO save(StockDTO dto) {
    Optional<Stock> optionalStock = stockRepository.findByNameAndDate(dto.getName(), dto.getDate());
    if (optionalStock.isPresent()) {     //register was found
      throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
    }
    Stock stock = mapper.toEntity(dto);
    stockRepository.save(stock);
    return mapper.toDTO(stock);
  }

  @Transactional
  public StockDTO update(StockDTO dto) {
    Optional<Stock> optionalStock = stockRepository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
    if (optionalStock.isPresent()) {
      throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
    }
    Stock stock = mapper.toEntity(dto);
    stockRepository.save(stock);
    return mapper.toDTO(stock);
  }

  @Transactional(readOnly = true)
  public List<StockDTO> findAll() {
    List<Stock> list = stockRepository.findAll();
    return mapper.toDTO(list);
  }

  @Transactional(readOnly = true)
  public StockDTO findById(Long id) {
    return stockRepository.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
  }
}
