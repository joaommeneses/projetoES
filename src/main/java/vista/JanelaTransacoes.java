package vista;

import javax.swing.*;

public class JanelaTransacoes extends JFrame {
    private JButton novaTransaçãoButton;
    private JList listaTransaçoes;
    private JPanel painelJanelaTransacoes;

    public JanelaTransacoes(String title) {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelJanelaTransacoes);
        pack();
    }

    public static void main(String[] args) {
        new JanelaTransacoes("Janela Transações").setVisible(true);
    }
}
