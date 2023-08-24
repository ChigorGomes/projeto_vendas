package com.prodigasistemas.vendas.projeto.entities;

import com.prodigasistemas.vendas.projeto.dto.VendaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Table(name = "sale")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venda implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String cpfCnpj;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String nome;
    private String endereco;

    public VendaDTO toDTO() {
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setDescricao(descricao);
        vendaDTO.setPreco(preco);
        vendaDTO.setQuantidade(quantidade);
        vendaDTO.setNome(nome);
        vendaDTO.setCpfCnpj(cpfCnpj);
        vendaDTO.setEndereco(endereco);
        return vendaDTO;
    }
}
