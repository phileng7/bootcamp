package com.example.bootcamp.controller;

import com.example.bootcamp.model.dto.StockDTO;
import com.example.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// CrossOrigin - avoid issues with CORS
@CrossOrigin
@RestController
@RequestMapping(value="/stock")
public class StockController {

  @Autowired
  private StockService stockService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
    return ResponseEntity.ok(stockService.save(dto));
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {
    return ResponseEntity.ok(stockService.update(dto));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<StockDTO>> findAll() {
    return ResponseEntity.ok(stockService.findAll());
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StockDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(stockService.findById(id));
  }
}
