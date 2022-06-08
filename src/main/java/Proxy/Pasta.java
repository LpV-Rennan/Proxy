package Proxy;

import java.util.*;

public class Pasta implements IPasta {
    private Map<String,Arquivo> arquivos;

    public Pasta() {
        this.arquivos = new HashMap<>();
    }

    public void setArquivos(Map<String,Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    @Override
    public String obterListaDeArquivos() {
        String str = "";
        for(Arquivo a : this.arquivos.values()){
            str += a.getNome() +"\n";
        }
        return str;
    }

    @Override
    public String apagarArquivo(Usuario usuario, String arquivo) {
        this.arquivos.remove(arquivo);
        return this.obterListaDeArquivos();
    }

    @Override
    public String inserirArquivo(Usuario usuario, Arquivo arquivo) {
        this.arquivos.put(arquivo.getNome(),arquivo);
        return this.obterListaDeArquivos();
    }


}
