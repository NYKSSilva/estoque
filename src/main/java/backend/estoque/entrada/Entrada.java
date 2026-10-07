package backend.estoque.entrada;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Table(name = "entrada")
@Entity(name = "entrada")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProduto;
    private int quantidadeProduto;
    private LocalDateTime dataEntrada;

    public Entrada(DadosAdicionaritem dados){
        this.idProduto = dados.idProduto();
        this.quantidadeProduto = dados.quantidadeProduto();
        this.dataEntrada = LocalDateTime.now();
    }

}
