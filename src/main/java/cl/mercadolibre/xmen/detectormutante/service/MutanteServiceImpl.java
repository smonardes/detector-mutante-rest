package cl.mercadolibre.xmen.detectormutante.service;

import cl.mercadolibre.xmen.detectormutante.domain.Estadistica;
import cl.mercadolibre.xmen.detectormutante.domain.History;
import cl.mercadolibre.xmen.detectormutante.exception.MutanteException;
import cl.mercadolibre.xmen.detectormutante.repository.HistoryRepository;
import cl.mercadolibre.xmen.detectormutante.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MutanteServiceImpl implements MutanteService{

    private static final Logger LOGGER = LoggerFactory.getLogger(MutanteServiceImpl.class);

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public boolean isMutant(String[] dna) throws MutanteException {
        String codigo = Util.obtenerCodigo(dna);

        if (!Util.isLetrasValidasDna(codigo) || !Util.isEstructuraValida(dna)) {
            throw new MutanteException("La estructura DNA no es valida",
                    new Exception("La estructura DNA no es valida"), "DMR001", HttpStatus.BAD_REQUEST);
        }

        Optional<History> history = this.historyRepository.findById(codigo);

        return history.map(History::isMutante).orElseGet(() -> this.evaluarDna(dna));
    }

    @Override
    public Estadistica obtenerEstadistica() {
        List<History> historyList = (List<History>) this.historyRepository.findAll();
        int mutantes = 0;
        int humanos = 0;

        for (History history : historyList) {
            if (history.isMutante()) {
                mutantes++;
            } else {
                humanos++;
            }
        }

        Estadistica estadistica = new Estadistica();
        estadistica.setCountMutantDna(mutantes);
        estadistica.setCountHumanDna(humanos);
        estadistica.setRatio(humanos != 0 ? mutantes/humanos : 0);
        return estadistica;
    }

    @Async
    public void guardarRegistro(String[] dna, boolean isMutante) {
        try {
            History history = new History();
            history.setCodigo(Util.obtenerCodigo(dna));
            history.setMutante(isMutante);
            this.historyRepository.save(history);
        } catch (Exception e) {
            LOGGER.info("no guardado");
        }
    }

    private boolean evaluarDna(String[] dna) {
        if (Util.validarHorizontal(dna) || Util.validarVertical(dna) || Util.validarDiagonal(dna)) {
            this.guardarRegistro(dna, true);
            return true;
        } else {
            this.guardarRegistro(dna, false);
            return false;
        }
    }
}
