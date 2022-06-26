package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    public static GestorClientes INSTANCE = new GestorClientes();

    private List<Cliente> clientes;

    private GestorClientes(){
        clientes = new ArrayList<Cliente>();
    }

    public void adicionarCliente(Cliente cliente){
        if (cliente == null || clientes.contains(cliente)) {
            return;
        }
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean existeClienteComNif(long nif){
        for(Cliente cliente : clientes){
            if (cliente.getNif() == nif) {
                return true;
            }
        }
        return false;
    }
}
