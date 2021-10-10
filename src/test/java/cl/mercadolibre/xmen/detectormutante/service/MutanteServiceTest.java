package cl.mercadolibre.xmen.detectormutante.service;

import cl.mercadolibre.xmen.detectormutante.domain.History;
import cl.mercadolibre.xmen.detectormutante.exception.MutanteException;
import cl.mercadolibre.xmen.detectormutante.repository.HistoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class MutanteServiceTest {

    @InjectMocks
    private MutanteServiceImpl mutanteService;

    @Mock
    private HistoryRepository historyRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = MutanteException.class)
    public void isMutantLetrasNoValidas() throws Exception {
        String[] dna = {"D"};
        this.mutanteService.isMutant(dna);
    }

    @Test(expected = MutanteException.class)
    public void isMutantEstructurNoValidas() throws Exception {
        String[] dna = {"A", "AA"};
        this.mutanteService.isMutant(dna);
    }

    @Test
    public void isMutantHorizontalExistenteBD() throws Exception {
        String[] dna = {"AAAA", "AAAA", "AAAA", "AAAA"};

        History history = new History();
        history.setMutante(true);
        history.setCodigo("AAAAAAAAAAAAAAAA");

        Mockito.when(historyRepository.findById(Mockito.anyString())).thenReturn(java.util.Optional.of(history));
        this.mutanteService.isMutant(dna);
    }

    @Test
    public void isMutantHorizontalNoExistenteBD() throws Exception {
        String[] dna = {"AAAA", "AAAA", "AAAA", "AAAA"};

        Mockito.when(historyRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        this.mutanteService.isMutant(dna);
    }

    @Test
    public void isMutantVerticalNoExistenteBD() throws Exception {
        String[] dna = {"ATGG", "AGTT", "ATGG", "AGTT"};

        Mockito.when(historyRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        this.mutanteService.isMutant(dna);
    }

    @Test
    public void isMutantDiagonalNoExistenteBD() throws Exception {
        String[] dna = {"ATGG", "TATT", "ATAG", "AGTA"};

        Mockito.when(historyRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        this.mutanteService.isMutant(dna);
    }

    @Test
    public void isMutantNoMutanteNoExistenteBD() throws Exception {
        String[] dna = {"ATCG", "TCGA", "CGAT", "GATC"};

        Mockito.when(historyRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        this.mutanteService.isMutant(dna);
    }

    @Test
    public void obtenerEstadisticaTest() throws Exception {
        List<History> histories = new ArrayList<>();
        History history = new History();
        history.setMutante(false);
        history.setCodigo("AAAAAAAAAAAAAAAA");
        History history2 = new History();
        history.setMutante(true);
        history.setCodigo("AAAAAAAAAAAAAAAA");
        histories.add(history);
        histories.add(history2);
        Mockito.when(historyRepository.findAll()).thenReturn(histories);
        this.mutanteService.obtenerEstadistica();
    }

    @Test(expected = Exception.class)
    public void guardarRegistroException() {
        Mockito.doThrow(Exception.class).when(historyRepository).save(Mockito.any(History.class));
        this.mutanteService.guardarRegistro(new String[]{""}, true);
    }
}
