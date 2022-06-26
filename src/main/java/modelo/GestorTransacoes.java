package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorTransacoes {
    public static GestorTransacoes INSTANCE = new GestorTransacoes();

    private List<Transacao> transacoes;

    private GestorTransacoes(){
        transacoes = new ArrayList<Transacao>();
    }

    public void adicionarTransacao(Transacao transacao){
        if (transacao == null || transacoes.contains(transacao)) {
            return;
        }
        transacoes.add(transacao);
        transacao.getCliente().adicionarTransacao(transacao);
        System.out.println(transacao);
        System.out.println(transacoes);
    }

    public List<Transacao> getTransacoes() { return transacoes;}
}
