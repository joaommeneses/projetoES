package vista;

import modelo.Cliente;
import modelo.GestorClientes;
import modelo.GestorVeiculos;

import javax.swing.*;
import java.awt.*; //frame
import java.awt.event.ActionEvent;

public class JanelaRegistarCliente extends JFrame{
    private JTextField nomeTextField;
    private JTextField nifTextField;
    private JTextField contatoTextField;
    private JButton confirmarButton;
    private JPanel painelRegistoCliente;
    private JTextField emailTextField;
    private JButton cancelarButton;

    public JanelaRegistarCliente(String title, Frame parent) {
        super(title);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelRegistoCliente);
        pack();

        confirmarButton.addActionListener(this::btnConfirmar);
        parent.dispose();
        cancelarButton.addActionListener(this::btnCancelar);
    }

    private void btnConfirmar(ActionEvent evt){
        System.out.println("click em Confirmar");
        if(!isNomeValido(nomeTextField.getText())){
            Erros.mostrarErro(this, Erros.NOME_INVALIDO);
            return;
        }
        if(!isNifValido(nifTextField.getText())){
            Erros.mostrarErro(this, Erros.NIF_INVALIDO);
            return;
        }
        if(!isContatoValido(contatoTextField.getText())){
            Erros.mostrarErro(this, Erros.CONTATO_INVALIDO);
            return;
        }
        if(!isEmailValido(emailTextField.getText())){
            Erros.mostrarErro(this, Erros.EMAIL_INVALIDO);
            return;
        }

        long nif = Long.parseLong(nifTextField.getText());
        if(GestorClientes.INSTANCE.existeClienteComNif(nif)){
            Erros.mostrarErro(this, Erros.NIF_REPETIDO);
            return;
        }


        long contato = Long.parseLong(contatoTextField.getText());
        GestorClientes.INSTANCE.adicionarCliente(new Cliente(nomeTextField.getText(), nif, contato, emailTextField.getText()));
        JOptionPane.showMessageDialog(this, "Cliente registado com sucesso!");
        fechar();
        new JanelaCliente("Janela Cliente").setVisible(true);

    }

    private void btnCancelar(ActionEvent evt){
        System.out.println("click em Cancelar");
        fechar();
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

    private boolean isContatoValido(String contato){
        if(contato.matches("^[0-9]{9}")){
            return true;
        }
        return false;
    }

    private boolean isEmailValido(String email){
        if(email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            return true;
        }
        return false;
    }

    private void fechar(){
        this.dispose();
    }
}
