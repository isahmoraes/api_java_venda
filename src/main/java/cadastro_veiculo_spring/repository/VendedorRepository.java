package cadastro_veiculo_spring.repository;

import cadastro_veiculo_spring.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {}
