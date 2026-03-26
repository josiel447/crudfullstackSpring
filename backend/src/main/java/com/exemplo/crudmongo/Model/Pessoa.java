package com.exemplo.crudmongo.Model;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table; 


@Document(collection = "pessoa") // Indica que esta classe é um documento MongoDB na coleção "pessoa"
public class Pessoacopy {

    @Id // Indica que este campo é o identificador único do documento
    private long id ;
    private String nome;
    private int idade;

    // Getter para o campo id
    public long getId() {
        return id;
    }

    // Setter para o campo id
    public void setId(long id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
