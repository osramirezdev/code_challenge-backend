package com.example.code_challenge_backend.warehouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.code_challenge_backend.warehouse.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    @Query("SELECT p FROM ProductEntity p JOIN FETCH p.categoria WHERE p.id = :id")
    Optional<ProductEntity> findByIdWithCat(@Param("id") Long id);
}
