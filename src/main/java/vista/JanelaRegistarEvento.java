package vista;

import modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class JanelaRegistarEvento extends JFrame {
    private JPanel jPanel;
    private JLabel labelTitulo;
    private JLabel labelNome;
    private JTextField nomeDoEventoTextField;
    private JLabel labelLocal;
    private JComboBox<Local> localComboBox;
    private JLabel labelAdicionar;
    private JButton buttonAdicionar;
    private JTable jTableAdicionar;
    private JScrollPane scrollPaneAdicionar;
    private JLabel labelData;
    private JTextField textFieldData;
    private JButton buttonSubmeter;
    private JTextField textFieldDuracao;
    private JButton buttonCancelar;

    private Data data;
    private List<Veiculo> veiculosParaLocal;

    DefaultTableModel dm;

    public JanelaRegistarEvento() {
        super("Registo de Evento");

        createColumns();
        atualizarVeiculos();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(jPanel);
        pack();

        veiculosParaLocal = new ArrayList<>();

        buttonSubmeter.addActionListener(this::buttonSubmeterActionPerformed);
        buttonAdicionar.addActionListener(this::buttonAdicionarActionPerformed);
        buttonCancelar.addActionListener(this::buttonCancelarActionPerformed);
        populateLocais();
    }

    private void buttonCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        this.dispose();
    }

    private void buttonAdicionarActionPerformed(ActionEvent evt) {
        var row = jTableAdicionar.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Precisa de selecionar um veículo");
        } else {
            var matricula = jTableAdicionar.getValueAt(row, 0);
            var veiculo = GestorVeiculos.INSTANCE.getVeiculo(matricula.toString());
            veiculosParaLocal.add(veiculo);
            atualizarVeiculos();
        }
    }


    private void populateLocais() {

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Local local : GestorLocais.INSTANCE.getLocais()) {
            model.addElement(new ComboBoxItem(local, local.getNome()));
        }

        localComboBox.setModel(model);

    }

    private void atualizarVeiculos() {
        List<Veiculo> lista = GestorVeiculos.INSTANCE.getVeiculos();

        if (dm.getRowCount() > 0) {
            for (int i = dm.getRowCount() - 1; i > -1; i--) {
                dm.removeRow(i);
            }
        }

        for (Veiculo veiculo : lista) {
            if (veiculosParaLocal != null && veiculosParaLocal.contains(veiculo)) {
                continue;
            }
            System.out.println(veiculo.getMatricula());
            String[] rowData = {
                    veiculo.getMatricula(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
            };
            dm.addRow(rowData);
        }
    }

    private void createColumns() {
        dm = (DefaultTableModel) jTableAdicionar.getModel();

        dm.addColumn("Matrícula");
        dm.addColumn("Marca");
        dm.addColumn("Modelo");
    }

    private void buttonSubmeterActionPerformed(ActionEvent evt) {
        var erros = 0;
        var valido = isDataValida(textFieldData.getText());

        if (!valido) {
            erros++;
            Erros.mostrarErro(this, Erros.DATA_INVALIDA);
        }

        valido = isDuracaoValida(textFieldDuracao.getText());

        if (!valido) {
            erros++;
            Erros.mostrarErro(this, Erros.DURACAO_EVENTO_INVALIDA);
        }

        if (erros == 0) {
            var local = ((ComboBoxItem) localComboBox.getSelectedItem()).getLocal();
            for (Veiculo veiculo : veiculosParaLocal) {
                for (Local local1 : GestorLocais.INSTANCE.getLocais()) {
                    for (int i = 0; i<local1.getNumVeiculos(); i++ ) {
                        var veiculo1 = local1.getVeiculos().get(i);
                        if (veiculo1.equals(veiculo)) {
                            local1.removeVeiculo(veiculo);
                        }
                    }
                }
                local.addVeiculo(veiculo);
            }
            var evento = new Evento(nomeDoEventoTextField.getText(), this.data, local, Integer.parseInt(textFieldDuracao.getText()));
            GestorEventos.INSTANCE.adicionarEvento(evento);
            fechar();
        }

    }

    private boolean isDuracaoValida(String duracao) {
        if (duracao.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    private boolean isDataValida(String data) {
        this.data = Data.ParseData(data);
        return true;
    }

    public static void mostrarRegistoEvento() {
        var janela = new JanelaRegistarEvento();
        janela.setVisible(true);
    }
}
