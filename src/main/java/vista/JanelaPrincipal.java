package vista;

import modelo.Filial;
import modelo.GestorLocais;
import modelo.Local;
import modelo.Sede;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {
    private JPanel painelPrincipal;
    private JButton gerirVeiculosButton;
    private JButton gerirPeçasButton;
    private JButton gerirEventosButton;
    private JButton gerirTransaçõesButton;
    private JButton gerirClientesButton;
    private JButton estatísticasButton;

    public JanelaPrincipal(String title){
        super(title);
        gerirPeçasButton.addActionListener(this::btnGerirPecasActionPerformed);
        GestorLocais.INSTANCE.addLocais(new Sede("Sede"));
        GestorLocais.INSTANCE.addLocais(new Filial("Filial1"));
        gerirVeiculosButton.addActionListener(this::btnGerirVeiculosActionPerformed);
        gerirClientesButton.addActionListener(this::btnGerirClientesActionPerformed);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
        pack();
    }

    private void btnGerirClientesActionPerformed(ActionEvent actionEvent) {new JanelaCliente(getTitle()).setVisible(true);}

    public static void main(String[] args) {
        new JanelaPrincipal("JanelaPrincipal").setVisible(true);
    }

    private void btnGerirPecasActionPerformed(ActionEvent evt){
       JanelaGestaoPecas.mostrarGestaoPeca();
    }

    private void btnGerirVeiculosActionPerformed(ActionEvent evt){
        janelaVeiculos.mostarGestorVeiculos();
    }

}
