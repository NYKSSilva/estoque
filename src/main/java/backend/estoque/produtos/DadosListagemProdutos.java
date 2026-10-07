package backend.estoque.produtos;

import backend.estoque.entrada.Entrada;

public record DadosListagemProdutos(
        Long id,
        String nome,
        String categoria,
        int quantidade ,
        Float valorUnitario
) {
    public  DadosListagemProdutos(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getCategoria(), produto.getQuantidade(), produto.getValorUnitario());
    }

}
