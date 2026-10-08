package backend.estoque.controller;



import backend.estoque.produtos.DadosListagemProdutos;
import backend.estoque.produtos.Produto;
import backend.estoque.produtos.ProdutosRepository;
import backend.estoque.saida.DadosListagemSaidas;
import backend.estoque.saida.DadosRetirarProduto;
import backend.estoque.saida.Saida;
import backend.estoque.saida.SaidasRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("saidas")
public class saidaController {

    @Autowired
    private SaidasRepository repository;

    @Autowired
    private ProdutosRepository productsRepository;



    @PostMapping("/{idProduto}")
    @Transactional
    @Tag(name = "Retirar Produto", description = "Retirar quantidades de um produto já existentes")
    public void retirarProduto(@RequestBody DadosRetirarProduto dados, Pageable paginacao ){
        Produto produto = productsRepository.findById(dados.idProduto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
       produto.setQuantidade(produto.getQuantidade() - dados.quantidade());
        repository.save(new Saida(dados));
    }

    @GetMapping
    public Page<DadosListagemSaidas> listarProdutos(@PageableDefault(size=6, sort = {"id"}) Pageable paginacao){
        return repository.findAll(paginacao)
                .map(DadosListagemSaidas:: new);
    }
}
