package modelo;

public class Filial extends Local{


    public Filial(String nome) {
        super(nome);
    }


    public void addPeca(Peca p, int vFilial, int vSede){
        if(super.pecas.get(p) != null){
            int quantidade_atual = super.pecas.get(p);
            quantidade_atual += vFilial;
            super.pecas.put(p, quantidade_atual);
            return;
        }else{
            if(!super.pecas.containsKey(p)){
                super.pecas.put(p, vFilial);
            }
        }
    }
}
