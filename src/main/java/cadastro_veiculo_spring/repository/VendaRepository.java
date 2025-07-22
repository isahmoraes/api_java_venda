package cadastro_veiculo_spring.repository;

import cadastro_veiculo_spring.model.VendaVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaVeiculo, Long> {}