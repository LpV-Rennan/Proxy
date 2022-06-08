package Proxy;

import java.util.List;

public class PastaProxy implements IPasta {

    private Pasta pasta;

    public PastaProxy(String caminho) {
        this.pasta = Diretorio.getPasta(caminho);
    }

    @Override
    public String obterListaDeArquivos() {
        return this.pasta.obterListaDeArquivos();
    }

    @Override
    public String apagarArquivo(Usuario usuario, String arquivo) {
        if (usuario.isRoot()) {
            return this.pasta.apagarArquivo(usuario, arquivo);
        } else {
            throw new IllegalArgumentException("Usuario nao root");
        }
    }

    @Override
    public String inserirArquivo(Usuario usuario, Arquivo arquivo) {
        if (usuario.isRoot()) {
            return this.pasta.inserirArquivo(usuario, arquivo);
        } else {
            throw new IllegalArgumentException("Usuario nao root");
        }
    }

}
