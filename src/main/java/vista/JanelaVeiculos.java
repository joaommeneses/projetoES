package vista;

import modelo.GestorVeiculos;
import modelo.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class JanelaVeiculos extends JFrame{
    private JPanel panelVeiculo;
    private JScrollPane scrollPane;
    private JButton buttonEditar;
    private JButton buttonRegistar;
    private JTable jTable;
    private JLabel labelFiltrar;
    private JTextField filtrarTextField;
    private JLabel labelTitulo;
    private JButton buttonRefresh;

    DefaultTableModel dm;

    public JanelaVeiculos(String title){
        super(title);


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(panelVeiculo);
        pack();

        buttonRegistar.addActionListener(this::buttonRegistarActionPerformed);
        buttonEditar.addActionListener(this::buttonEditarActionPerformed);
        createColumns();
        atualizarVeiculos();
        buttonRefresh.addActionListener(this::buttonRefreshActionPerformed);
        filtrarTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                filtrarTextFieldKeyReleased(e);
            }
        });
    }

    private void buttonEditarActionPerformed(ActionEvent evt) {
        var row = jTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Precisa de selecionar um veiculo");
        }else {
            var matricula = jTable.getValueAt(row, 0);
            System.out.println(matricula);
            var veiculo = GestorVeiculos.INSTANCE.getVeiculo(matricula.toString());

            JanelaRegistoVeiculo.mostrarAlterarVeiculo(veiculo);
        }
    }

    private void filtrarTextFieldKeyReleased(KeyEvent evt){
        String query = filtrarTextField.getText();
        filter(query);
    }

    private void buttonRefreshActionPerformed(ActionEvent evt) {
        atualizarVeiculos();
    }

    private void createColumns() {
        dm = (DefaultTableModel) jTable.getModel();
        dm.addColumn("Matrícula");
        dm.addColumn("Marca");
        dm.addColumn("Modelo");
        dm.addColumn("Antigo Dono");
        dm.addColumn("Nº Donos");
        dm.addColumn("Cor");
        dm.addColumn("KM");
        dm.addColumn("Combustível");
        dm.addColumn("Potência");
        dm.addColumn("Cilindrada");
        dm.addColumn("Ano");
        dm.addColumn("Preço");
    }

    public static void mostarGestorVeiculos(){
        var janela = new JanelaVeiculos("Gestão de Veículos");
        janela.setVisible(true);

    };

    private void buttonRegistarActionPerformed(ActionEvent e) {
        JanelaRegistoVeiculo.mostrarRegistoVeiculo();
    }

    private void atualizarVeiculos() {
        if(dm.getRowCount()>0){
            for(int i = dm.getRowCount() -1; i> -1; i--){
                dm.removeRow(i);
            }
        }
        List<Veiculo> lista = GestorVeiculos.INSTANCE.getVeiculos();

        for(Veiculo veiculo : lista){
            System.out.println(veiculo.getMatricula());
            String[] rowData = {
                    veiculo.getMatricula(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getAntigoDono(),
                    String.valueOf(veiculo.getNrDonos()),
                    String.valueOf(veiculo.getCor()),
                    String.valueOf(veiculo.getKm()),
                    String.valueOf(veiculo.getCombustivel()),
                    String.valueOf(veiculo.getPotencia()),
                    String.valueOf(veiculo.getCilindrada()),
                    String.valueOf(veiculo.getAno()),
                    String.valueOf(veiculo.getPreco())
            };
            dm.addRow(rowData);
        }
    }

    private void filter(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jTable.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(query));
    }
}

