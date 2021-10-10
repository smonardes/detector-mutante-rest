package cl.mercadolibre.xmen.detectormutante.domain;

import java.io.Serializable;

public class Estadistica implements Serializable {

    private static final long serialVersionUID = 760465604812231508L;
    private int countMutantDna;
    private int countHumanDna;
    private double ratio;

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

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
