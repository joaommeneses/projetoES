package modelo;

import java.util.Objects;

public class Peca {
    private String referencia;
    private String nome;
    private int stock_minimo_sede;
    private int stock_minimo_filial;
    private Categoria categoria;
    private double preco_unit_atual;
    private int quantidadeAtual;
    private int hashCode;

    @Override
    public boolean equals(Object o){
        if(this.getClass() != o.getClass()){
            return false;
        }
        Peca other = (Peca) o;
        return referencia.equals(other.referencia);
    }


    public int getStock_minimo_sede() {
        return stock_minimo_sede;
    }

    public int getStock_minimo_filial() {
        return stock_minimo_filial;
    }

    @Override
    public int hashCode(){
        return this.hashCode;
    }

    public Peca(String referencia, String nome, int stock_minimo_sede, int stock_minimo_filial, Categoria categoria, double preco_unit_atual) {
        this.quantidadeAtual = 0;
        this.referencia = referencia;
        this.nome = nome;
        this.stock_minimo_sede = stock_minimo_sede;
        this.stock_minimo_filial = stock_minimo_filial;
        this.categoria = categoria;
        this.preco_unit_atual = preco_unit_atual;
        this.hashCode = Objects.hash(this.referencia);
    }

    public String getReferencia() {
        return this.referencia;
    }

    public String getNome(){
        return this.nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPreco_unit_atual() {
        return preco_unit_atual;
    }
}
