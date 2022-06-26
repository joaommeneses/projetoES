package modelo;

import java.util.LinkedList;

public class Cliente {
    private String nome;
    private long nif;
    private long contato;
    private String email;
    private LinkedList<Transacao> transacaos;

    public Cliente(String nome, long nif, long contato, String email) {
        this.nome = nome;
        this.nif = nif;
        this.contato = contato;
        this.email = email;
        transacaos = new LinkedList<>();
    }

    public long getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }
}
