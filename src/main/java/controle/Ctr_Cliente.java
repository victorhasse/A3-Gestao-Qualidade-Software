package controle;

import java.awt.event.ActionEvent;

import formulario.FrmCliente;
import entidade.*;
import util.Valida;

/**
 * Classe que realiza a interação entre a interface e a entidade do sistema.
 *
 * @author osmarbraz
 */
public class Ctr_Cliente {

    private FrmCliente frmCliente;

    /**
     * Construtor sem argumentos.
     */
    public Ctr_Cliente() {

        // Instancia a janela
        setFrmCliente(new FrmCliente());

        // Associa os eventos aos componentes
        getFrmCliente().getjBIncluir().addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBIncluir_actionPerformed(e);
                    }
                });

        getFrmCliente().getjBAlterar().addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBAlterar_actionPerformed(e);
                    }
                });

        getFrmCliente().getjBConsultar().addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBConsultar_actionPerformed(e);
                    }
                });

        getFrmCliente().getjBExcluir().addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBExcluir_actionPerformed(e);
                    }
                });

        getFrmCliente().getjBLimpar().addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBLimpar_actionPerformed(e);
                    }
                });

        getFrmCliente().getjBFechar().addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBFechar_actionPerformed(e);
                    }
                });
    }

    /**
     * Operação que inicia a sequência de interações da manutenção de Cliente.
     */
    public void ExecutarCtrl_Cliente() {
        getFrmCliente().setVisible(true);
    }

    /**
     * Inclui um Cliente.
     *
     * @param e Objeto do evento.
     */
    public void jBIncluir_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setCliente_id(getFrmCliente().getjTClienteId().getText());
        cliente.setNome(getFrmCliente().getjTNome().getText());
        cliente.setCPF(getFrmCliente().getjTCpf().getText());
        Valida valida = new Valida();
        boolean cpfValido = valida.ValidaCPF(cliente.getCPF());
        if (cpfValido == true) {
            boolean resultado = cliente.inserir();
            if (resultado == true) {
                getFrmCliente().mostrarMensagem("Inclusão realizada com sucesso!");
            } else {
                getFrmCliente().mostrarMensagem("Inclusão não realizada!");
            }
        } else {
            getFrmCliente().mostrarMensagem("CPF Inválido!");
        }
    }

    /**
     * Altera um Cliente.
     *
     * @param e Objeto do evento.
     */
    public void jBAlterar_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setCliente_id(getFrmCliente().getjTClienteId().getText());
        cliente.setNome(getFrmCliente().getjTNome().getText());
        cliente.setCPF(getFrmCliente().getjTCpf().getText());
        Valida valida = new Valida();
        boolean cpfValido = valida.ValidaCPF(cliente.getCPF());
        if (cpfValido == true) {
            int resultado = cliente.alterar();
            if (resultado != 0) {
                getFrmCliente().mostrarMensagem("Alteração realizada com sucesso!");
            } else {
                getFrmCliente().mostrarMensagem("Alteração nao realizada!");
            }
        } else {
            getFrmCliente().mostrarMensagem("CPF Inválido!");
        }
    }

    /**
     * Consulta um Cliente.
     *
     * @param e Objeto do evento.
     */
    public void jBConsultar_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setCliente_id(getFrmCliente().getjTClienteId().getText());
        boolean resultado = cliente.abrir();
        if (resultado == true) {
            getFrmCliente().getjTNome().setText(cliente.getNome());
            getFrmCliente().getjTCpf().setText(cliente.getCPF());
            getFrmCliente().mostrarMensagem("Cliente encontrado!");
        } else {
            getFrmCliente().mostrarMensagem("Cliente não encontrado!");
        }
    }

    /**
     * Excluí o Cliente.
     *
     * @param e Objeto do evento.
     */
    public void jBExcluir_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setCliente_id(getFrmCliente().getjTClienteId().getText());
        int resultado = cliente.excluir();
        if (resultado != 0) {
            getFrmCliente().mostrarMensagem("Exclusão realizada com sucesso!");
        } else {
            getFrmCliente().mostrarMensagem("Exclusão nao realizada!");
        }
    }

    /**
     * Limpa as caixas de texto.
     *
     * @param e Objeto do evento.
     */
    public void jBLimpar_actionPerformed(ActionEvent e) {
        getFrmCliente().getjTClienteId().setText("");
        getFrmCliente().getjTNome().setText("");
        getFrmCliente().getjTCpf().setText("");
    }

    /**
     * Fecha o sistema.
     *
     * @param e Objeto do evento.
     */
    public void jBFechar_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
     * Retorna o formulário utilizado por este controle.
     */
    public FrmCliente getFrmCliente() {
        return frmCliente;
    }

    /**
     * Modifica o formulário utilizando por este controle.
     *
     */
    public void setFrmCliente(FrmCliente frmCliente) {
        this.frmCliente = frmCliente;
    }
}
