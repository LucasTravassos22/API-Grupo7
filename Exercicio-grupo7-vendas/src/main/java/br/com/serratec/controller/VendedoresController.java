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


import br.com.serratec.entity.Vendedor;
import br.com.serratec.service.VendedorService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/vendedores")
public class VendedoresController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public List<Vendedor> listar() {
        return vendedorService.listarId();
    }

    @PostMapping
    public Vendedor inserirVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.inserirVendedor(vendedor);
    }

//    @GetMapping
//    public List<Vendedor> listarId() {
//        return vendedorService.listarId();
//    }

//    @DeleteMapping("/{id}")
//    public void deletar(@PathVariable Long id) {
//        vendedorService.deletar(id);
//    }
    @DeleteMapping("{id}")
	public ResponseEntity<String> deletarEmpregado(@PathVariable Long id){
	    if(vendedorService.existsById(id)){
	        vendedorService.deletar(id);
	        return ResponseEntity.ok("Empregado com id " + id + " foi excluído com sucesso.");
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empregado com id " + id + " não encontrado.");
	}

//    @PutMapping("/{id}")
//    public Vendedor atualizar(@PathVariable Long id, @RequestBody Vendedor vend) {
//        return vendedorService.atualizar(id, vend);
//    }
//    @PutMapping("{id}")
//    public ResponseEntity<Vendedor> atualizar(@PathVariable Long id, @Valid @RequestBody Vendedor vend) {
//    	 try {
//             Vendedor existingVendedor = vendedorService.atualizar(id, vend);
//             return ResponseEntity.ok(existingVendedor);
//         } catch (RuntimeException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }
//    }
    @PutMapping("{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Vendedor novosDadosVendedor) {
        try {
            Vendedor vendedorAtualizado = vendedorService.atualizar(id, novosDadosVendedor);
            return ResponseEntity.ok(vendedorAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor com id " + id + " não encontrado.");
        }
    }
}
    

