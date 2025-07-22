package cadastro_veiculo_spring.repository;
import cadastro_veiculo_spring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}