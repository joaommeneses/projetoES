package modelo;

public class Peca {
    private String referencia;
    private String nome;
    private int stock_minimo_sede;
    private int stock_minimo_filial;
    private String categoria;
    private double preco_unit_atual;

    public Peca(String referencia, String nome, int stock_minimo_sede, int stock_minimo_filial, String categoria, double preco_unit_atual) {
        this.referencia = referencia;
        this.nome = nome;
        this.stock_minimo_sede = stock_minimo_sede;
        this.stock_minimo_filial = stock_minimo_filial;
        this.categoria = categoria;
        this.preco_unit_atual = preco_unit_atual;
    }

    public String getReferencia() {
        return referencia;
    }
}
