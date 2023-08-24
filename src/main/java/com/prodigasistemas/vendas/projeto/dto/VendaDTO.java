package com.prodigasistemas.vendas.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO {
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String nome;
    private String cpfCnpj;
    private String endereco;


}
