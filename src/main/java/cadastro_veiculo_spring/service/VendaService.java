package cadastro_veiculo_spring.service;

import cadastro_veiculo_spring.model.VendaVeiculo;
import java.util.List;

public interface VendaService {
    VendaVeiculo salvar(VendaVeiculo venda);
    VendaVeiculo buscarPorId(Long id);
    List<VendaVeiculo> listarTodos();
    VendaVeiculo atualizar(Long id, VendaVeiculo novaVenda);
    void deletar(Long id);
}
