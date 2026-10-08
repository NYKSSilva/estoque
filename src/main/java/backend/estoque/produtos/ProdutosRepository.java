package backend.estoque.produtos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutosRepository extends JpaRepository <Produto, Long> {
    Page<Produto> findByIdProduto(Long idProduto, Pageable paginacao);
}
