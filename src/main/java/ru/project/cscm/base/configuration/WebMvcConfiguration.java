package ru.project.cscm.base.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ru.project.cscm.base.security.rest.RequestInterceptor;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private RequestInterceptor requestInterceptor;

	@Value("${server.cors.allowed.origins}")
	private String allowedOrigins;

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(requestInterceptor);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins(StringUtils.tokenizeToStringArray(allowedOrigins, ",;"))
				.allowedMethods("OPTIONS", "POST", "GET", "PUT", "DELETE", "HEAD");
	}

	
}
