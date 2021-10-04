package cl.mercadolibre.xmen.detectormutante.service;

import cl.mercadolibre.xmen.detectormutante.domain.Estadistica;
import org.springframework.stereotype.Service;

@Service
public class MutanteServiceImpl implements MutanteService{

    @Override
    public boolean isMutant(String[] dna) {
        return false;
    }

    @Override
    public Estadistica obtenerEstadistica() {
        return new Estadistica();
    }
}
