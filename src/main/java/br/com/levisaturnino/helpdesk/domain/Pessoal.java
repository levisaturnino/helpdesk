package br.com.levisaturnino.helpdesk.domain;

import br.com.levisaturnino.helpdesk.domain.enums.Perfil;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public abstract class Pessoal {

    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected Set<Integer> perfis = new HashSet<>();
    protected LocalDate dataCriacao = LocalDate.now();

    public Pessoal() {
        super();
        addPerfis(Perfil.CLIENTE);
    }

    public Pessoal(Integer id, String nome, String cpf, String email, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        addPerfis(Perfil.CLIENTE);
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfis(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoal pessoal = (Pessoal) o;

        if (id != null ? !id.equals(pessoal.id) : pessoal.id != null) return false;
        return cpf != null ? cpf.equals(pessoal.cpf) : pessoal.cpf == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        return result;
    }
}
