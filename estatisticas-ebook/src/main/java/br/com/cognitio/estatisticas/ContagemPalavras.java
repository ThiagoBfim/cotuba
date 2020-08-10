package br.com.cognitio.estatisticas;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContagemPalavras {

    private Map<String, Integer> map = new TreeMap<>();

    public void adicionaPalavra(String palavra) {
        Integer contagem = map.get(palavra);
        if (contagem != null) {
            contagem++;
        } else {
            contagem = 1;
        }
        map.put(palavra, contagem);
    }

    public List<Contagem> getContagemPalavras() {
        return map.entrySet().stream()
                .map(element -> new Contagem(element.getKey(), element.getValue()))
                .collect(Collectors.toList());
    }

    public static final class Contagem {
        private final String palavra;
        private final int quantidade;

        public Contagem(String palavra, int quantidade) {
            this.palavra = palavra;
            this.quantidade = quantidade;
        }

        public String getPalavra() {
            return palavra;
        }

        public int getQuantidade() {
            return quantidade;
        }
    }
}
