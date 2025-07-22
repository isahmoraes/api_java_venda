package cadastro_veiculo_spring.model;

import jakarta.persistence.*;



@Entity
@Table(name = "usuario") // nome diferente de "user"
public class User {
    public User() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String nome;
    private String senha;
    private String tipo;




    public User(String email, Integer id, String nome, String senha, String tipo) {
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
