package util;

import java.util.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 * Classe utilitária para conter operações de validação
 *
 * @author osmarbraz
 */
public class Valida {

   /**
     * Valida os digitos verificadores de um CPF.
     *
     * @param cpf Um literal com um cpf de cliente.
     */
    public boolean ValidaCPF(String cpf) {
        boolean retorno = false;
        if ((cpf.length() == 11) == true) {            
            String digitos = cpf.substring(9, 11);
            int soma = 0, multiplicacao = 11;
            int[] valores = new int[11];
            // Recebe os números e realiza a multiplicação e soma.   
            for (int i = 0; i < 9; i++) {
                valores[i] = Integer.parseInt("" + cpf.charAt(i));
                if (i < 9) {
                    soma += (valores[i] * --multiplicacao);
                }
            }
            // Cria o primeiro dígito verificador.   
            int resto = soma % 11;
            if (resto < 2) {
                valores[9] = 0;
            } else {
                valores[9] = 11 - resto;
            }
            // Reinicia os valores.   
            soma = 0;
            multiplicacao = 11;
            // Realiza a multiplicação e soma do segundo dígito.   
            for (int i = 0; i < 10; i++) {
                soma += valores[i] * multiplicacao--;
            }
            // Cria o segundo dígito verificador.   
            resto = soma % 11;
            if (resto < 2) {
                valores[10] = 0;
            } else {
                valores[10] = 11 - resto;
            }
            if ((digitos.substring(0, 1).equalsIgnoreCase(Integer.toString(valores[9])))
                    && (digitos.substring(1, 2).equalsIgnoreCase(Integer.toString(valores[10])))) {
                retorno = true;
            }
        }
        return retorno;
    }
}