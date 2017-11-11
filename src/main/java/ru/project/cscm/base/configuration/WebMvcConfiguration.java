package ru.project.cscm.base.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ru.project.cscm.base.security.rest.RequestInterceptor;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

  @Autowired 
  private RequestInterceptor requestInterceptor;

  @Override
  public void addInterceptors(final InterceptorRegistry registry) {
    super.addInterceptors(registry);
    registry.addInterceptor(requestInterceptor);
  }
}
