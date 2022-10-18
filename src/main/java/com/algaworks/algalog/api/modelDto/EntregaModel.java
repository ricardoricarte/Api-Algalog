package com.algaworks.algalog.api.modelDto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {

  private Long id;
  private ClienteResumoModel Cliente;
  private DestinatarioModel destinatario;
  private BigDecimal taxa;
  private StatusEntrega status;
  private OffsetDateTime dataPedido;
  private OffsetDateTime dataFinalizacao;
  
}
