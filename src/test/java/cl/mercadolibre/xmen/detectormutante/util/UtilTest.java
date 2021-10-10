package cl.mercadolibre.xmen.detectormutante.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UtilTest {

    @Test
    public void obtenerCodigoTest() {
        Util.obtenerCodigo(new String[]{""});
    }

    @Test
    public void isLetrasValidasDnaTest() {
        Assert.assertTrue(Util.isLetrasValidasDna("ATAAAA"));
    }

    @Test
    public void isLetrasValidasDnaFalseTest() {
        Assert.assertFalse(Util.isLetrasValidasDna("ADAAA"));
    }

    @Test
    public void isEstructuraValidaTest() {
        Assert.assertTrue(Util.isEstructuraValida(new String[]{"AA","AA"}));
    }

    @Test
    public void isEstructuraValidaFalseTest() {
        Assert.assertFalse(Util.isEstructuraValida(new String[]{"AA","A"}));
    }

    @Test
    public void validarHorizontalTest() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assert.assertTrue(Util.validarHorizontal(dna));
    }

    @Test
    public void validarHorizontalFalseTest() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCTTA","TCACTG"};
        Assert.assertFalse(Util.validarHorizontal(dna));
    }

    @Test
    public void validarVerticalTest() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assert.assertTrue(Util.validarVertical(dna));
    }

    @Test
    public void validarVerticalFalseTest() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"};
        Assert.assertFalse(Util.validarVertical(dna));
    }

    @Test
    public void validarDiagonalTest() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assert.assertTrue(Util.validarDiagonal(dna));
    }

    @Test
    public void validarDiagonalFalseTest() {
        String[] dna = {"CTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Assert.assertFalse(Util.validarDiagonal(dna));
    }
}
