package backend.estoque.produtos;

import backend.estoque.saida.DadosRetirarProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "produtos")
@Entity(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private int quantidade ;
    private Float valorUnitario;

    public Produto(DadosCriarProdutos dados){
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.quantidade = dados.quantidade();
        this.valorUnitario = dados.valorUnitario();
    }



}
