package cl.mercadolibre.xmen.detectormutante.controller;

import cl.mercadolibre.xmen.detectormutante.domain.DNA;
import cl.mercadolibre.xmen.detectormutante.domain.Estadistica;
import cl.mercadolibre.xmen.detectormutante.exception.MutanteException;
import cl.mercadolibre.xmen.detectormutante.service.MutanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sebastianmt
 */
@RestController
public class MutanteController {

    @Autowired
    private MutanteService mutanteService;

    /**
     * Controller para determinar si un DNA corresponde a un mutante
     *
     * @param dna arreglo de String con la definicion del dna
     * @return Http status code 200 cuando es mutante, code 403 para cuando no es mutante
     */
    @PostMapping(value = "/mutant", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isMutant(@RequestBody DNA dna) throws MutanteException {
        if (this.mutanteService.isMutant(dna.getDna())) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Controller para ver estadisticas de todas las consultas realizadas en el sistema
     *
     * @return estadisticas de consultas de mutantes realizadas
     */
    @GetMapping(value = "/stats")
    public ResponseEntity<Estadistica> obtenerEstadistica() {
        return new ResponseEntity<>(this.mutanteService.obtenerEstadistica(), HttpStatus.OK);
    }
}
