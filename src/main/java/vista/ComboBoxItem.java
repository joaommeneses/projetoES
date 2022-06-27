package vista;

import modelo.Local;

public class ComboBoxItem {
    private Local local;
    private String nome;

    public ComboBoxItem(Local local, String nome) {
        this.local = local;
        this.nome = nome;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
