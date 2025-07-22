package cadastro_veiculo_spring.service;

import cadastro_veiculo_spring.model.Categoria;
import cadastro_veiculo_spring.repository.CategoriaRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cadastro_veiculo_spring.controller.CategoriaController;

import java.util.List;

@Service

public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;
    Logger logger = Logger.getLogger(CategoriaController.class);

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        Categoria salvo = repository.save(categoria);
        logger.info("Categoria salva: " + salvo);
        return salvo;
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    @Override
    public Categoria atualizar(Integer id, Categoria nova) {
        Categoria existente = buscarPorId(id);
        BeanUtils.copyProperties(nova, existente, "id");
        return repository.save(existente);
    }

    @Override
    public void deletar(Integer id) {
        repository.deleteById(id);
    }
    @Override
    public List<Categoria> listarTodos() {
        return repository.findAll();
    }

}



