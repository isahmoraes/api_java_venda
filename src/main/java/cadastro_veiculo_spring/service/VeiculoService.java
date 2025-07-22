package cadastro_veiculo_spring.service;

import java.util.List;

import cadastro_veiculo_spring.model.Veiculo;

public interface VeiculoService {
    Veiculo salvar(Veiculo veiculo);

    Veiculo buscarPorId(Integer id);

    List<Veiculo> listarTodos();

    Veiculo atualizar(Integer id, Veiculo veiculo);

    void deletar(Integer id);
}
