package cl.mercadolibre.xmen.detectormutante.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Util {

    private Util() {}

    /**
     *  Metodo que permite concatenar la secuencia de caracteres de DNA, para establecer un codigo unico para la BD
     *
     * @param dna array de String de DNA
     * @return secuencia DNA concatenada
     */
    public static String obtenerCodigo(String[] dna) {
        return String.join(Constantes.EMPTY, dna);
    }

    /**
     * Utilitario para validar las letras de la estructura DNA
     *
     * @param dna estructura dna concatenada
     * @return true si las letras son validas, false si hay otro caracter en la cadena
     */
    public static boolean isLetrasValidasDna(String dna) {
        for (char s : dna.toCharArray()) {
            boolean val = false;
            for (char x : Constantes.CARACTERES_DNA) {
                if (s == x) {
                    val = true;
                    break;
                }
            }
            if (!val) return false;
        }
        return true;
    }

    /**
     * Utilitario para determinar sin el DNA ingresado tiene la forma N*N
     *
     * @param dna estructura dna
     * @return true si la estructura es valida, false si la estructura no es valida
     */
    public static boolean isEstructuraValida(String[] dna) {
        for (String s : dna) {
            if (s.length() != dna.length) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     *
     * @param dna
     * @return
     */
    public static boolean validarHorizontal(String[] dna) {
        for (String s : dna) {
            if (Util.validarCadenaDna(s)) {
                return true;
            }

        }
        return false;
    }

    /**
     * Utilitario para ordenar los elementos verticales en nuevos elementos de un arreglo para validarlos
     *
     * @param dna
     * @return
     */
    public static boolean validarVertical(String[] dna) {
        List<String> ordenados = new ArrayList<>();
        for (int i = 0; i < dna.length; i++) {
            int cont = 0;
            for (char x : dna[i].toCharArray()) {
                if (i == 0) {
                    ordenados.add(String.valueOf(x));
                } else {
                    ordenados.set(cont, ordenados.get(cont).concat(String.valueOf(x)));
                }
                cont++;
            }
        }

        for (String cadenaDna : ordenados) {
            if (Util.validarCadenaDna(cadenaDna)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Utilitario para obtener elementos en diagonal y realizar la validacion de DNA
     *
     * @param dna
     * @return
     */
    public static boolean validarDiagonal(String[] dna) {
        int dimension = dna.length;
        String[][] matriz = new String[dimension][dimension];
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].toCharArray().length; j++) {
                matriz[i][j] = String.valueOf(dna[i].charAt(j));
            }
        }

        List<String> diagonales = new ArrayList<>();
        int contadorDiagonales = 0;
        for (int diag = 1-dna.length; diag <= dimension -1; diag+=1) {
            int count = 0;
            for (int vert = Math.max(0, diag), hor = -Math.min(0, diag);
                 vert< dimension && hor<dimension; vert+=1, hor+=1) {
                if (count == 0) {
                    diagonales.add(matriz[vert][hor]);
                } else {
                    diagonales.set(contadorDiagonales, diagonales.get(contadorDiagonales).concat(matriz[vert][hor]));
                }
                count++;
            }
            if (Util.validarCadenaDna(diagonales.get(contadorDiagonales))) {
                return true;
            }
            contadorDiagonales++;
        }
        return false;
    }

    /**
     * Utilitario para validar cadenas de String identificando si tiene 4 valores repetidos de forma continua
     *
     * @param cadena
     * @return true si hay 4 caracteres coincidentes continuos false si no
     */
    public static boolean validarCadenaDna(String cadena) {
        String ultimoValorEvaluado = Constantes.EMPTY;
        int contadorCoincidenciasContinuas = Constantes.CERO;

        for (int i = 0; i <= cadena.length()-1; i++) {
            String caracterEnEvaluacion = String.valueOf(cadena.charAt(i));

            if (caracterEnEvaluacion.equalsIgnoreCase(ultimoValorEvaluado)) {
                contadorCoincidenciasContinuas++;

                if (Constantes.ACIERTOS_DNA_MUTANTE == contadorCoincidenciasContinuas) {
                    return true;
                }
            } else {
                contadorCoincidenciasContinuas = Constantes.CERO;
            }
            ultimoValorEvaluado = caracterEnEvaluacion;
        }
        return false;
    }
}
