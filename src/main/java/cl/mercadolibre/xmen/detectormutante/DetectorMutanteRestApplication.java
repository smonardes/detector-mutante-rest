package cl.mercadolibre.xmen.detectormutante;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DetectorMutanteRestApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DetectorMutanteRestApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.properties("server.servlet.context-path=/detector-mutante-rest")
				.logStartupInfo(false)
				.build()
				.run(args);
	}

}
