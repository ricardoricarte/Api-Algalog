package com.algaworks.algalog.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.exceptions.NegocioException;
import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.repositories.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

  private ClienteRepository clienteRepository;

  public Cliente buscar(Long cLienteId) {
   return clienteRepository.findById(cLienteId)
    .orElseThrow(() -> new NegocioException("Cliente não Encontrado"));

  }

  @Transactional
  public Cliente salvar(Cliente cliente) {
    boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                        .stream()
                        .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
    if (emailEmUso) {
      throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
    }

    return clienteRepository.save(cliente);
    
  }

  @Transactional
  public void excluir(Long clienteId) {
    clienteRepository.deleteById(clienteId);
  }
  
}
