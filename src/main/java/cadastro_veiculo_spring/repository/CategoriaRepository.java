package cadastro_veiculo_spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cadastro_veiculo_spring.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
