package com.example.code_challenge_backend.purchase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.code_challenge_backend.purchase.entity.PriceListEntity;

@Repository
public interface PriceListRepository extends JpaRepository<PriceListEntity, Long>{

    @Query("SELECT pl FROM PriceListEntity pl JOIN FETCH pl.product WHERE pl.product.id = :id")
    Optional<PriceListEntity> findByProductId(@Param("id") Long id);

    @Query("SELECT pl FROM PriceListEntity pl " +
           "JOIN FETCH pl.product p " +
           "JOIN FETCH p.categoria c " +
           "WHERE c.id = :categoriaId")
    Optional<List<PriceListEntity>> findByCategoriaId(@Param("categoriaId") Long categoriaId);

    List<PriceListEntity> findByProductCategoriaIdIn(List<Long> categoriaIds);
}
