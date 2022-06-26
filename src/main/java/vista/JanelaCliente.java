package vista;
import modelo.Cliente;
import modelo.GestorClientes;
import modelo.GestorVeiculos;
import modelo.Veiculo;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JanelaCliente extends JFrame{
    private JButton registarNovoClienteButton;
    private JList list1;
    private JComboBox comboBox1;
    private JPanel painelCliente;

    public JanelaCliente(String title) {
        super(title);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelCliente);
        pack();

        populateCombobox();
        registarNovoClienteButton.addActionListener(this::btnRegistarNovoCliente);
    }

    private void btnRegistarNovoCliente(ActionEvent evt){
        new JanelaRegistarCliente("Janela Registo Cliente", this).setVisible(true);
    }

    public void populateCombobox(){
        ArrayList<Cliente> a = new ArrayList<Cliente>();
        a.add(new Cliente("diogo", 123456789, 987654321, "shfgahfa"));
        a.add(new Cliente("ana", 1,1233587435, "bleeeee"));
        a.add(new Cliente("pedro", 5, 1324546, "cleeeee"));

        List<Cliente> listaClientes = GestorClientes.INSTANCE.getClientes();

        for (Cliente cliente : listaClientes) {
            comboBox1.addItem(cliente.getNome());
        }
    }
}


