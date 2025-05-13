package dao;

import dao.cliente.ClienteDAO;
import dao.cliente.HashMapClienteDAO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 * Implementa a fonte de dado para persistência em memória utilizando HashMap.
 *
 * @author osmarbraz
 */
public class HashMapDAOFactory extends DAOFactory {

    /**
     * Retorna uma Cliente DAO
     *
     * @return ClienteDAO Um DAO para cliente
     */
    public ClienteDAO getClienteDAO() {
        return new HashMapClienteDAO();
    }
}
