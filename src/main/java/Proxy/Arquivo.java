package Proxy;

public class Arquivo {
    private String nome;
    private Boolean acesso;

    public Arquivo(String nome, Boolean acesso) {
        this.nome = nome;
        this.acesso = acesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAcesso() {
        return acesso;
    }

    public void setAcesso(Boolean acesso) {
        this.acesso = acesso;
    }
}
