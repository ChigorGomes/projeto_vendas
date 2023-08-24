package com.prodigasistemas.vendas.projeto.services;

import com.prodigasistemas.vendas.projeto.entities.Venda;
import com.prodigasistemas.vendas.projeto.exceptions.ResourceNotFoundException;
import com.prodigasistemas.vendas.projeto.repositories.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.prodigasistemas.vendas.projeto.utils.Constants.COLUMS;
import static com.prodigasistemas.vendas.projeto.utils.Constants.FILE_EXCEPTION;

@Service
public class VendasService {
    @Autowired
    private VendasRepository vendasRepository;

    public Double store(MultipartFile file) throws IOException {
        List<Venda> vendaList = new ArrayList<>();
        try {
            InputStream inputStream = new ByteArrayInputStream(file.getBytes());
            BufferedReader bfReader = new BufferedReader(new InputStreamReader(inputStream));
            if (!file.isEmpty()) {
                Double valorBruto = 0.0;
                List<String> columsFile = List.of(bfReader.readLine().replaceFirst("\\r?\\n|\\r", "").split("\s+"));
                boolean isEqualColums = CollectionUtils.containsAny(COLUMS, columsFile);
                if (isEqualColums) {
                    String linha;
                    while ((linha = bfReader.readLine()) != null) {
                        linha = linha.replaceAll("\"", "");
                        List<String> texto = List.of(linha.split("\s{2,}"));
                        Venda venda = new Venda();
                        venda.setDescricao(texto.get(0));
                        venda.setPreco(Double.parseDouble(texto.get(1)));
                        venda.setQuantidade(Integer.parseInt(texto.get(2)));
                        venda.setNome(texto.get(3));
                        venda.setCpfCnpj(texto.get(4));
                        venda.setEndereco(texto.get(5));
                        vendaList.add(venda);
                        valorBruto += venda.getPreco() * venda.getQuantidade();
                    }
                    vendasRepository.saveAll(vendaList);
                    return valorBruto;
                }

            }


        } catch (IOException e) {
            e.fillInStackTrace();
        }
        throw new IOException(FILE_EXCEPTION);

    }

    public List<Venda> listAll() throws IOException {
        return vendasRepository.findAll();
    }

    public Venda findById(String cpfCnpj) {
        return vendasRepository.findById(cpfCnpj).orElseThrow(() -> new ResourceNotFoundException(cpfCnpj));
    }

}
