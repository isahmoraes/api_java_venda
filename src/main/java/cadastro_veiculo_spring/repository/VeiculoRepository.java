package cadastro_veiculo_spring.repository;
import cadastro_veiculo_spring.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}


