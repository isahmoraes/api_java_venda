package cadastro_veiculo_spring.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cadastro_veiculo_spring.controller.VeiculoController;
import cadastro_veiculo_spring.model.Categoria;
import cadastro_veiculo_spring.model.Veiculo;
import cadastro_veiculo_spring.repository.CategoriaRepository;
import cadastro_veiculo_spring.repository.VeiculoRepository;


@Service

public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository repository;
    private final CategoriaRepository categoriaRepository;
    Logger logger = Logger.getLogger(VeiculoController.class);

    public VeiculoServiceImpl(VeiculoRepository repository , CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

 
@Override
public Veiculo salvar(Veiculo veiculo) {
    if (veiculo.getCategoriaId() != null) {
        Categoria categoria = categoriaRepository.findById(veiculo.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id " + veiculo.getCategoriaId()));
        veiculo.setCategoria(categoria);
    } else {
        throw new RuntimeException("ID da categoria é obrigatório");
    }

    Veiculo veiculoSalvo = repository.save(veiculo);
    if (veiculoSalvo != null) {
        logger.info("Veículo salvo com sucesso: " + veiculoSalvo);
    } else {
        logger.error("Erro ao salvar veículo: " + veiculo);
    }
    return veiculoSalvo;
}


        @Override
    public Veiculo buscarPorId(Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    @Override
    public List<Veiculo> listarTodos() {
        List<Veiculo> veiculos = repository.findAll();
        if (veiculos != null && veiculos.isEmpty()) {
            logger.info("Nenhum veículo cadastrado: " + veiculos);
            System.out.println("Nenhum veículo cadastrado: " + veiculos);
        } else if (veiculos != null && !veiculos.isEmpty()) {
            logger.info(veiculos.size() + " veículos encontrados.");
            System.out.println(veiculos.size() + " veículos encontrados.");
        }
        return veiculos;
    }

    @Override
    public Veiculo atualizar(Integer id, Veiculo novoVeiculo) {
        Veiculo veiculoExistente = buscarPorId(id);
        BeanUtils.copyProperties(novoVeiculo, veiculoExistente, "id");
        return repository.save(veiculoExistente);
    }

    @Override
    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
