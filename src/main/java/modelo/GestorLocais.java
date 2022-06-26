package modelo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GestorLocais{
    public static GestorLocais INSTANCE = new GestorLocais();
    private Set<Local> locais = new HashSet<>();
    Iterator<Local> localIterator = locais.iterator();

    public void addLocais(Local local){
        locais.add(local);
    }

    public Set<Local> getLocais() {
        return locais;
    }

    public void addPecaToLocais(Peca peca, int valorFilial, int valorSede){
        for (Local local : locais){
            local.addPeca(peca, valorFilial, valorSede);
        }
    }

    public Set<Peca> getPecasDeLocal(String name) {
        for(Local l : locais){
            if(l.getNome().equals(name)){
                return l.getPecas();
            }
        }
        return null;
    }

    public Local getLocal(String s) {
        for (Local local : locais) {
            if(s.equals(local.getNome())){
                return local;
            }
        }
        return null;
    }
}
