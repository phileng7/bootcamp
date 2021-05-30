package com.example.bootcamp.repository;

import com.example.bootcamp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    // Return a register that has this name and date BUT it is not me (id)
    @Query( "SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")
  Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);
}
