package ru.project.cscm;

import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class CscmApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	@Override
	@NotNull
	protected SpringApplicationBuilder configure(@NotNull final SpringApplicationBuilder builder) {
		return configureApplication(builder);
	}

	public static void main(final String[] args) {
		configureApplication(new SpringApplicationBuilder()).run(args);
	}

	@NotNull
	private static SpringApplicationBuilder configureApplication(@NotNull final SpringApplicationBuilder builder) {
		return builder.sources(CscmApplication.class);
	}

}