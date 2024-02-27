package com.ahmed.app.repository;

import com.ahmed.app.model.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FraudRepository extends JpaRepository<Fraud,Integer> {
}
