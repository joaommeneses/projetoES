package modelo;

import java.util.Calendar;

public class Data {
    Calendar calendar;

    public Data(int dia, int mes, int ano){
        this.calendar = Calendar.getInstance();
        this.calendar.set(ano, mes, dia);
    }

    public static Data ParseData(String data){
        String partes[] = data.split("/");

        int dia = Integer.parseInt(partes[0]);
        int mes  = Integer.parseInt(partes[1]);
        int ano  = Integer.parseInt(partes[2]);


        return new Data(dia,mes,ano);
    }

    public Calendar getCalendar() {
        return calendar;
    }


    @Override
    public String toString() {
        return this.calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/"
                + calendar.get(Calendar.YEAR);
    }
}
