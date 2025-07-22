package cadastro_veiculo_spring.service;

import cadastro_veiculo_spring.model.VendaVeiculo;
import cadastro_veiculo_spring.repository.VendaRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cadastro_veiculo_spring.controller.VendaController;

import java.util.List;

@Service

public class VendaServiceImpl implements VendaService {

    private final VendaRepository repository;
    Logger logger = Logger.getLogger(VendaController.class);

    public VendaServiceImpl(VendaRepository repository) {
        this.repository = repository;
    }

    @Override
    public VendaVeiculo salvar(VendaVeiculo venda) {
        VendaVeiculo salvo = repository.save(venda);
        logger.info("Venda salva: " + salvo);
        return salvo;
    }

    @Override
    public VendaVeiculo buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    @Override
    public List<VendaVeiculo> listarTodos() {
        return repository.findAll();
    }

    @Override
    public VendaVeiculo atualizar(Long id, VendaVeiculo nova) {
        VendaVeiculo existente = buscarPorId(id);
        BeanUtils.copyProperties(nova, existente, "id");
        return repository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
