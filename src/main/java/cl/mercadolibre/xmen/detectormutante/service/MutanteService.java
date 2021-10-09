package cl.mercadolibre.xmen.detectormutante.service;

import cl.mercadolibre.xmen.detectormutante.domain.Estadistica;
import cl.mercadolibre.xmen.detectormutante.exception.MutanteException;

/**
 * @author sebastianmt
 */
public interface MutanteService {

    /**
     * Servicio para detectar si un DNA es de mutante o no
     *
     * @param dna Arreglo de secuencia de ADN
     * @return true = es mutante - false = no es mutante
     */
    boolean isMutant(String[] dna) throws MutanteException;

    /**
     * Servicio para obtener las estadisticas de consultas realizadas
     *
     * @return resumen de Estadistica
     */
    Estadistica obtenerEstadistica();
}
