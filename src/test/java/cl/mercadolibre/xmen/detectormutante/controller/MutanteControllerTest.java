package cl.mercadolibre.xmen.detectormutante.controller;

import cl.mercadolibre.xmen.detectormutante.domain.DNA;
import cl.mercadolibre.xmen.detectormutante.domain.Estadistica;
import cl.mercadolibre.xmen.detectormutante.exception.MutanteException;
import cl.mercadolibre.xmen.detectormutante.service.MutanteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MutanteControllerTest {

    @InjectMocks
    private MutanteController mutanteController = new MutanteController();

    @Mock
    private MutanteService mutanteService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isMutantTest() throws MutanteException {
        DNA dna = new DNA();
        String[] estructura = {"AAAA"};
        dna.setDna(estructura);

        Mockito.when(mutanteService.isMutant(Mockito.any(String[].class))).thenReturn(true);

        mutanteController.isMutant(dna);
    }

    @Test
    public void isMutantFalseTest() throws MutanteException {
        DNA dna = new DNA();
        String[] estructura = {"AAAA"};
        dna.setDna(estructura);

        Mockito.when(mutanteService.isMutant(Mockito.any(String[].class))).thenReturn(false);

        mutanteController.isMutant(dna);
    }

    @Test
    public void obtenerEstadisticaTest() throws Exception {
        Mockito.when(this.mutanteService.obtenerEstadistica()).thenReturn(new Estadistica());
        mutanteController.obtenerEstadistica();
    }

}
