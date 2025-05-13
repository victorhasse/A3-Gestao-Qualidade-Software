package dao.cliente;

import java.util.*;

import entidade.Cliente;
import java.util.ArrayList;

/**
 * Interface que define as operações para a persistência de Cliente.
 *
 * @author osmarbraz
 */
public interface ClienteDAO {

    public boolean inserir(Object obj);

    public int alterar(Object obj);

    public int excluir(Object obj);

    public ArrayList<Cliente> aplicarFiltro(Object obj);

    public ArrayList<Cliente> getLista();
}
