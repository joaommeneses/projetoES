package vista;

import modelo.Combustivel;
import modelo.GestorVeiculos;
import modelo.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaRegistoVeiculo extends JFrame {
    private JLabel labelMatricula;
    private JTextField textFieldMatricula;
    private JLabel labelMarca;
    private JTextField textFieldMarca;
    private JLabel labelModelo;
    private JTextField textFieldModelo;
    private JLabel labelAntigoDono;
    private JTextField textFieldAntigoDono;
    private JPanel jPanel;
    private JLabel labelNrDonos;
    private JTextField textFieldNrDonos;
    private JLabel labelCor;
    private JTextField textFieldCor;
    private JLabel labelKm;
    private JTextField textFieldKm;
    private JLabel labelTipoCombustivel;
    private JComboBox<Combustivel> comboBoxCombustivel;
    private JLabel labelPotencia;
    private JTextField textFieldPotencia;
    private JLabel labelCilindrada;
    private JTextField textFieldCilindrada;
    private JButton buttonSubmeter;
    private JLabel labelAno;
    private JTextField anoTextField;
    private JLabel labelPreco;
    private JTextField precoTextField;
    private JLabel labelTitulo;
    private JButton buttonCancelar;

    public JanelaRegistoVeiculo(String title) {
        super(title);
        setContentPane(jPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

        populateCombustiveis();

        buttonSubmeter.addActionListener(this::buttonSubmeterActionPerformed);
        buttonCancelar.addActionListener(this::buttonCancelarActionPerformed);

    }

    public static void mostrarAlterarVeiculo(Veiculo veiculo) {
        var janela = new JanelaRegistoVeiculo("Alterar Veiculo");
        janela.preencher(veiculo);
        janela.setVisible(true);
    }

    private void preencher(Veiculo veiculo) {
        textFieldMatricula.setText(veiculo.getMatricula());
        textFieldMatricula.setEditable(false);
        textFieldModelo.setText(veiculo.getModelo());
        textFieldModelo.setEditable(false);
        textFieldMarca.setText(veiculo.getMarca());
        textFieldMarca.setEditable(false);
        textFieldNrDonos.setText(String.valueOf(veiculo.getNrDonos()));
        textFieldCor.setText(String.valueOf(veiculo.getCor()));
        textFieldKm.setText(String.valueOf(veiculo.getKm()));
        comboBoxCombustivel.setSelectedItem(veiculo.getCombustivel());
        comboBoxCombustivel.setEnabled(false);
        textFieldAntigoDono.setText(veiculo.getAntigoDono());
        textFieldAntigoDono.setEditable(false);
        anoTextField.setText(String.valueOf(veiculo.getAno()));
        anoTextField.setEditable(false);
        textFieldPotencia.setText(String.valueOf(veiculo.getPotencia()));
        textFieldCilindrada.setText(String.valueOf(veiculo.getCilindrada()));
        precoTextField.setText(String.valueOf(veiculo.getPreco()));
    }

    private void populateCombustiveis() {
        for (Combustivel combustivel : Combustivel.values()) {
            comboBoxCombustivel.addItem(combustivel);
        }
    }

    private void buttonCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    public static void mostrarRegistoVeiculo() {
        var janela = new JanelaRegistoVeiculo("Registar Veiculo");
        janela.setVisible(true);
    }

    private void buttonSubmeterActionPerformed(ActionEvent evt) {
        var erros = 0;
        var valido = false;
        if(super.getTitle().equals("Registar Veiculo")) {
            valido = isMatriculaValida(textFieldMatricula.getText());


            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.MATRICULA_INVALIDA);
            }
        }
            valido = isMarcaValida(textFieldMarca.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.MARCA_INVALIDA);
            }

            valido = isModeloValido(textFieldModelo.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.MODELO_INVALIDO);
            }

            valido = isCorValida(textFieldCor.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.COR_INVALIDA);
            }

            valido = isKmValido(textFieldKm.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.KM_INVALIDO);
            }

            valido = isNrDonosValido(textFieldNrDonos.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.NRDONOS_INVALIDO);
            }

            valido = isPotenciaValida(textFieldPotencia.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.POTENCIA_INVALIDA);
            }

            valido = isCilindradaValida(textFieldCilindrada.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.CILINDRADA_INVALIDA);
            }

            valido = isAnoValido(anoTextField.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.ANO_INVALIDO);
            }

            valido = isPrecoValido(precoTextField.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.PRECO_INVALIDO);
            }

        if(super.getTitle().equals("Registar Veiculo")) {
            valido = !GestorVeiculos.INSTANCE.existeVeiculoComMatricula(textFieldMatricula.getText());

            if (!valido) {
                erros++;
                Erros.mostrarErro(this, Erros.MATRICULA_REPETIDA);
            }

            if (erros == 0) {
                Veiculo veiculo = new Veiculo(textFieldMatricula.getText(), textFieldMarca.getText(), textFieldModelo.getText(), Integer.parseInt(textFieldNrDonos.getText()),
                        textFieldCor.getText(), Double.parseDouble(textFieldKm.getText()), comboBoxCombustivel.getItemAt(comboBoxCombustivel.getSelectedIndex()), Integer.parseInt(textFieldPotencia.getText()),
                        Double.parseDouble(textFieldCilindrada.getText()), Integer.parseInt(anoTextField.getText()), Double.parseDouble(precoTextField.getText()), textFieldAntigoDono.getText());
                GestorVeiculos.INSTANCE.adicionarVeiculo(veiculo);
                fechar();
            }
        } else {
            if(erros == 0){
                Veiculo veiculo = GestorVeiculos.INSTANCE.getVeiculo(textFieldMatricula.getText());
                veiculo.setNrDonos(Integer.parseInt(textFieldNrDonos.getText()));
                veiculo.setCor(textFieldCor.getText());
                veiculo.setKm(Double.parseDouble(textFieldKm.getText()));
                veiculo.setPotencia(Integer.parseInt(textFieldPotencia.getText()));
                veiculo.setCilindrada(Double.parseDouble(textFieldCilindrada.getText()));
                veiculo.setPreco(Double.parseDouble(precoTextField.getText()));
                fechar();
            }
        }
    }

    private void fechar() {
        this.dispose();
    }

    private boolean isNrDonosValido(String nrDonos) {
        if (nrDonos.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    private boolean isPrecoValido(String preco) {
        if (preco.matches("^[0-9]+(\\.[0-9]+)?$")) {
            return true;
        }

        return false;
    }

    private boolean isAnoValido(String ano) {
        if (ano.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    private boolean isCilindradaValida(String cilindrada) {
        if (cilindrada.matches("^[0-9]+(\\.[0-9]+)?$")) {
            return true;
        }
        return false;
    }

    private boolean isPotenciaValida(String potencia) {
        if (potencia.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }


    private boolean isKmValido(String km) {
        if (km.matches("^[0-9]+(\\.[0-9]+)?$")) {
            return true;
        }
        return false;

    }

    private boolean isCorValida(String cor) {

        if (cor.matches("^[a-zA-Z]{4,}$")) {
            return true;
        }
        return false;
    }

    private boolean isModeloValido(String modelo) {
        if (modelo.matches("^[a-zA-Z0-9]{1,}$")) {
            return true;
        }
        return false;
    }

    private boolean isMarcaValida(String marca) {
        if (marca.matches("^[a-zA-Z]{2,}$")) {
            return true;
        }
        return false;
    }

    private boolean isMatriculaValida(String matriculaText) {
        if (matriculaText.matches("^[A-Z0-9]{2}-[A-Z0-9]{2}-[A-Z0-9]{2}$")) {
            return true;
        }

        return false;
    }
}

