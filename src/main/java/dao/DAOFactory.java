package dao;

import dao.cliente.ClienteDAO;

/**
 * Abstrai as fontes de dados do sistema.
 *
 * @author osmarbraz
 */
public abstract class DAOFactory {

    //Tipos de Fonte de Dados suportados pela Factory
    static final int SQLITE = 1;
    static final int HASHMAP = 2;
    
    //Retorna o DAO instanciado
    public abstract ClienteDAO getClienteDAO();

    /**
     * Retorna a Factory do tipo especificado
     *
     * @param qualFabrica Especifica a fábrica a ser selecionada.
     * @return Um fábrica.
     */
    public static DAOFactory getDAOFactory(int qualFabrica) {
        switch (qualFabrica) {
            case SQLITE:
                return new SQLiteDAOFactory();
            case HASHMAP:
                return new HashMapDAOFactory();           
            default:
                return null;
        }
    }
}