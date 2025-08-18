package com.example.code_challenge_backend.purchase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.code_challenge_backend.purchase.entity.OrdersEntity;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Long>{

    @Query("SELECT DISTINCT o FROM OrdersEntity o JOIN FETCH o.details")
    List<OrdersEntity> findAllWithDetails();

}
