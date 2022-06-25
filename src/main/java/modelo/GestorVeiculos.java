package modelo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class GestorVeiculos {
    public static GestorVeiculos INSTANCE = new GestorVeiculos();
    private List<Veiculo> veiculos;

    public GestorVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    public boolean existeVeiculoComMatricula(String matricula) {
        for (Veiculo veiculo : veiculos) {
            if (matricula.equals(veiculo.getMatricula())) {
                return true;
            }
        }
        return false;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);

        for (Veiculo veiculo1 : veiculos) {
            System.out.println(veiculo1.getMatricula());
        }
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public Veiculo getVeiculo(String matricula) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMatricula().equals(matricula)) {
                return veiculo;
            }
        }
        return null;
    }
}
