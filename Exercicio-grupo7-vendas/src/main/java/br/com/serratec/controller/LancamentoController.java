package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping
	public ResponseEntity<List<LancamentoVendasMostrarDTO>> listar() {
	    List<LancamentoVendasMostrarDTO> lancamentos = lancamentoService.listarId();
	    if (lancamentos.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(lancamentos);
	}

	@PostMapping
	public ResponseEntity<LancamentoVendas> inserirLancamento(@RequestBody LancamentoVendas lancamento) {
	    try {
	        LancamentoVendas savedLancamento = lancamentoService.inserirLancamento(lancamento);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedLancamento);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
	    try {
	        lancamentoService.deletar(id);
	        return ResponseEntity.noContent().build();
	    } catch (Exception e) {
	        return ResponseEntity.notFound().build();
	    }
	}

	@PutMapping("/{id}")
	public ResponseEntity<LancamentoVendas> atualizar(@PathVariable Long id, @RequestBody LancamentoVendas lancamento) {
	    try {
	        LancamentoVendas updatedLancamento = lancamentoService.atualizar(id, lancamento);
	        return ResponseEntity.ok(updatedLancamento);
	    } catch (Exception e) {
	        return ResponseEntity.notFound().build();
	    }
	}
}