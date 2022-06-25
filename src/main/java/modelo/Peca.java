package modelo;

import java.util.Objects;

public class Peca {
    private String referencia;
    private String nome;
    private int stock_minimo_sede;
    private int stock_minimo_filial;
    private String categoria;
    private double preco_unit_atual;
    private int hashCode;

    @Override
    public boolean equals(Object o){
        if(this.getClass() != o.getClass()){
            return false;
        }
        Peca other = (Peca) o;
        return referencia.equals(other.referencia);
    }

    @Override
    public int hashCode(){
        return this.hashCode;
    }

    public Peca(String referencia, String nome, int stock_minimo_sede, int stock_minimo_filial, String categoria, double preco_unit_atual) {
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

}
