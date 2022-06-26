package vista;

import modelo.GestorLocais;
import modelo.GestorVeiculos;
import modelo.Local;
import modelo.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class JanelaTransporte extends JFrame {
    private JLabel labelTitulo;
    private JScrollPane scrollPaneVeiculo;
    private JScrollPane scrollPaneLocal;
    private JTable jTableVeiculos;
    private JTable jTableLocais;
    private JPanel jPanel;
    private JButton buttonTransportar;
    private JButton sairButton;

    private Local local;

    DefaultTableModel dm;
    DefaultTableModel dm2;

    public JanelaTransporte(Local local) {
        super("Transporte De Veículo");

        createColumns();
        this.local = local;
        setContentPane(jPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

        atualizarVeiculos();
        atualizarLocais();

        sairButton.addActionListener(this::buttonSairActionPerformed);
        buttonTransportar.addActionListener(this::buttonTransportarActionPerformed);
    }

    private void atualizarLocais() {
        if(dm2.getRowCount()>0){
            for(int i = dm2.getRowCount() -1; i> -1; i--){
                dm2.removeRow(i);
            }
        }
        var locais = GestorLocais.INSTANCE.getLocais();
        for (Local local : locais) {
            String[] rowData = {
                    local.getNome()
            };
            dm2.addRow(rowData);
        }
    }

    private void atualizarVeiculos() {
        if(dm.getRowCount()>0){
            for(int i = dm.getRowCount() -1; i> -1; i--){
                dm.removeRow(i);
            }
        }
        var veiculos = local.getVeiculos();
        for (Veiculo veiculo : veiculos) {
            String[] rowData = {
                    veiculo.getMatricula(),
                    veiculo.getMarca(),
                    veiculo.getModelo()
            };
            
            dm.addRow(rowData);
        }
    }

    private void buttonTransportarActionPerformed(ActionEvent evt) {
         var veiculoRow = jTableVeiculos.getSelectedRow();
         if(veiculoRow == -1){
             JOptionPane.showMessageDialog(this, "Deve selecionar um veiculo");
             return;
         }
         var localRow = jTableLocais.getSelectedRow();
         if(localRow == -1 ){
             JOptionPane.showMessageDialog(this, "Deve selecionar um local");
         }

         var veiculoSelecionado = GestorVeiculos.INSTANCE.getVeiculo(jTableVeiculos.getValueAt(veiculoRow, 0).toString());

         var localSelecionado = GestorLocais.INSTANCE.getLocal(jTableLocais.getValueAt(localRow, 0).toString());

         local.removeVeiculo(veiculoSelecionado);

         localSelecionado.addVeiculo(veiculoSelecionado);

         atualizarLocais();
         atualizarVeiculos();

    }

    private void buttonSairActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.dispose();
    }

    private void createColumns() {
        dm = (DefaultTableModel) jTableVeiculos.getModel();
        dm.addColumn("Matrícula");
        dm.addColumn("Marca");
        dm.addColumn("Modelo");

        dm2 = (DefaultTableModel) jTableLocais.getModel();
        dm2.addColumn("Nome");
    }

    public static void mostrarTransporteVeiculos(Local local) {
        var janela = new JanelaTransporte(local);
        janela.setVisible(true);
    }

}
