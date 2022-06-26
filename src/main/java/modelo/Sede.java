package modelo;

public class Sede extends Local{
    public static final String[] sede = {"Sede"};

    public Sede(String nome) {
        super(nome);
    }

    public String[] getSede() {
        return sede;
    }

    public void addPeca(Peca p, int vFilial, int vSede){
        if(super.pecas.get(p) != null){
            int quantidade_atual = super.pecas.get(p);
            quantidade_atual += vSede;
            super.pecas.put(p, quantidade_atual);
            return;
        }else{
            if(!super.pecas.containsKey(p)){
                super.pecas.put(p, vSede);
            }
        }
    }
}
