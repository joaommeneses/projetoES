package modelo;

public class Filial extends Local{


    public Filial(String nome) {
        super(nome);
    }


    public void addPeca(Peca p, int vFilial, int vSede){
        if(!super.pecas.containsKey(p)){
            super.pecas.put(p, vFilial);
        }
    }
}
