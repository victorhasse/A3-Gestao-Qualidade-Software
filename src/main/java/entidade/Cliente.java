package entidade;

import java.util.List;

import dao.cliente.ClienteDAO;
import dao.DAOFactory;
import dao.Factory;
import java.util.ArrayList;

/**
 * Classe que representa a abstração principal do sistema.
 *
 * @author osmarbraz
 */
public class Cliente {

    /**
     * Serve para identificar um Cliente.
     */
    private String cliente_id;
    /**
     * Nome do Cliente.
     */
    private String nome;
    /**
     * CPF do Cliente
     */
    private String CPF;

    /**
     * Construtor sem argumentos da classe.
     */
    public Cliente() {
        this("", "", "");
    }

    /**
     * Construtor com argumentos da classe.
     *
     * @param clienteId
     * @param nome
     */
    public Cliente(String clienteId, String nome, String cpf) {
        setCliente_id(clienteId);
        setNome(nome);
        setCPF(cpf);
    }

    /**
     * Retorna o id de um Cliente.
     *
     * @return Uma string com o Id
     */
    public String getCliente_id() {
        return cliente_id;
    }

    /**
     * Modifica o id de um Cliente.
     *
     * @param cliente_id Um literal com o id de um Cliente.
     */
    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * Retorna o nome de um Cliente.
     *
     * @return Uma string com o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome de um Cliente.
     *
     * @param nome Um literal com o nome de um Cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o CPF de um Cliente.
     *
     * @return Uma string com o CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * Modifica o CPF de um Cliente.
     *
     * @param CPF Um literal com o CPF de um Cliente
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * Retorna uma string com o estado do objeto.
     */
    @Override
    public String toString() {
        return ("clienteId:" + getCliente_id() + " - Nome :" + getNome() + " - CPF :" + getCPF());
    }

    /**
     * Persiste um objeto.
     * @return Se conseguiu inserir o objeto.
     */
    public boolean inserir() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.inserir(this);
    }

    /**
     * Altera o estado de um objeto persistente.
     * @return A quantidade de objetos atualizados.
     */
    public int alterar() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.alterar(this);
    }

    /**
     * Exclui um objeto da persistência através do identificado.
     * @return 
     */
    public int excluir() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.excluir(this);
    }

    /**
     * Retorna uma lista de objetos que atende os valores passados pelo objeto.O Id realiza comparação e o nome realiza uma comparação parcial.
     * @return Uma lista com os objetos selecionados.
     */
    public ArrayList Aplicar_Filtro() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.aplicarFiltro(this);
    }

    /**
     * Retorna uma lista com todos os objetos.
     * @return Uma lista com todos os objetos.
     */
    public List getLista() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.getLista();
    }

    /**
     * Restaura o estado do objeto apartir do id.
     * @return Se conseguiu abrir o objeto.
     */
    public boolean abrir() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        List lista = clientedao.aplicarFiltro(this);
        if (lista.isEmpty() == false) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            setNome(oCliente.getNome());
            setCPF(oCliente.getCPF());
            return true;
        } else {
            return false;
        }
    }
}