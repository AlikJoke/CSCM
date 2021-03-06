package ru.project.cscm.base.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ru.project.cscm.base.rest.OptionsCorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	public static final String RESOURCE_ID = "CSCM";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new OptionsCorsFilter(), UsernamePasswordAuthenticationFilter.class).anonymous().disable().csrf().disable().requiresChannel().requestMatchers().requiresSecure()
				.antMatchers("/CSCM/**").requiresSecure().and().authorizeRequests().antMatchers("/CSCM/**")
				.authenticated().and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler()).and().cors();
	}

}
