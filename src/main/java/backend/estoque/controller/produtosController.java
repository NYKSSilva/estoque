package backend.estoque.controller;

import backend.estoque.produtos.DadosCriarProdutos;
import backend.estoque.produtos.DadosListagemProdutos;
import backend.estoque.produtos.Produto;
import backend.estoque.produtos.ProdutosRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class produtosController {

    @Autowired
    private ProdutosRepository repository;

    @PostMapping
    @Transactional
    @Tag(name = "Criar Produto", description = "Criar produto no banco de dados.")
    public void CriarProduto(@RequestBody DadosCriarProdutos dados ){

        repository.save(new Produto(dados));
    }

    @GetMapping
    @Tag(name = "Listar produtos", description = "Listar os produtos existentes.")
    public Page<DadosListagemProdutos> listarProdutos(@PageableDefault(size=6, sort = {"id"}) Pageable paginacao){
        return repository.findAll(paginacao)
                .map(DadosListagemProdutos:: new);
    }

    @GetMapping("/{idProduto}")
    @Tag(name = "Listar Produto Especifico", description = "Listar um produto especifico com base no id")
    public Page<DadosListagemProdutos> listarProdutoEspecifico(@PathVariable Long idProduto, @PageableDefault(size=6, sort = {"id"}) Pageable paginacao){
        return repository.findByIdProduto(idProduto, paginacao)
                .map(DadosListagemProdutos:: new);
    }

}
