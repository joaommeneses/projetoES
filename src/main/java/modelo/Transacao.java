package modelo;

public class Transacao {
    private Cliente cliente;
    private double valor;
    private boolean compra;

    public Transacao(Cliente cliente, double valor, boolean compra) {
        this.cliente = cliente;
        this.valor = valor;
        this.compra = compra;
    }
}
