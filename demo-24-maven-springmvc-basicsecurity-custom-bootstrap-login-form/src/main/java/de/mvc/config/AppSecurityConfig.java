package de.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
		 

        UserDetails theUser = User.withUsername("Reza").password("{noop}reza").roles("USER").build();
        UserDetails theManager = User.withUsername("frobese").password("{noop}frobese").roles("MANAGER").build();
        UserDetails theAdmin = User.withUsername("admin").password("{noop}admin").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(theAdmin,theManager,theUser);

    }
	
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(authorize -> authorize
					.antMatchers("/resources/**")
					.permitAll()   
					.anyRequest()
					.authenticated()
					)
   
		     
			.formLogin(form -> form
					.loginPage("/login")
					.loginProcessingUrl("/authenticateLogin") // send login form information to this root for validation
					.permitAll()
				);
			

		
		return http.build();
     
    }
	



	
}












