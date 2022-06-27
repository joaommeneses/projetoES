package vista;
import modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JanelaCliente extends JFrame{
    private JButton registarNovoClienteButton;
    private JComboBox comboBox1;
    private JPanel painelCliente;
    private JTable table1;

    DefaultTableModel dm;//

    public JanelaCliente(String title) {
        super(title);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelCliente);
        pack();

        populateCombobox();
        createColumns();
        populateTabel();
        registarNovoClienteButton.addActionListener(this::btnRegistarNovoCliente);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateTabel();
            }
        });
    }

    private void btnRegistarNovoCliente(ActionEvent evt){
        new JanelaRegistarCliente("Janela Registo Cliente", this).setVisible(true);
    }

    public void populateCombobox(){
        List<Cliente> listaClientes = GestorClientes.INSTANCE.getClientes();

        for (Cliente cliente : listaClientes) {
            comboBox1.addItem(cliente.getNome());
        }
    }

    private void createColumns() {
        dm = (DefaultTableModel) table1.getModel();
        dm.addColumn("Valor");
        dm.addColumn("Tipo");
    }

    private void populateTabel() {
        if(comboBox1.getSelectedItem() == null){
            return;
        }

        for (int i = 0; i < dm.getRowCount(); i++) {
            dm.removeRow(i);
        }

        Cliente cliente = GestorClientes.INSTANCE.getClienteComNome(comboBox1.getSelectedItem().toString());
        System.out.println(cliente.getTransacoes());
        for(Transacao transacao : cliente.getTransacoes()){
            if(transacao.isCompra()){
                String[] rowData = {
                        String.valueOf(transacao.getValor()),
                        "Compra"
                };
                dm.addRow(rowData);
            } else{
                String[] rowData = {
                        String.valueOf(transacao.getValor()),
                        "Venda"
                };
                dm.addRow(rowData);
            }
        }
    }
}


