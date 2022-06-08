package Proxy;

import java.util.HashMap;

public class Diretorio {
    private static HashMap<String, Pasta> pastas = new HashMap<>();

    public static Pasta getPasta(String caminho){
        return pastas.get(caminho);
    }

    public static void addPasta(Pasta pasta , String caminho){
        pastas.put(caminho, pasta);
    }
}
