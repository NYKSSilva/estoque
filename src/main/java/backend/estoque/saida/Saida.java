package backend.estoque.saida;


import backend.estoque.produtos.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "saidas")
@Entity(name = "saidas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Saida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProduto;
    private int quantidadeProduto;
    private LocalDateTime dataSaida;

    public Saida(DadosRetirarProduto dados){
        this.idProduto = dados.idProduto();
        this.quantidadeProduto = dados.quantidade();
        this.dataSaida = LocalDateTime.now();
    }

}
