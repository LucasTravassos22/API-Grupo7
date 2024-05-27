package br.com.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;

	public LancamentoVendas inserirLancamento(LancamentoVendas lancamento) {
		return repository.save(lancamento);
		
	}
	
	

	public List<LancamentoVendasMostrarDTO> listarId() {
		List<LancamentoVendas> vendas=repository.findAll();
			return vendas.stream().map( (v)-> new LancamentoVendasMostrarDTO(v.getDataVenda(), 
					v.getValorVenda(), v.getVendedor().getNome())).collect(Collectors.toList());
		
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
	public LancamentoVendas atualizar(Long id, LancamentoVendas lancamento)  {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Lancamento not found");
        }
        repository.findById(id).orElseThrow(() -> new RuntimeException("Lancamento not found"));
        
        lancamento.setCodigoVenda(id);
        lancamento.setDataVenda(lancamento.getDataVenda());
        lancamento.setValorVenda(lancamento.getValorVenda());
        return repository.save(lancamento);
    }

}