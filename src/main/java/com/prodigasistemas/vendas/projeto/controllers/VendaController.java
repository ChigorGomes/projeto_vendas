package com.prodigasistemas.vendas.projeto.controllers;

import com.prodigasistemas.vendas.projeto.dto.VendaDTO;
import com.prodigasistemas.vendas.projeto.dto.VendaReceitaBrutaDTO;
import com.prodigasistemas.vendas.projeto.services.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class VendaController {
    @Autowired
    private VendasService vendasService;


    @PostMapping("/upload")
    public ResponseEntity<VendaReceitaBrutaDTO> uploadFile(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        VendaReceitaBrutaDTO vendaReceitaBrutaDTO = new VendaReceitaBrutaDTO();
        vendaReceitaBrutaDTO.setReceitaBruta(vendasService.store(file));
        return ResponseEntity.status(HttpStatus.OK).body(vendaReceitaBrutaDTO);

    }

    @GetMapping()
    public ResponseEntity<List<VendaDTO>> listAll() throws IOException {
        return ResponseEntity.ok().body(
                vendasService.listAll().stream().map(entity -> entity.toDTO()).toList()
        );
    }

    @GetMapping("/{cpfCnpj}")
    public ResponseEntity<VendaDTO> findById(@PathVariable String cpfCnpj) {
        return ResponseEntity.ok().body(
                vendasService.findById(cpfCnpj).toDTO()
        );
    }


}
