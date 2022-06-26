package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public abstract class Local {
    private String nome;
    protected HashMap<Peca, Integer> pecas = new HashMap<>();
    protected List<Veiculo> veiculos = new ArrayList<>();

    public Local(String nome) {
        this.nome = nome;
    }

    public Set<Peca> getPecas(){
        return pecas.keySet();
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public boolean equals(Object o){
        if(this.getClass() != o.getClass()){
            return false;
        }
        Local other = (Local) o;

        return nome.equals(other.nome);
    }

    public String getQuantidade(Peca peca){
        return pecas.get(peca).toString();
    }

    public abstract void addPeca(Peca p, int vFilial, int vSede);


    public void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }

    public int getNumVeiculos() {
        return veiculos.size();
    }

    public List<Veiculo> getVeiculos(){
        return veiculos;
    }
}
