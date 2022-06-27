package vista;

import modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {
    private JPanel painelPrincipal;
    private JButton gerirVeiculosButton;
    private JButton gerirPeçasButton;
    private JButton gerirEventosButton;
    private JButton gerirTransaçõesButton;
    private JButton gerirClientesButton;
    private JButton estatísticasButton;

    public JanelaPrincipal(String title){
        super(title);
        gerirPeçasButton.addActionListener(this::btnGerirPecasActionPerformed);

        //LOCAIS
        Sede sede = new Sede("Sede");
        GestorLocais.INSTANCE.addLocais(sede);
        Filial filial1 = new Filial("Filial1");
        GestorLocais.INSTANCE.addLocais(filial1);
        Feira feira_de_maio = new Feira("Feira de Maio");
        GestorLocais.INSTANCE.addLocais(feira_de_maio);
        Feira feira_de_março = new Feira("Feira de Março");
        GestorLocais.INSTANCE.addLocais(feira_de_março);



        GestorEventos.INSTANCE.adicionarEvento(new Evento("Feira de Março", new Data(26, 06, 2022), feira_de_março, 10));
        //EVENTOS
        GestorEventos.INSTANCE.adicionarEvento(new Evento("Feira de Maio", new Data(01,01,2022) ,feira_de_maio, 10 ));


        //VEICULOS
        Veiculo veiculo = new Veiculo("XA-08-YP", "BMW", "M4", 0,
                "Preto", 0, Combustivel.GASOLINA, 350, 4000, 2022, 100000, "");
        GestorVeiculos.INSTANCE.adicionarVeiculo(veiculo);
        Veiculo veiculo1 = new Veiculo("XA-09-YP", "BMW", "M4", 0,
                "BRANCO", 0, Combustivel.GASOLINA, 350, 4000, 2022, 100000, "");
        GestorVeiculos.INSTANCE.adicionarVeiculo(veiculo1);

        Veiculo veiculo2 = new Veiculo("XA-10-YP", "BMW", "M4", 0,
                "AZUL", 0, Combustivel.GASOLINA, 350, 4000, 2022, 100000, "");
        GestorVeiculos.INSTANCE.adicionarVeiculo(veiculo2);

        feira_de_maio.addVeiculo(veiculo);
        feira_de_maio.addVeiculo(veiculo1);

        Veiculo veiculo3 = new Veiculo("XA-11-YP", "Mercedes", "AMG-GT", 0, "PRETO", 0, Combustivel.GASOLINA, 350,4000,2022,10000,"");
        GestorVeiculos.INSTANCE.adicionarVeiculo(veiculo3);

        feira_de_março.addVeiculo(veiculo2);
        feira_de_março.addVeiculo(veiculo);
        feira_de_março.addVeiculo(veiculo1);
        feira_de_março.addVeiculo(veiculo3);

        Cliente cliente1 = new Cliente("Antonio", 245313192, 950276172, "joao@mail.pt");
        Transacao transacao1 = new Transacao(cliente1, 2.50, true);
        Cliente cliente2 = new Cliente("Johnny", 239123192, 920192318, "fernando@mail.pt");
        Transacao transacao2 = new Transacao(cliente2, 5, true);

        GestorClientes.INSTANCE.adicionarCliente(cliente1);
        GestorTransacoes.INSTANCE.adicionarTransacao(transacao1);
        GestorClientes.INSTANCE.adicionarCliente(cliente2);
        GestorTransacoes.INSTANCE.adicionarTransacao(transacao2);

        gerirVeiculosButton.addActionListener(this::btnGerirVeiculosActionPerformed);
        gerirClientesButton.addActionListener(this::btnGerirClientesActionPerformed);

        estatísticasButton.addActionListener(this::btnVisualizarEstatisticasActionPerformed);

        gerirEventosButton.addActionListener(this::btnGerirEventosActionPerformed);
        gerirTransaçõesButton.addActionListener(this::btnGerirTransacoesActionPerformed);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
        pack();
    }

    private void btnGerirEventosActionPerformed(ActionEvent actionEvent) {
        JanelaEventos.mostrarGestorEventos();
    }

    private void btnGerirClientesActionPerformed(ActionEvent actionEvent) {new JanelaCliente(getTitle()).setVisible(true);}

    private void btnGerirTransacoesActionPerformed(ActionEvent evt) { new JanelaTransacoes(getTitle()).setVisible(true);}

    public static void main(String[] args) {
        new JanelaPrincipal("JanelaPrincipal").setVisible(true);
    }

    private void btnGerirPecasActionPerformed(ActionEvent evt){
       JanelaGestaoPecas.mostrarGestaoPeca();
    }

    private void btnGerirVeiculosActionPerformed(ActionEvent evt){
        JanelaVeiculos.mostarGestorVeiculos();
    }

    private void btnVisualizarEstatisticasActionPerformed(ActionEvent evt){
        JanelaEstatisticas.mostrarEstatisticas();
    }
}
