package br.edu.iff.ccc.webdev.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;    


public class Voluntario extends Usuario {

    @Id
    @NotNull
    private Long idVoluntario;

    public Voluntario(){

    }

    public Voluntario(Long idVoluntario, Long id, String nome, String email, String senha, String telefone, String funcao) {
        super(id, nome, email, senha, telefone, funcao);
        this.idVoluntario = idVoluntario;
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }
    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }
}