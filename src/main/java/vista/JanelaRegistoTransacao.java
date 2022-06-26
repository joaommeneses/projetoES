package vista;

import modelo.Cliente;
import modelo.GestorClientes;
import modelo.GestorTrasacoes;
import modelo.Transacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class JanelaRegistoTransacao extends JFrame{
    private JRadioButton compraRadioButton;
    private JButton confirmarButton;
    private JRadioButton vendaRadioButton;
    private JTextField valorTextField;
    private JPanel painelJanelaRegistoTransacao;
    private JButton cancelarButton;
    private JTextField nomeClienteTextField;
    private JTextField nifTextField;//


    public JanelaRegistoTransacao(String title, Frame parent) {
        super(title);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelJanelaRegistoTransacao);
        pack();

        parent.dispose();

        confirmarButton.addActionListener(this::btnConfirmar);
        cancelarButton.addActionListener(this::btnCancelar);
        System.out.println(confirmarButton);
    }

    private void btnConfirmar(ActionEvent evt){

        if(nomeClienteTextField.getText() != "" && !isNomeValido(nomeClienteTextField.getText())){
            Erros.mostrarErro(this, Erros.NOME_INVALIDO);
            return;
        }

        if(!isNifValido(nifTextField.getText())){
            Erros.mostrarErro(this, Erros.NIF_INVALIDO);
            return;
        }

        if(!isValorValido(valorTextField.getText())){
            Erros.mostrarErro(this, Erros.PRECO_INVALIDO);
            return;
        }

        if(!compraRadioButton.isSelected() && !vendaRadioButton.isSelected()){
            Erros.mostrarErro(this, Erros.TIPO_TRASACAO_NAO_SELECIONADO);
            return;
        }

        if(GestorClientes.INSTANCE.existeClienteComNif(Long.parseLong(nifTextField.getText()))){
            System.out.println("NIF EXISTE");
            criarTransaçao();
        } else {
            System.out.println("NIF NAO EXISTE");
            new JanelaRegistarCliente(getTitle(), this).setVisible(true);
            JOptionPane.showMessageDialog(this, "Crie Primeiro o cliente");
            this.dispose();
        }


    }

    private void btnCancelar(ActionEvent evt){
        fechar();
    }

    private void criarTransaçao(){
        Cliente cliente = GestorClientes.INSTANCE.getClienteComNif(Long.parseLong(nifTextField.getText()));
        System.out.println(cliente);
        GestorTrasacoes.INSTANCE.adicionarTransacao(new Transacao(cliente, Double.parseDouble(valorTextField.getText()), compraRadioButton.isSelected()));
        JOptionPane.showMessageDialog(this, "Trasação registada com sucesso!");
        fechar();
        if(compraRadioButton.isSelected()){
            janelaRegistoVeiculo.mostrarRegistoVeiculo();
        }
    }

    private boolean isNomeValido(String nome){
        if(nome.matches("[a-zA-Z]+")){
            return true;
        }
        return false;
    }

    private boolean isNifValido(String nif){
        if(nif.matches("^[0-9]{9}")){
            return true;
        }
        return false;
    }

    private boolean isValorValido(String valor) {
        if (valor.matches("^[0-9]+(\\.[0-9]+)?$")) {
            return true;
        }

        return false;
    }

    private void fechar(){
        new JanelaTransacoes("Janela Trasações").setVisible(true); // garante que a lista tem sempre os dados atualizados
        this.dispose();
    }

}
