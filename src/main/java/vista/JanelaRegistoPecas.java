package vista;

import modelo.GestorPeca;
import modelo.Peca;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaRegistoPecas extends JFrame {
    private JTextField textFieldReferencia;
    private JTextField textFieldNome;
    private JTextField textFieldStockMinSede;
    private JTextField textFieldStockMinFilial;
    private JComboBox categoriaComboBox;
    private JTextField textFieldPreco;
    private JButton cancelarButton;
    private JPanel painelRegistoPecas;
    private JButton confirmarButton;

    private Peca peca;

    public JanelaRegistoPecas(String title){
        super(title);
        confirmarButton.addActionListener(this::btnConfirmarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelRegistoPecas);
        pack();
    }

    public static void mostrarRegistarPeca(){
        var janela = new JanelaRegistoPecas("JanelaRegistoPeças");

        janela.setVisible(true);
    }
    private void btnCancelarActionPerformed(ActionEvent evt){
        fechar();
    }
    private void fechar(){
        System.exit(0);
    }

    private void btnConfirmarActionPerformed(ActionEvent evt) {
    int erros = 0;
    if(!existePecaComReferencia(textFieldReferencia.getText())){
        if(isNomeValido(textFieldNome.getText())){

        }else{
            erros+=1;
            Erros.mostrarErro(this, Erros.NOME_INVALIDO);
        }

        if(isStockMinSedeValido(Integer.parseInt(textFieldStockMinSede.getText()))){

        }else{
            erros+=1;
            Erros.mostrarErro(this, Erros.STOCK_MIN_SEDE_INVALIDO);
        }
        if(isStockMinFilialValido(Integer.parseInt(textFieldStockMinFilial.getText()))){

        }else{
            erros+=1;
            Erros.mostrarErro(this, Erros.STOCK_MIN_FILIAL_INVALIDO);
        }
        if(isStockMinValido(Integer.parseInt(textFieldStockMinSede.getText()), Integer.parseInt(textFieldStockMinFilial.getText()))){

        }else{
            erros+=1;
            Erros.mostrarErro(this, Erros.STOCK_MIN_INVALIDO);
        }
        if(isPrecoValido(Double.parseDouble(textFieldPreco.getText()))){

        }else{
            erros+=1;
            Erros.mostrarErro(this, Erros.PRECO_INVALIDO);
        }

        if(erros == 0){
            peca = new Peca(textFieldReferencia.getText(), textFieldNome.getText(), Integer.parseInt(textFieldStockMinSede.getText()), Integer.parseInt(textFieldStockMinFilial.getText()), categoriaComboBox.toString() , Double.parseDouble(textFieldPreco.getText()));
            JOptionPane.showMessageDialog(this, "Peça registada com sucesso!");
            GestorPeca.INSTANCE.adicionarPeca(peca);
        }

    }

    }

    private boolean existePecaComReferencia(String referencia){
        return GestorPeca.INSTANCE.existePecaComReferencia(referencia);
    }

    private boolean isNomeValido(String nome){
        if(nome.matches("[a-zA-Z]+") && nome.length() > 2){
            return true;
        }else{
            return false;
        }
    }

    private boolean isStockMinSedeValido(int stock_min_sede){
        if(stock_min_sede > 0){
            return true;
        }else{
            return false;
        }
    }

    private boolean isStockMinFilialValido(int stock_min_filial){
        if(stock_min_filial > 0){
            return true;
        }else{
            return false;
        }
    }

    private boolean isStockMinValido(int stock_min_sede, int stock_min_filial){
        if(stock_min_sede > stock_min_filial){
            return true;
        }else{
            return false;
        }
    }

    private boolean isPrecoValido(double preco_unit_atual){
        if(preco_unit_atual > 0.0){
            return true;
        }else{
            return false;
        }
    }

}
