package backend.estoque.entrada;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Entrada, Long> {
    Optional<Entrada> findAllByIdProduto(Long idProduto, Pageable paginacao);
}
