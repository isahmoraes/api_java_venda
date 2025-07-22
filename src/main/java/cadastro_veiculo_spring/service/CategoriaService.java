package cadastro_veiculo_spring.service;

import cadastro_veiculo_spring.model.Categoria;
import java.util.List;

public interface CategoriaService {
    Categoria salvar(Categoria categoria);
    Categoria buscarPorId(Integer id);
    List<Categoria> listarTodos();
    Categoria atualizar(Integer id, Categoria novaCategoria);
    void deletar(Integer id);
}
