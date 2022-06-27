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
    public static final int QUANTIDADE_INVALIDA = 7;
    public static final int TRANSFERENCIA_STOCK_INVALIDA = 8;
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
    public static final int NIF_INVALIDO = 19;
    public static final int CONTATO_INVALIDO = 20;
    public static final int EMAIL_INVALIDO = 21;
    public static final int NIF_REPETIDO = 22;
    public static final int TIPO_TRASACAO_NAO_SELECIONADO = 23;
    public static final int DATA_INVALIDA = 31;
    public static final int DURACAO_EVENTO_INVALIDA = 32;

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
            case QUANTIDADE_INVALIDA -> {
                JOptionPane.showMessageDialog(parent, "Quantidade Inválida! A quantidade deve ser maior que 0!");
                break;
            }
            case TRANSFERENCIA_STOCK_INVALIDA -> {
                JOptionPane.showMessageDialog(parent, "Transferência de stock para filial inválida, sede não tem quantidade necessária.\nAumentar stock da sede.");
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

            case NIF_INVALIDO-> {
                JOptionPane.showMessageDialog(parent, "NIF Inválido. Deve ser um numero de 9 digitos");
                break;
            }

            case CONTATO_INVALIDO-> {
                JOptionPane.showMessageDialog(parent, "Contato Inválido. Deve ser um numero de 9 digitos");
                break;
            }

            case EMAIL_INVALIDO-> {
                JOptionPane.showMessageDialog(parent, "Email Inválido.");
                break;
            }

            case NIF_REPETIDO-> {
                JOptionPane.showMessageDialog(parent, "NIF Inválido. Já existe um cliente com o NIF indicado");
                break;
            }

            case TIPO_TRASACAO_NAO_SELECIONADO -> {
                JOptionPane.showMessageDialog(parent, "Selecione um tipo de trasação");
                break;
            }

            case DATA_INVALIDA-> {
                JOptionPane.showMessageDialog(parent,  "Data Inválida. A data deve ter o formato dd/mm/aaaa");
                break;
            }

            case DURACAO_EVENTO_INVALIDA -> {
                JOptionPane.showMessageDialog(parent,  "Duração inválida. A duração deve ser um número inteiro");
                break;
            }
        }
    }
}
