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
<<<<<<< HEAD
        GestorLocais.INSTANCE.addLocais(new Sede("Sede"));
        GestorLocais.INSTANCE.addLocais(new Filial("Filial1"));
=======
        gerirVeiculosButton.addActionListener(this::btnGerirVeiculosActionPerformed);
>>>>>>> 68765bcd322054472db5a7bca8e6e4ea1f301a22
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
        pack();
    }
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
