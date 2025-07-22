package cadastro_veiculo_spring.service;

import cadastro_veiculo_spring.model.Cliente;
import java.util.List;

public interface ClienteService {
    Cliente salvar(Cliente cliente);
    Cliente buscarPorId(Integer id);
    List<Cliente> listarTodos();
    Cliente atualizar(Integer id, Cliente novoCliente);
    void deletar(Integer id);
}
