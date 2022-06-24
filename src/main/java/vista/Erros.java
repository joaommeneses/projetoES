package vista;

import javax.swing.*;
import java.awt.*;

public class Erros {
    public static final int REFERENCIA_JA_EXISTE = 1;
    public static final int NOME_INVALIDO = 2;
    public static final int STOCK_MIN_SEDE_INVALIDO = 3;
    public static final int STOCK_MIN_FILIAL_INVALIDO = 4;
    public static final int STOCK_MIN_INVALIDO = 5;
    public static final int PRECO_INVALIDO = 6;

    public static void mostrarErro(Window parent, int numero){

        switch (numero){
            case REFERENCIA_JA_EXISTE ->{
                JOptionPane.showMessageDialog(parent, "Já existe uma peça com a referência dada!");
                break;
            }
            case NOME_INVALIDO -> {
                JOptionPane.showMessageDialog(parent, "Nome inválido!");
                break;
            }
            case STOCK_MIN_SEDE_INVALIDO -> {
                JOptionPane.showMessageDialog(parent, "Stock mínimo na sede inválido!");
                break;
            }
            case STOCK_MIN_FILIAL_INVALIDO -> {
                JOptionPane.showMessageDialog(parent, "Stock mínimo por filial inválido!");
                break;
            }
            case STOCK_MIN_INVALIDO -> {
                JOptionPane.showMessageDialog(parent, "Stock mínimo na sede deve ser superior ao stock mínimo por filial!");
                break;
            }
            case PRECO_INVALIDO -> {
                JOptionPane.showMessageDialog(parent, "Preço inválido!");
                break;
            }
        }
    }
}
