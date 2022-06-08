package Proxy;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PastaTest {

    @BeforeEach
    void setUp() {
        Arquivo a1, a2, a3;
        Map<String, Arquivo> arquivoList = new HashMap();

        a1 = new Arquivo("Vingadores Ultimato 1080 fullHD.mkv", true);
        a2 = new Arquivo("Piratas do Caribe.mp4", false);
        a3 = new Arquivo("HarryPotterPrisioneiroDeAskaban720.avi", false);

        arquivoList.put(a1.getNome(), a1);
        arquivoList.put(a2.getNome(), a2);
        arquivoList.put(a3.getNome(), a3);

        Pasta pasta = new Pasta();
        pasta.setArquivos(arquivoList);

        Diretorio.addPasta(pasta, "f://sharedFiles");
    }

    @Test
    void obterListaDeArquivos() {

        PastaProxy pasta = new PastaProxy("f://sharedFiles");

        assertEquals("HarryPotterPrisioneiroDeAskaban720.avi\n" +
                "Piratas do Caribe.mp4\n" +
                "Vingadores Ultimato 1080 fullHD.mkv\n", pasta.obterListaDeArquivos());
    }

    @Test
    void adicionarArquivo() {
        Usuario user = new Usuario(true);
        Arquivo arquivo = new Arquivo("Homens de Preto.avi", true);
        PastaProxy pasta = new PastaProxy("f://sharedFiles");
        assertEquals("HarryPotterPrisioneiroDeAskaban720.avi\n" +
                "Homens de Preto.avi\n" +
                "Piratas do Caribe.mp4\n" +
                "Vingadores Ultimato 1080 fullHD.mkv\n", pasta.inserirArquivo(user, arquivo));
    }

    @Test
    void erroAdicionarArquivo() {
        try {
            Usuario user = new Usuario(false);
            Arquivo arquivo = new Arquivo("Homens de Preto2.avi", true);
            PastaProxy pasta = new PastaProxy("f://sharedFiles");
            assertEquals("", pasta.inserirArquivo(user, arquivo));
        } catch (IllegalArgumentException e) {
            assertEquals("Usuario nao root", e.getMessage());
        }

    }

    @Test
    void removerArquivo() {
        Usuario user = new Usuario(true);
        PastaProxy pasta = new PastaProxy("f://sharedFiles");
        assertEquals("HarryPotterPrisioneiroDeAskaban720.avi\n" +
                "Piratas do Caribe.mp4\n", pasta.apagarArquivo(user, "Vingadores Ultimato 1080 fullHD.mkv"));
    }

    @Test
    void erroRemoverArquivo() {
        try {
            Usuario user = new Usuario(false);
            PastaProxy pasta = new PastaProxy("f://sharedFiles");
            assertEquals("", pasta.apagarArquivo(user, "Vingadores Ultimato 1080 fullHD.mkv"));
        } catch (IllegalArgumentException e) {
            assertEquals("Usuario nao root", e.getMessage());
        }

    }
}