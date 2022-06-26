package modelo;

import java.util.LinkedList;

public class Cliente {
    private String nome;
    private long nif;
    private long contato;
    private String email;
    private LinkedList<Transacao> transacoes;

    public Cliente(String nome, long nif, long contato, String email) {
        this.nome = nome;
        this.nif = nif;
        this.contato = contato;
        this.email = email;
        transacoes = new LinkedList<>();
    }

    public long getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<Transacao> getTransacoes() {
        return new LinkedList<>(transacoes);
    }

    public void adicionarTransacao(Transacao transacao){
        transacoes.add(transacao);
    }
}
