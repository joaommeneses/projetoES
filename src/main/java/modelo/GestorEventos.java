package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorEventos {
    public static GestorEventos INSTANCE = new GestorEventos();
    private List<Evento> eventos;

    public GestorEventos() {
        this.eventos = new ArrayList<>();
    }

    public void adicionarEvento(Evento evento){
        eventos.add(evento);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public Evento getEvento(Object nome, Object data) {
        for (Evento evento : eventos) {
            if(nome.equals(evento.getNome()) && data.equals(evento.getData().toString())){
                return evento;
            }
        }
        return null;
    }
}
