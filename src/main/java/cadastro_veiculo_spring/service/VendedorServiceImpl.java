package cadastro_veiculo_spring.service;

import cadastro_veiculo_spring.model.Vendedor;
import cadastro_veiculo_spring.repository.VendedorRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cadastro_veiculo_spring.controller.VendedorController;

import java.util.List;

@Service

public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository repository;
    Logger logger = Logger.getLogger(VendedorController.class);

    public VendedorServiceImpl(VendedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vendedor salvar(Vendedor vendedor) {
        Vendedor salvo = repository.save(vendedor);
        logger.info("Vendedor salvo: " + salvo);
        return salvo;
    }

    @Override
    public Vendedor buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));
    }

    @Override
    public List<Vendedor> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Vendedor atualizar(Long id, Vendedor novo) {
        Vendedor existente = buscarPorId(id);
        BeanUtils.copyProperties(novo, existente, "id");
        return repository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
