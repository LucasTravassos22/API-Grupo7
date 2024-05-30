package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.CarrinhoRequestDTO;
import br.com.serratec.dto.CarrinhoResponseDTO;
import br.com.serratec.service.CarrinhoService;

@RequestMapping("/carrinhos")
@RestController
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;

	@GetMapping
	private ResponseEntity<List<CarrinhoResponseDTO>> listar(){
		return ResponseEntity.ok(carrinhoService.buscarTodosCarrinhos());
	}
	
	@PostMapping
	public ResponseEntity<CarrinhoResponseDTO> inserir(@RequestBody CarrinhoRequestDTO pedido){
		return ResponseEntity.ok(carrinhoService.inserir(pedido));
	}
	
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> atualizar(@PathVariable Long pedidoId, @PathVariable Long produtoId, @RequestBody CarrinhoRequestDTO carrinhoRequest){
//        carrinhoService.atualizarCarrinho(pedidoId, carrinhoRequest);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarrinho(@PathVariable Long id) {
        carrinhoService.deletarCarrinho(id);
        return ResponseEntity.noContent().build();
    }
	
}
