package com.algaworks.algalog.services;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.StatusEntrega;

import com.algaworks.algalog.repositories.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

  private CatalogoClienteService catalogoClienteService;
  private EntregaRepository entregaRepository;
  

  @Transactional
  public Entrega solicitar(Entrega entrega) {
    Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

    entrega.setCliente(cliente);
    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataPedido(OffsetDateTime.now());

    return entregaRepository.save(entrega);

  }
  
}
