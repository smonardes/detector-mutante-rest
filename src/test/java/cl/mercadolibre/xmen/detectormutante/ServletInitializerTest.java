package cl.mercadolibre.xmen.detectormutante;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;

@RunWith(MockitoJUnitRunner.class)
public class ServletInitializerTest {

    @InjectMocks
    private ServletInitializer servletInitializer;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void configure() throws Exception {
        SpringApplicationBuilder s = Mockito.mock(SpringApplicationBuilder.class);
        servletInitializer.configure(s);
    }
}
