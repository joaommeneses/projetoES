package vista;

import javax.swing.*;

public class JanelaRegistoTransacao extends JFrame{
    private JTextField textField1;
    private JRadioButton compraRadioButton;
    private JButton confirmarButton;
    private JRadioButton vendaRadioButton;
    private JTextField textField2;
    private JPanel painelJanelaRegistoTransacao;
    private JTextField textField3;

    public JanelaRegistoTransacao(String title) {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelJanelaRegistoTransacao);
        pack();
    }

    public static void main(String[] args) {
        new JanelaRegistoTransacao("Janela Registo Transação").setVisible(true);
    }
}
