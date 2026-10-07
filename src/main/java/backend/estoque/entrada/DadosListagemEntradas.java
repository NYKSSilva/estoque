package backend.estoque.entrada;

import java.time.LocalDateTime;

public record DadosListagemEntradas(
        Long id,
        Long id_produto,
        int quantidadeProduto,
        LocalDateTime dataEntrada
) {
    public  DadosListagemEntradas(Entrada entrada){
        this(entrada.getId(), entrada.getIdProduto(), entrada.getQuantidadeProduto(), entrada.getDataEntrada());
    }
}
