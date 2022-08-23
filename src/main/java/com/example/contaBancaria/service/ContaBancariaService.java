package com.example.contaBancaria.service;

import com.example.contaBancaria.respository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {

    @Autowired
    ContaBancariaRepository contaBancariaRepository;


}

