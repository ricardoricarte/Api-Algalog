package com.algaworks.algalog.services;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.repositories.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

  private EntregaRepository entregaRepository;

  public Entrega buscar(Long entregaId) {
    return entregaRepository.findById(entregaId)
              .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não Encontrada"));

  }

  
}
