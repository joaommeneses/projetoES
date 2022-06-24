package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorPeca {
    public static GestorPeca INSTANCE = new GestorPeca();
    private List<Peca> pecas;

    private GestorPeca(){
        pecas = new ArrayList<Peca>();
    }

    public boolean existePecaComReferencia(String referencia){

        for (Peca peca : pecas) {
            if (peca != null && peca.getReferencia().equals(referencia)) {
                return true;
            }
        }
        return false;
    }

    public void adicionarPeca(Peca peca){
        //TO DO
        pecas.add(peca);
        System.out.println("Peca adicionada linkedlist");
        for (Peca peca1 : pecas) {
            System.out.println(peca1.getReferencia());
        }
    }
}
