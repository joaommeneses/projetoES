package vista;

import javax.swing.*;

public class JanelaEstatisticas extends JFrame {
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JPanel painelEstatisticas;

    public JanelaEstatisticas(String title){
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEstatisticas);
        pack();
    }

}
