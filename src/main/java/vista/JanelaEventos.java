package vista;

import modelo.Evento;
import modelo.GestorEventos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class JanelaEventos extends JFrame {
    private JLabel labelTitulo;
    private JButton buttonRegistar;
    private JLabel labelCombobox;
    private JTable jTableEventosTerminados;
    private JTable jTableEventos;
    private JLabel labelEventosTerminados;
    private JPanel jPanel;
    private JScrollPane scrollPaneEventos;
    private JScrollPane scrollPaneTransport;
    private JButton buttonRefresh;
    private JButton buttonTransporte;

    DefaultTableModel dm;
    DefaultTableModel dm2;

    public JanelaEventos() {
        super("Gestor de Eventos");

        createColumns();
        atualizarEventosTerminados();
        atualizarTabelaEventos();

        setContentPane(jPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);


        buttonRegistar.addActionListener(this::buttonRegistarActionPerformed);


        buttonRefresh.addActionListener(this::buttonRefreshActionPerformed);
        buttonTransporte.addActionListener(this::buttonTransporteActionPerformed);
    }

    private void buttonTransporteActionPerformed(ActionEvent evt) {
        int row = jTableEventosTerminados.getSelectedRow();
        if( row == -1){
            JOptionPane.showMessageDialog(this, "Precisa de selecionar um evento terminado");
        }else {
            var local = GestorEventos.INSTANCE.getEvento(jTableEventosTerminados.getValueAt(row, 0), jTableEventosTerminados.getValueAt(row, 2)).getLocal();
            JanelaTransporte.mostrarTransporteVeiculos(local);
        }
    }

    private void buttonRefreshActionPerformed(ActionEvent evt) {
        atualizarTabelaEventos();
    }

    public void atualizarTabelaEventos() {
        if(dm.getRowCount()>0){
            for(int i = dm.getRowCount() -1; i> -1; i--){
                dm.removeRow(i);
            }
        }
        for(Evento evento : GestorEventos.INSTANCE.getEventos()) {
            if(!evento.isOver()){
            String[] rowData = {
                    evento.getNome(),
                    evento.getLocal().getNome(),
                    evento.getData().toString(),
                    String.valueOf(evento.getDuracao()),
                    String.valueOf(evento.getLocal().getNumVeiculos())
            };

            dm.addRow(rowData);}

        }
    }

    private void createColumns() {
        dm = (DefaultTableModel) jTableEventos.getModel();
        dm.addColumn("Nome");
        dm.addColumn("Local");
        dm.addColumn("Data");
        dm.addColumn("Duração(nº de dias)");
        dm.addColumn("Número de Carros");

        dm2 = (DefaultTableModel) jTableEventosTerminados.getModel();
        dm2.addColumn("Nome");
        dm2.addColumn("Local");
        dm2.addColumn("Data");
        dm2.addColumn("Número de Carros");
    }

    private void atualizarEventosTerminados() {
        List<Evento> eventos = GestorEventos.INSTANCE.getEventos();

        for (Evento evento : eventos) {
            if (evento.isOver()) {
                String[] rowData = {
                        evento.getNome(),
                        evento.getLocal().getNome(),
                        evento.getData().toString(),
                        String.valueOf(evento.getLocal().getNumVeiculos())

                };
                dm2.addRow(rowData);
            }
        }
    }

    public static void mostrarGestorEventos() {
        var janela = new JanelaEventos();
        janela.setVisible(true);
    }

    private void buttonRegistarActionPerformed(ActionEvent e) {
        JanelaRegistarEvento.mostrarRegistoEvento();
    }


}
