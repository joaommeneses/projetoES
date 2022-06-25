package vista;

import modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class JanelaGestaoPecas extends JFrame {
    private JPanel painelGestãoPeças;
    private JButton registarPeçaButton;
    private JComboBox filialSedeComboBox;
    private JButton diminuirStockButton;
    private JButton aumentarStockButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textAreaPecas;
    private JScrollPane pecasLista;


    private DefaultComboBoxModel modeloLista;
    private Set<Local> locais;
    private String localEscolhido;

    public JanelaGestaoPecas(String title){
        super(title);

        textAreaPecas = new JTextArea();
        textAreaPecas.setEditable(false);




        modeloLista = new DefaultComboBoxModel();
        filialSedeComboBox.setModel(modeloLista);
        locais = GestorLocais.INSTANCE.getLocais();
        for (Local local : locais) {
            modeloLista.addElement(local.getNome());
        }
        filialSedeComboBox.setEditable(false);
        registarPeçaButton.addActionListener(this::btnRegistarPecaActionPerformed);

        filialSedeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                localEscolhido = (String) filialSedeComboBox.getSelectedItem();
                System.out.println(localEscolhido);
                mostrarPecasLocal(localEscolhido);
            }
        });


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelGestãoPeças);
        pack();
    }

    public static void mostrarGestaoPeca(){
        var janela = new JanelaGestaoPecas("JanelaGestãoPeças");
        janela.setVisible(true);
    }



    public void mostrarPecasLocal(String nome){
        Set<Peca> pecas = GestorLocais.INSTANCE.getPecasDeLocal(nome);

        for (Peca peca : pecas) {
             String line = "Referencia: " + peca.getReferencia() + "  Nome: "+ peca.getNome() + "\n";
             textAreaPecas.removeAll();
            textAreaPecas.setText(textAreaPecas.getText()+line);
            textAreaPecas.updateUI();
            textAreaPecas.revalidate();
            textAreaPecas.validate();
            System.out.println(line);
        }

    }

//continuar aqui, ja consegigo escolher sitio e dps de registar peças o sitio tem peças
    private void btnRegistarPecaActionPerformed(ActionEvent evt){
        JanelaRegistoPecas.mostrarRegistarPeca();
    }
}
