package pdev.spring;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@SpringBootApplication
@ComponentScan(basePackages ="pdev.spring.Config" )
@ComponentScan(basePackages ="pdev.spring.controller" )
@ComponentScan(basePackages ="pdev.spring.entity" )

public class Application {
    
	public static void main(String[] args) {	
		SpringApplication.run(Application.class, args);	
	}
	@Bean
	public CorsFilter corsfilter() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	    configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
	    configuration.setAllowCredentials(true);
	    configuration.setAllowedHeaders(Arrays.asList(
	            "Accept", "Origin", "Content-Type", "Depth", "User-Agent", "If-Modified-Since,",
	            "Cache-Control", "Authorization", "X-Req", "X-File-Size", "X-Requested-With", "X-File-Name"));
	    configuration.addAllowedHeader("Access-Control-Request-Method");
        configuration.addAllowedHeader("Access-Control-Request-Headers");
        configuration.addAllowedHeader("Access-Control-Allow-Headers");
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return new CorsFilter(source);
	}

}
