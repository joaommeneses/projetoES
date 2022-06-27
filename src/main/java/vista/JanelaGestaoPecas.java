package vista;

import modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class JanelaGestaoPecas extends JFrame {
    private JPanel painelGestãoPeças;
    private JButton registarPeçaButton;
    private JComboBox filialSedeComboBox;
    private JButton diminuirStockButton;
    private JButton aumentarStockButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTable tabelaPecas;
    private JScrollPane scrollPane;
    private JTextArea textAreaPecas;
    private JScrollPane pecasLista;
    DefaultTableModel dm;


    private DefaultComboBoxModel modeloLista;
    private Set<Local> locais;
    private String localEscolhido;

    public JanelaGestaoPecas(String title){
        super(title);

        modeloLista = new DefaultComboBoxModel();
        filialSedeComboBox.setModel(modeloLista);
        locais = GestorLocais.INSTANCE.getLocais();

        for (Local local : locais) {
            if(local.getClass() == Sede.class || local.getClass() == Filial.class){
                modeloLista.addElement(local.getNome());
            }
        }
        filialSedeComboBox.setEditable(false);
        registarPeçaButton.addActionListener(this::btnRegistarPecaActionPerformed);
        aumentarStockButton.addActionListener(this::btnAdicionarStockActionPerformed);
        diminuirStockButton.addActionListener(this::btnDiminuirStockActionPerformed);
        createColumns();
        mostrarPecasLocal(filialSedeComboBox.getSelectedItem().toString());
        localEscolhido = (String) filialSedeComboBox.getSelectedItem();
        filialSedeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                localEscolhido = (String) filialSedeComboBox.getSelectedItem();
                for (int i = 0; i < dm.getRowCount(); i++) {
                    dm.removeRow(i);
                }
                mostrarPecasLocal(localEscolhido);
            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                filtrarTextFieldKeyReleased(e);
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelGestãoPeças);
        pack();
    }



    public static void mostrarGestaoPeca(){
        var janela = new JanelaGestaoPecas("JanelaGestãoPeças");
        janela.setVisible(true);
    }

    private void filtrarTextFieldKeyReleased(KeyEvent evt){
        String query = textField1.getText();
        filter(query);
    }

    private void createColumns() {
        dm = (DefaultTableModel) tabelaPecas.getModel();
        dm.addColumn("Referência");
        dm.addColumn("Nome");
        dm.addColumn("Preço");
        dm.addColumn("Categoria");
        dm.addColumn("Quantidade");
        dm.addColumn("Min Filial");
        dm.addColumn("Min Sede");
    }

    public void mostrarPecasLocal(String nome){
        Set<Peca> pecas = GestorLocais.INSTANCE.getPecasDeLocal(nome);
        Local localGerido = GestorLocais.INSTANCE.getLocal(nome);

        for (int i = 0; i < dm.getRowCount(); i++) {
            dm.removeRow(i);
        }
        for(Peca peca : pecas){

            String[] rowData = {
                    peca.getReferencia(),
                    peca.getNome(),
                    ""+peca.getPreco_unit_atual()+"€",
                    ""+peca.getCategoria(),
                    localGerido.getQuantidade(peca),
                    ""+peca.getStock_minimo_filial(),
                    ""+peca.getStock_minimo_sede()
            };
            dm.addRow(rowData);
        }
    }

    private void btnRegistarPecaActionPerformed(ActionEvent evt){
        JanelaRegistoPecas.mostrarRegistarPeca();
    }

    private void btnAdicionarStockActionPerformed(ActionEvent evt){
        Local local = GestorLocais.INSTANCE.getLocal(localEscolhido);
        int column = 0;
        int row = tabelaPecas.getSelectedRow();
        String referencia = tabelaPecas.getModel().getValueAt(row, column).toString();
        Peca p;
        int quantidade = Integer.parseInt(textField2.getText());
        if(!isQuantidadeValida(quantidade)){
            Erros.mostrarErro(this, Erros.QUANTIDADE_INVALIDA);
            return;
        }

        if(local.getClass() == Sede.class){
            p = GestorPeca.INSTANCE.getPeca(referencia);
            GestorLocais.INSTANCE.addPecaToLocais(p, 0, quantidade);
        }else{
            p = GestorPeca.INSTANCE.getPeca(referencia);
            if(Integer.parseInt(GestorLocais.INSTANCE.getLocal("Sede").getQuantidade(p)) < quantidade){
                Erros.mostrarErro(this, Erros.TRANSFERENCIA_STOCK_INVALIDA);
                return;
            }
            p = GestorPeca.INSTANCE.getPeca(referencia);
            GestorLocais.INSTANCE.addPecaToLocais(p, quantidade, -quantidade );

        }
        for (int i = 0; i < dm.getRowCount(); i++) {
            dm.removeRow(i);
        }
        mostrarPecasLocal(localEscolhido);
    }

    private void btnDiminuirStockActionPerformed(ActionEvent evt){
        Local local = GestorLocais.INSTANCE.getLocal(localEscolhido);
        Peca p;
        int column = 0;
        int row = tabelaPecas.getSelectedRow();
        String referencia = tabelaPecas.getModel().getValueAt(row, column).toString();
        int quantidade = Integer.parseInt(textField2.getText());
        if(!isQuantidadeValida(quantidade)){
            Erros.mostrarErro(this, Erros.QUANTIDADE_INVALIDA);
            return;
        }
        if(local.getClass() == Sede.class){
            p = GestorPeca.INSTANCE.getPeca(referencia);
            GestorLocais.INSTANCE.addPecaToLocais(p, 0, -quantidade);
        }else{
            p = GestorPeca.INSTANCE.getPeca(referencia);
            GestorLocais.INSTANCE.addPecaToLocais(p, -quantidade, 0);
        }
        for (int i = 0; i < dm.getRowCount(); i++) {
            dm.removeRow(i);
        }
        mostrarPecasLocal(localEscolhido);
    }


    private void filter(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        tabelaPecas.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    private boolean isQuantidadeValida(int quantidade){
        if(quantidade > 0){
            return true;
        }else{
            return false;
        }
    }
}
