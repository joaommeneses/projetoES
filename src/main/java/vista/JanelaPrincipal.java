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


        gerirVeiculosButton.addActionListener(this::btnGerirVeiculosActionPerformed);
        gerirClientesButton.addActionListener(this::btnGerirClientesActionPerformed);
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

}
