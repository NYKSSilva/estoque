package backend.estoque.saida;

import backend.estoque.entrada.Entrada;

import java.time.LocalDateTime;

public record DadosListagemSaidas(
        Long id,
        Long idProduto,
        int quantidade,
        LocalDateTime dataSaida
) {
    public  DadosListagemSaidas(Saida saida){
        this(saida.getId(), saida.getIdProduto(), saida.getQuantidadeProduto(), saida.getDataSaida());
    }
}
