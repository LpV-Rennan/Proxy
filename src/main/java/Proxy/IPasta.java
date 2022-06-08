package Proxy;

import java.util.List;

public interface IPasta {
    String obterListaDeArquivos();
    String apagarArquivo(Usuario usuario,String nome);
    String inserirArquivo(Usuario usuario , Arquivo nome);
}
