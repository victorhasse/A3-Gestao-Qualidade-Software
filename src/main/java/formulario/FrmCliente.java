package formulario;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 * Classe que implementa a interface principal do sistema.
 *
 * @author osmarbraz
 */
public class FrmCliente extends JFrame {

    private JPanel contentPane;

    private JLabel jLClienteId;
    private JTextField jTClienteId;
    private JLabel jLNome;
    private JTextField jTNome;
    private JLabel jLCpf;
    private JTextField jTCpf;

    private JButton jBIncluir;
    private JButton jBAlterar;
    private JButton jBExcluir;
    private JButton jBConsultar;
    private JButton jBLimpar;
    private JButton jBFechar;
    
    private String mensagem;

    /**
     * Construtor sem argumentos.
     */
    public FrmCliente() {
        Inicializar();
    }

    public JLabel getjLClienteId() {
        return jLClienteId;
    }

    public void setjLClienteId(JLabel jLClienteId) {
        this.jLClienteId = jLClienteId;
    }

    public JTextField getjTClienteId() {
        return jTClienteId;
    }

    public void setjTClienteId(JTextField jTClienteId) {
        this.jTClienteId = jTClienteId;
    }

    public JLabel getjLNome() {
        return jLNome;
    }

    public void setjLNome(JLabel jLNome) {
        this.jLNome = jLNome;
    }

    public JTextField getjTNome() {
        return jTNome;
    }

    public void setjTNome(JTextField jTNome) {
        this.jTNome = jTNome;
    }

    public JLabel getjLCpf() {
        return jLCpf;
    }

    public void setjLCpf(JLabel jLCpf) {
        this.jLCpf = jLCpf;
    }

    public JTextField getjTCpf() {
        return jTCpf;
    }

    public void setjTCpf(JTextField jTCpf) {
        this.jTCpf = jTCpf;
    }

    public JButton getjBIncluir() {
        return jBIncluir;
    }

    public void setjBIncluir(JButton jBIncluir) {
        this.jBIncluir = jBIncluir;
    }

    public JButton getjBAlterar() {
        return jBAlterar;
    }

    public void setjBAlterar(JButton jBAlterar) {
        this.jBAlterar = jBAlterar;
    }

    public JButton getjBExcluir() {
        return jBExcluir;
    }

    public void setjBExcluir(JButton jBExcluir) {
        this.jBExcluir = jBExcluir;
    }

    public JButton getjBConsultar() {
        return jBConsultar;
    }

    public void setjBConsultar(JButton jBConsultar) {
        this.jBConsultar = jBConsultar;
    }

    public JButton getjBLimpar() {
        return jBLimpar;
    }

    public void setjBLimpar(JButton jBLimpar) {
        this.jBLimpar = jBLimpar;
    }

    public JButton getjBFechar() {
        return jBFechar;
    }

    public void setjBFechar(JButton jBFechar) {
        this.jBFechar = jBFechar;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    /**
     * Inicializa os componentes da janela.
     */
    protected void Inicializar() {
        contentPane = (JPanel) this.getContentPane();

        jLClienteId = new JLabel();
        jTClienteId = new JTextField();
        jLNome = new JLabel();
        jTNome = new JTextField();
        jLCpf = new JLabel();
        jTCpf = new JTextField();

        jBIncluir = new JButton();
        jBAlterar = new JButton();
        jBConsultar = new JButton();
        jBExcluir = new JButton();
        jBLimpar = new JButton();
        jBFechar = new JButton();

        contentPane.setLayout(null);
        this.setSize(new Dimension(320, 250));
        this.setTitle("Cadastro de Cliente");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jLClienteId.setBounds(new Rectangle(11, 11, 60, 17));
        jTClienteId.setBounds(new Rectangle(11, 28, 70, 21));
        jLClienteId.setText("ClienteId");

        jLNome.setBounds(new Rectangle(11, 60, 60, 17));
        jTNome.setBounds(new Rectangle(11, 75, 180, 21));
        jLNome.setText("Nome");

        jLCpf.setBounds(new Rectangle(11, 109, 170, 17));
        jTCpf.setBounds(new Rectangle(11, 124, 120, 21));
        jLCpf.setText("Cpf (Somente numeros)");

        jBIncluir.setBounds(new Rectangle(200, 9, 90, 27));
        jBIncluir.setText("Incluir");

        jBAlterar.setBounds(new Rectangle(200, 39, 90, 27));
        jBAlterar.setText("Alterar");

        jBExcluir.setBounds(new Rectangle(200, 69, 90, 27));
        jBExcluir.setText("Excluir");

        jBConsultar.setBounds(new Rectangle(200, 99, 90, 27));
        jBConsultar.setText("Consultar");

        jBLimpar.setBounds(new Rectangle(200, 129, 90, 27));
        jBLimpar.setText("Limpar");

        jBFechar.setBounds(new Rectangle(200, 159, 90, 27));
        jBFechar.setText("Fechar");

        contentPane.add(jLClienteId, null);
        contentPane.add(jTClienteId, null);
        contentPane.add(jLNome, null);
        contentPane.add(jTNome, null);
        contentPane.add(jLCpf, null);
        contentPane.add(jTCpf, null);

        contentPane.add(jBIncluir, null);
        contentPane.add(jBAlterar, null);
        contentPane.add(jBExcluir, null);
        contentPane.add(jBConsultar, null);
        contentPane.add(jBLimpar, null);
        contentPane.add(jBFechar, null);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Processa os eventos da janela.
     *
     * @param e Eventos da janela.
     */
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
}