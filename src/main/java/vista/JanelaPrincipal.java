package vista;

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
        gerirVeiculosButton.addActionListener(this::btnGerirVeiculosActionPerformed);
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
