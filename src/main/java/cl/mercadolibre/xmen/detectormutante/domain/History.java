package cl.mercadolibre.xmen.detectormutante.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class History {

    @Id
    private String codigo;

    private boolean mutante;

    public History() {
        super();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isMutante() {
        return mutante;
    }

    public void setMutante(boolean mutante) {
        this.mutante = mutante;
    }
}
