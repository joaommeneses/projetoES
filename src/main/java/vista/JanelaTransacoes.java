package vista;

import modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class JanelaTransacoes extends JFrame {
    private JButton novaTransaçãoButton;
    private JPanel painelJanelaTransacoes;
    private JTable table1;

    DefaultTableModel dm;

    public JanelaTransacoes(String title) {
        super(title);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelJanelaTransacoes);
        pack();

        createColumns();
        populateTabel();
        novaTransaçãoButton.addActionListener(this::btnRegistarNovaTransacao);
    }

    private void btnRegistarNovaTransacao(ActionEvent evt){
        new JanelaRegistoTransacao("Janela Registo Trasação", this).setVisible(true);
    }

    private void createColumns() {
        dm = (DefaultTableModel) table1.getModel();
        dm.addColumn("Nome Cliente");
        dm.addColumn("NIF");
        dm.addColumn("Valor");
        dm.addColumn("Tipo");
    }

    private void populateTabel() {
        List<Transacao> listaTrasacoes = GestorTrasacoes.INSTANCE.getTransacoes();


        for(Transacao transacao : listaTrasacoes){
            if(transacao.isCompra()){
                String[] rowData = {
                        String.valueOf(transacao.getCliente().getNome()),
                        String.valueOf(transacao.getCliente().getNif()),
                        String.valueOf(transacao.getValor()),
                        "Compra"
                };
                dm.addRow(rowData);
            } else{
                String[] rowData = {
                        String.valueOf(transacao.getCliente().getNome()),
                        String.valueOf(transacao.getCliente().getNif()),
                        String.valueOf(transacao.getValor()),
                        "Venda"
                };
                dm.addRow(rowData);//
            }
        }
    }
}
