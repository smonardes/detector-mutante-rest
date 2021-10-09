package cl.mercadolibre.xmen.detectormutante.domain;

import java.io.Serializable;

public class DNA implements Serializable {

    private static final long serialVersionUID = 7127360818023636845L;
    private String[] dna;

    public DNA() {
        super();
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
