package dao.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Collections;

import java.util.Collections;
import java.util.logging.Logger;

import dao.SQLiteDAOFactory;
import entidade.Cliente;

/**
 * Implementa a persistência de Cliente utilizando SQLite.
 *
 * @author osmarbraz
 */
public class SQLiteClienteDAO extends SQLiteDAOFactory implements ClienteDAO, SQLiteClienteMetaDados {

    public SQLiteClienteDAO() {
        criar();
    }
    
    public void fecharAcessoBD(Connection con, Statement stmt, ResultSet rs){
         if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
                con = null;
            }
    }

    private ArrayList<Cliente> select(String sql) {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() == true) {
                Cliente cliente = new Cliente();
                cliente.setCliente_id(rs.getString("CLIENTEID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCPF(rs.getString("CPF"));
                lista.add(cliente);
            }
            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (SQLException e) {
            System.out.println("Erro:" + " no select:" + e);
        } finally {
            fecharAcessoBD(con, stmt, rs);
        }
        return lista;
    }

    public boolean inserir(Object obj) {
       if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            boolean res = false;
            String sql = "";
            try {
                sql = "insert into " + TABLE + "(";
                sql = sql + METADADOSINSERT + " ) ";

                sql = sql + "values ('" + cliente.getCliente_id();
                sql = sql + "','" + cliente.getNome();
                sql = sql + "','" + cliente.getCPF() + "')";

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql) > 0;
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                System.out.println("Erro:" + " no inserir:" + e);
                res = false;
            } finally {
               fecharAcessoBD(con, stmt, null);
            }
            return res;
        }
        return false;
    }
    
    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            int res = 0;
            String sql = "";
            try {
                sql = "update " + TABLE;
                sql = sql + " set NOME='" + cliente.getNome() + "',";
                sql = sql + " CPF='" + cliente.getCPF() + "'";
                sql = sql + " where " + TABLE + "." + PK[0] + "='" + cliente.getCliente_id() + "'";

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql);
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                System.out.println("Erro:" + " no alterar:" + e);
                res = 0;
            } finally {
                fecharAcessoBD(con, stmt, null);
            }
            return res;
        }
        return 0;
    }

    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            String sql = "";
            int res = 0;
            try {
                sql = "delete from " + TABLE + " where " + TABLE + "." + PK[0] + " = '" + cliente.getCliente_id() + "'";
                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql);
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (Exception e) {
                System.out.println("Erro:" + " no excluir:" + e);
                res = 0;
            } finally {
                fecharAcessoBD(con, stmt, null);
            }
            return res;
        }
        return 0;
    }

    public ArrayList<Cliente> getLista() {
        String sql = "select " + METADADOSSELECT + " from " + TABLE + " order by " + TABLE + "." + PK[0];
        return select(sql);
    }
    
    public ArrayList<Cliente> aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;

            String sql = "";
            sql  = "select " + METADADOSSELECT + " from " + TABLE;

            List<String> filtros = new ArrayList();

            if (cliente.getCliente_id() != null && !"".equals(cliente.getCliente_id())) {
                filtros.add(TABLE + "." + PK[0] + "='" + cliente.getCliente_id() + "'");
            }

            if (cliente.getNome() != null && !"".equals(cliente.getNome())) {
                filtros.add(TABLE + ".NOME like upper('%" + cliente.getNome() + "%')");
            }

            if (cliente.getCPF() != null && !"".equals(cliente.getCPF())) {
                filtros.add(TABLE + ".CPF = '" + cliente.getCPF() + "'");
            }

            if (!filtros.isEmpty()) {
                sql = sql + " where " + implode(" and ", filtros);
            }

            sql = sql + " order by " + TABLE + "." + PK[0];

            return select(sql);
        } else {
            return new ArrayList();
        }
    }

    private void criar() {
        Connection con = null;
        Statement stmt = null;
        try {
            con = getConnection();
            stmt = con.createStatement();
            String sql = "create table IF NOT EXISTS cliente (clienteId integer, nome varchar(100), cpf varchar(11), CONSTRAINT PK_Cliente PRIMARY KEY (clienteID));";
            //Cria a tabela senão existir
            stmt.execute(sql);
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (Exception e) {
            System.out.println("Erro:" + " no criar:" + e);
        } finally {
            fecharAcessoBD(con, stmt, null);
        }
    }
}