package com.example.contaBancaria.respository;

import com.example.contaBancaria.model.ContaBancariaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancariaModel, Long> {
}
