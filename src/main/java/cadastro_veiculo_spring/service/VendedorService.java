package cadastro_veiculo_spring.service;

import cadastro_veiculo_spring.model.Vendedor;
import java.util.List;

public interface VendedorService {
    Vendedor salvar(Vendedor vendedor);
    Vendedor buscarPorId(Long id);
    List<Vendedor> listarTodos();
    Vendedor atualizar(Long id, Vendedor novoVendedor);
    void deletar(Long id);
}
