package modelo;

public class Veiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private String antigoDono;
    private int nrDonos;
    private String cor;
    private double km;
    private Combustivel combustivel;
    private int potencia;
    private double cilindrada;
    private int ano;
    private double preco;

    public Veiculo(String matricula, String marca, String modelo, int nrDonos, String cor, double km, Combustivel combustivel, int potencia, double cilindrada, int ano, double preco, String antigoDono) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.nrDonos = nrDonos;
        this.cor = cor;
        this.km = km;
        this.combustivel = combustivel;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.ano = ano;
        this.preco = preco;
        this.antigoDono = antigoDono;
    }

    public void setNrDonos(int nrDonos) {
        this.nrDonos = nrDonos;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getNrDonos() {
        return nrDonos;
    }

    public String getCor() {
        return cor;
    }

    public double getKm() {
        return km;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public int getPotencia() {
        return potencia;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    public String getAntigoDono() {
        return antigoDono;
    }
}
