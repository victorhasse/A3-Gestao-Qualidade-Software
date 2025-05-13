package dao.cliente;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

import dao.HashMapDAOFactory;
import entidade.Cliente;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementa a persitência para Cliente utilizando HashMap.
 *
 * @author osmarbraz
 */
public class HashMapClienteDAO extends HashMapDAOFactory implements ClienteDAO {
        
    private static final Map<String, Cliente> mapa = new HashMap<>();
    
    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getCliente_id());
            if (tem == false) {
                mapa.put(cliente.getCliente_id(), cliente);
                return true;
            } else {
                System.out.println("Problema:" + " em inserir o registro!");                
            }
        }
        return false;
    }

    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getCliente_id());
            if (tem == true) {
                Cliente c = mapa.get(cliente.getCliente_id());
                c.setNome(cliente.getNome());
                c.setCPF(cliente.getCPF());
                return 1;
            } else {
                System.out.println("Problema:" + " em altear o registro!");
            }
        }
        return 0;
    }

    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getCliente_id());
            if (tem == true) {
                mapa.remove(cliente.getCliente_id());
                return 1;
            } else {
                System.out.println("Problema:" + " em excluir o registro!");
            }
        }
        return 0;
    }

    public ArrayList<Cliente> getLista() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Iterator<Cliente> it = mapa.values().iterator();
        while (it.hasNext() == true) { //Avança enquanto tiver objetos
            Cliente c = it.next();
            lista.add(c);
        }
        return lista;
    }
    
    @Override
    public ArrayList<Cliente> aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            ArrayList<Cliente> lista = new ArrayList<>();
            Iterator<Cliente> it = mapa.values().iterator();

            while (it.hasNext() == true) { //Avança enquanto tiver objetos
                Cliente c = it.next();

                //Filtro para clienteId
                if (c.getCliente_id().equalsIgnoreCase(cliente.getCliente_id()))  {
                        lista.add(c);                    
                }

                //Filtro para nome
                if (c.getCliente_id().equalsIgnoreCase(cliente.getCliente_id())) {
                     lista.add(c);                    
                }

                //Filtro para CPF
                if (c.getCPF().equalsIgnoreCase(cliente.getCPF())) {
                    lista.add(c);                    
                }
            }
            return lista;
        } else {
            return new ArrayList();
        }
    }
}