package cl.mercadolibre.xmen.detectormutante.controller;

import cl.mercadolibre.xmen.detectormutante.domain.Estadistica;
import cl.mercadolibre.xmen.detectormutante.service.MutanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutanteController {

    @Autowired
    private MutanteService mutanteService;

    @PostMapping(value = "/mutant", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isMutant(String[] dna) {
        if (this.mutanteService.isMutant(dna)) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/stats")
    public ResponseEntity<Estadistica> obtenerEstadistica() {
        return new ResponseEntity<>(this.mutanteService.obtenerEstadistica(), HttpStatus.OK);
    }
}
