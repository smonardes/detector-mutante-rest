package cl.mercadolibre.xmen.detectormutante.domain;

import java.io.Serializable;

public class Estadistica implements Serializable {

    private static final long serialVersionUID = 760465604812231508L;
    private int countMutantDna;
    private int countHumanDna;
    private float ratio;

    public Estadistica() {
        super();
    }

    public int getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(int countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public int getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(int countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}
