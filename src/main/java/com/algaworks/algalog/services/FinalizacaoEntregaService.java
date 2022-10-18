package com.algaworks.algalog.services;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.repositories.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

  private EntregaRepository entregaRepository;
  private BuscaEntregaService buscaEntregaService;

  @Transactional
  public void finalizar(Long entregaId) {
    Entrega entrega = buscaEntregaService.buscar(entregaId);

    entrega.finalizar();

    entregaRepository.save(entrega);


  }
  
  
}
