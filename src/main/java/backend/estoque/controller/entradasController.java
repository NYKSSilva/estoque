package backend.estoque.controller;

import backend.estoque.entrada.DadosAdicionaritem;
import backend.estoque.entrada.DadosListagemEntradas;
import backend.estoque.entrada.Entrada;
import backend.estoque.entrada.EstoqueRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("entrada")
public class entradasController {

  @Autowired
    private EstoqueRepository repository;

  @PostMapping
  @Transactional
  @Tag(name = "Adicionar item", description = "Adicionar quantidades de itens já existentes")
    public void adicionarItem(@RequestBody DadosAdicionaritem dados){
    repository.save(new Entrada(dados));
  }

  @GetMapping
  public Page<DadosListagemEntradas> listarEntradas(@PageableDefault(size=6, sort = {"id"})Pageable paginacao){
    return repository.findAll(paginacao)
            .map(DadosListagemEntradas:: new);
  }

  @GetMapping("/{idProduto}")
  public Optional<DadosListagemEntradas> listarEntradasEspecificas(@PathVariable Long idProduto, @PageableDefault(size = 3, sort = {"dataEntrada"})Pageable paginacao){
    return repository.findAllByIdProduto(idProduto, paginacao)
            .map(DadosListagemEntradas:: new);
  }

}
