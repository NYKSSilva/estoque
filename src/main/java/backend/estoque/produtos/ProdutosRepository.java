package backend.estoque.produtos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository <Produto, Long> {
    Optional<Produto> findAllByIdProduto(Long idProduto, Pageable paginacao);
}
