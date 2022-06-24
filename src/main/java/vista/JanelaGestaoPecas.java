package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaGestaoPecas extends JFrame {
    private JPanel painelGestãoPeças;
    private JButton registarPeçaButton;
    private JComboBox filialSedeComboBox;
    private JButton diminuirStockButton;
    private JButton aumentarStockButton;
    private JTextField textField1;
    private JTextField textField2;

    public JanelaGestaoPecas(String title){
        super(title);
        registarPeçaButton.addActionListener(this::btnRegistarPecaActionPerformed);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelGestãoPeças);
        pack();
    }

    public static void mostrarGestaoPeca(){
        var janela = new JanelaGestaoPecas("JanelaGestãoPeças");
        janela.setVisible(true);
    }

    private void btnRegistarPecaActionPerformed(ActionEvent evt){
        JanelaRegistoPecas.mostrarRegistarPeca();
    }
}
