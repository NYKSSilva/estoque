package backend.estoque.produtos;

public record DadosCriarProdutos(
        Long id,
        String nome,
        String categoria,
        int quantidade ,
        Float valorUnitario
) {
}
