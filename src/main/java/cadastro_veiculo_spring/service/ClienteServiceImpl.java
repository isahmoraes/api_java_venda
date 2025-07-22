package cadastro_veiculo_spring.service;

import cadastro_veiculo_spring.model.Cliente;
import cadastro_veiculo_spring.repository.ClienteRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cadastro_veiculo_spring.controller.ClienteController;

import java.util.List;


@Service
public class ClienteServiceImpl implements ClienteService {

    
    private final ClienteRepository repository;
    Logger logger = Logger.getLogger(ClienteController.class);
    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        Cliente salvo = repository.save(cliente);
        logger.info("Cliente salvo: " + salvo);
        return salvo;
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

@Override
public Cliente atualizar(Integer id, Cliente novo) {
    Cliente existente = buscarPorId(id);
    BeanUtils.copyProperties(novo, existente, "id");
    return repository.save(existente);
}

@Override
public void deletar(Integer id) {
    repository.deleteById(id);
}
}
