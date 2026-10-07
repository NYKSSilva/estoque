package backend.estoque.controller;

import backend.estoque.entrada.DadosListagemEntradas;
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
    @Tag(name = "Criar Produto", description = "Adicionar quantidades de itens já existentes")
    public void CriarProduto(@RequestBody DadosCriarProdutos dados ){
        repository.save(new Produto(dados));
    }

    @GetMapping
    public Page<DadosListagemProdutos> listarProdutos(@PageableDefault(size=6, sort = {"id"}) Pageable paginacao){
        return repository.findAll(paginacao)
                .map(DadosListagemEntradas:: new);
    }
}
