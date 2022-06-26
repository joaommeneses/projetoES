package modelo;


import java.util.Calendar;

public class Evento {
    private String nome;
    private Data data;
    private int duracao;
    private Local local;

    public Evento(String nome, Data data, Local local, int duracao) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public Data getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    public Local getLocal() {
        return local;
    }

    public boolean isOver(){
        Calendar c = (Calendar) data.getCalendar().clone();
        c.add(Calendar.DATE, duracao);

        System.out.println(       c.get(Calendar.DATE) + "/" + c.get(Calendar.MONTH) + "/"
                + c.get(Calendar.YEAR));

        if(c.before(Calendar.getInstance())){
            return true;
        }
        return false;
    }
}
