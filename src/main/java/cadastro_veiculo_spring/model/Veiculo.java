package cadastro_veiculo_spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String ano;
    private String modelo;
    private String cor;
    private String placa;
    private Boolean unicoDono;
    private Double valor;
    @Transient
    @JsonProperty("categoriaId")
    private Integer categoriaId;
    public Veiculo(Integer categoriaId) {
    this.categoriaId = categoriaId;
}


    public Integer getCategoriaId() {
        return categoriaId;
    }


    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

        @OneToMany(mappedBy = "veiculo")
    private List<VendaVeiculo> vendas;
    public Veiculo(String ano, Categoria categoria, String cor, Integer id, String modelo, String nome, String placa, boolean unicoDono, double valor) {
        this.ano = ano;
        this.categoria = categoria;
        this.cor = cor;
        this.id = id;
        this.modelo = modelo;
        this.nome = nome;
        this.placa = placa;
        this.unicoDono = unicoDono;
        this.valor = valor;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isUnicoDono() {
        return unicoDono;
    }

    public void setUnicoDono(boolean unicoDono) {
        this.unicoDono = unicoDono;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
