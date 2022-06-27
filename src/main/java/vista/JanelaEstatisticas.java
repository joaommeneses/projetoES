package vista;

import modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JanelaEstatisticas extends JFrame {
    private JPanel painelEstatisticas;
    private JTable tabelaFilial;
    private JTable tabelaCliente;
    private JScrollPane scrollMarca;
    private JTable tabelaMarca;
    private JScrollPane scrollFilial;
    private JScrollPane scrollCliente;
    DefaultTableModel dmMarca;
    DefaultTableModel dmFilial;
    DefaultTableModel dmCliente;

    public JanelaEstatisticas(String title){
        super(title);

        mostrarFeiraPopular();
        mostrarFilialMaisInvestimento();
        mostrarMelhorCliente();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEstatisticas);
        pack();
    }


    public static void mostrarEstatisticas(){
        var janela = new JanelaEstatisticas("JanelaEstatísticas");
        janela.setVisible(true);
    }

    public void mostrarFeiraPopular(){
        List<Evento> eventos = GestorEventos.INSTANCE.getEventos();
        List<Veiculo> veiculos = GestorVeiculos.INSTANCE.getVeiculos();
        
        String marca;
        HashMap<String, Integer> countMarcas = new HashMap<>();
        dmMarca = (DefaultTableModel) tabelaMarca.getModel();
        dmMarca.addColumn("Marca");
        dmMarca.addColumn("Quantidade de unidades em eventos");
        if(eventos == null){
            return;
        }
        for (Evento evento : eventos) {

            veiculos = evento.getLocal().getVeiculos();
        }

        for (Veiculo veiculo : veiculos) {
            marca = veiculo.getMarca();
            if (countMarcas.containsKey(marca)) {
                int count = countMarcas.get(marca);
                countMarcas.replace(marca, count + 1);
            } else {
                countMarcas.put(marca, 1);
            }
        }

        String marcaPopular = countMarcas.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        int count = countMarcas.get(marcaPopular);
        String[] rowData = {
                marcaPopular,
                count + " Unidades na feira"
        };
        dmMarca.addRow(rowData);
    }

    public void mostrarFilialMaisInvestimento(){
        dmFilial = (DefaultTableModel) tabelaFilial.getModel();
        dmFilial.addColumn("Filial");
        dmFilial.addColumn("Investimento em peças");
        Set<Local> locais = GestorLocais.INSTANCE.getLocais();
        Set<Filial> filiais = new HashSet<>();
        String nome = "";
        int investimento_max=0;
        for (Local filial : locais) {
            if(filial.getClass() == Filial.class){
             filiais.add((Filial) filial);
            }
        }
        //tenho todas filiais
        for (Filial filial : filiais) {
            int investimento = 0;
            Set<Peca> pecas = filial.getPecas();
            for (Peca peca : pecas) {
                int quantidade = Integer.parseInt(filial.getQuantidade(peca));
                double investimento_peca = quantidade * peca.getPreco_unit_atual();
                investimento += investimento_peca;
                if(investimento > investimento_max){
                    investimento_max = investimento;
                    nome = filial.getNome();
                }
            }
        }

        String[] rowData = {
                nome,
                investimento_max + " €"
        };
        dmFilial.addRow(rowData);
    }

    public void mostrarMelhorCliente(){
        List<Transacao> transacoes = GestorTransacoes.INSTANCE.getTransacoes();
        HashMap<Cliente, Double> countInvestimentoCliente = new HashMap<>();
        dmCliente = (DefaultTableModel) tabelaCliente.getModel();
        dmCliente.addColumn("Cliente");
        dmCliente.addColumn("Valor em transações");
        double investimento = 0;

        for (Transacao transacao : transacoes) {
            Cliente cliente = transacao.getCliente();
            if(countInvestimentoCliente.containsKey(cliente)){
                investimento = countInvestimentoCliente.get(cliente);
                investimento += transacao.getValor();
                countInvestimentoCliente.replace(cliente, investimento);
            }else{
                investimento = transacao.getValor();
                countInvestimentoCliente.put(cliente, investimento);
            }
        }
        Cliente cliente = countInvestimentoCliente.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        investimento = countInvestimentoCliente.get(cliente);


        String[] rowData = {
                cliente.getNome(),
                investimento + " €"
        };
        dmCliente.addRow(rowData);
    }
}
