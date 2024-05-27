package br.com.serratec.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Vendedor;
import br.com.serratec.repository.VendedorRepository;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public Vendedor inserirVendedor(Vendedor vendedor) {
        if (vendedor == null) {
            throw new IllegalArgumentException("Vendedor não pode ser nulo");
        }
        if (vendedor.getSalario().compareTo(new BigDecimal("1412")) < 0) {
            throw new IllegalArgumentException("O salário não pode ser abaixo de 1412");
        }
        return repository.save(vendedor);
    }


    public List<Vendedor> listarId() {
        List<Vendedor> vendedores = repository.findAll();
        if (vendedores.isEmpty()) {
            throw new RuntimeException("Nenhum vendedor encontrado");
        }
        return vendedores;
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Vendedor não encontrado");
        }
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Vendedor atualizar(Long id, Vendedor novosDadosVendedor) {
        Vendedor vendedorExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor not found"));

        vendedorExistente.setCodigoVendedor(novosDadosVendedor.getCodigoVendedor());
        vendedorExistente.setNome(novosDadosVendedor.getNome());
        vendedorExistente.setEmail(novosDadosVendedor.getEmail());
        vendedorExistente.setComissao(novosDadosVendedor.getComissao());
        vendedorExistente.setSalario(novosDadosVendedor.getSalario());

        return repository.save(vendedorExistente);
    }
}
