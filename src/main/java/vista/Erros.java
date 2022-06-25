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
    public static final int MATRICULA_INVALIDA = 9;
    public static final int MARCA_INVALIDA = 10;
    public static final int MODELO_INVALIDO = 11;
    public static final int COR_INVALIDA = 12;
    public static final int KM_INVALIDO = 13;
    public static final int POTENCIA_INVALIDA = 14;
    public static final int CILINDRADA_INVALIDA = 15;
    public static final int ANO_INVALIDO = 16;
    public static final int NRDONOS_INVALIDO = 17;
    public static final int MATRICULA_REPETIDA = 18;

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
                JOptionPane.showMessageDialog(parent, "Preço inválido!  O preço da peça deve ser um número positivo, e deve se utilizar um ponto para separar a parte inteira da parte decimal.");
                break;
            }
            case MATRICULA_INVALIDA -> {
                JOptionPane.showMessageDialog(parent, "Matrícula Inválida, Formato Válido: XX-XX-XX");
                break;
            }

            case MARCA_INVALIDA -> {
                JOptionPane.showMessageDialog(parent, "Marca Inválida. Pelo menos 2 carateres não-brancos");
                break;
            }

            case  MODELO_INVALIDO -> {
                JOptionPane.showMessageDialog(parent, "Modelo Inválido. Pelo menos 1 carater não-branco");
                break;
            }

            case COR_INVALIDA -> {
                JOptionPane.showMessageDialog(parent, "Cor inválida. Pelo menos 4 carateres não-brancos");
                break;
            }

            case KM_INVALIDO -> {
                JOptionPane.showMessageDialog(parent, "Quilometrágem Invalida. Pelo menos 1 digito maior ou igual a 0");
                break;
            }

            case POTENCIA_INVALIDA -> {
                JOptionPane.showMessageDialog(parent, "Potencia Inválida. Pelo menos 1 digito maior ou igual a 0");
                break;
            }

            case CILINDRADA_INVALIDA-> {
                JOptionPane.showMessageDialog(parent, "Cilindrada Inválida. Pelo menos 1 digito maior ou igual a 0");
                break;
            }

            case ANO_INVALIDO-> {
                JOptionPane.showMessageDialog(parent, "Ano Inválido. Deve preencher com um número inteiro maior que 0");
                break;
            }

            case NRDONOS_INVALIDO-> {
                JOptionPane.showMessageDialog(parent, "Número de Donos Inválido. Deve ser maior ou igual a 0");
                break;
            }

            case MATRICULA_REPETIDA-> {
                JOptionPane.showMessageDialog(parent, "Matrícula Inválida. Já existe um veículo com a matrícula indicada");
                break;
            }
        }
    }
}
