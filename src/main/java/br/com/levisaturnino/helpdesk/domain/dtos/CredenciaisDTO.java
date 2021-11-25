package br.com.levisaturnino.helpdesk.domain.dtos;

public class CredenciaisDTO {

    protected String email;
    protected String senha;

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
}
