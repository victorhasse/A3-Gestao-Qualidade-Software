package formulario;

/**
 * Classe que cria um formulário de cliente falso para ser utilizado nos testes.
 *
 * @author osmar
 */
public class FrmClienteFake extends FrmCliente {

    /**
     * Inicializa os atributos do formulário.
     */
    public FrmClienteFake() {
        Inicializar();
    }

    /**
     * Sobrescreve o método mostrarMensagem pois ele exibe uma mensagem usando
     * JOptionPane. Alterado para o console para poder realizar os testes.
     *
     * @param mensagem
     */
    @Override
    public void mostrarMensagem(String mensagem) {
        //Atribui a mensagem ao atributo para ser utilizado nos testes
        setMensagem(mensagem);

        //Mostra a mensagem
        System.out.println("Mensagem:" + mensagem);
    }
}