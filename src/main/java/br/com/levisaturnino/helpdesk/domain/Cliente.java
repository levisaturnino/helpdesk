package br.com.levisaturnino.helpdesk.domain;

import br.com.levisaturnino.helpdesk.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Cliente extends Pessoal {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
        addPerfis(Perfil.CLIENTE);

    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha);
        addPerfis(Perfil.CLIENTE);

    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}