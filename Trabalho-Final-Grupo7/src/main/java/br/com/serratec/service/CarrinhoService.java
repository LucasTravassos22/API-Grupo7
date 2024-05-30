package br.com.serratec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.CarrinhoRequestDTO;
import br.com.serratec.dto.CarrinhoResponseDTO;
import br.com.serratec.entity.Carrinho;
import br.com.serratec.entity.Pedido;
import br.com.serratec.entity.Produto;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.CarrinhoRepository;
import br.com.serratec.repository.PedidoRepository;
import br.com.serratec.repository.ProdutoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	//Criar Carrinho
	public CarrinhoResponseDTO inserir(CarrinhoRequestDTO carrinho) {
	    if (carrinho == null) throw new ResourceNotFoundException("Erro");
	    Optional<Produto> produto = produtoRepository.findById(carrinho.getProdutoId());
	    Optional<Pedido> pedido = pedidoRepository.findById(carrinho.getPedidoId());
	    if (pedido.isEmpty() || produto.isEmpty()) throw new ResourceNotFoundException("Vazio");
	    
	    Carrinho c = new Carrinho(carrinho, pedido.get(), produto.get());
	    carrinhoRepository.save(c);
	    c.getId().setPedido(pedido.get());
	    c.getId().setProduto(produto.get());
	    return new CarrinhoResponseDTO(c);
	}

	//Listar carrinhos
	public List<CarrinhoResponseDTO> buscarTodosCarrinhos() {
		List<Carrinho> list = carrinhoRepository.findAll();
		List<CarrinhoResponseDTO> produtos = list.stream().map(produto -> new CarrinhoResponseDTO(produto))
				.collect(Collectors.toList());
		return produtos;
	}
	
//	//Atualizar carrinho
//    public void atualizarCarrinho(Long pedidoId, CarrinhoRequestDTO carrinhoRequest) {
//        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(pedidoId);
//        if (carrinhoOptional.isEmpty()) {
//            throw new ResourceNotFoundException("Carrinho não encontrado");
//        }
//        Carrinho carrinho = carrinhoOptional.get();
//        carrinho.setQuantidade(carrinhoRequest.getQuantidade());
//        carrinhoRepository.save(carrinho);
//    }

	//Deletar carrinho por id
    public void deletarCarrinho(Long pedidoId) {
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(pedidoId);
        if (carrinhoOptional.isEmpty()) {
            throw new ResourceNotFoundException("Carrinho não encontrado");
        }
        Carrinho carrinho = carrinhoOptional.get();
        carrinhoRepository.delete(carrinho);
    }
}