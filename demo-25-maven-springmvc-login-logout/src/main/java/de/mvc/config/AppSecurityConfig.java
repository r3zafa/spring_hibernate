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
        UserDetails theManager = User.withUsername("frobese").password("{noop}frobese").roles("USER", "MANAGER").build();
        UserDetails theAdmin = User.withUsername("admin").password("{noop}admin").roles("USER","ADMIN").build();

        return new InMemoryUserDetailsManager(theAdmin,theManager,theUser);

    }
	
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(authorize -> authorize
					.antMatchers("/resources/**").permitAll()
					.antMatchers("/profile/**").hasRole("USER")
					.antMatchers("/system/**").hasRole("ADMIN")
					.antMatchers("/management/**").hasAnyRole("ADMIN","MANAGER")
					.anyRequest()
					.authenticated()
					)
   
			.formLogin(form -> form
					.loginPage("/login")
					.loginProcessingUrl("/authenticateLogin") // send login form information to this root for validation
					.permitAll()
					)
			
			.logout(logout -> logout                                                
		            .logoutUrl("/myLogout")                                            
		            .logoutSuccessUrl("/login?logout")                                      
		            .invalidateHttpSession(true)
		            .deleteCookies("JSESSIONID")
		            .permitAll()
				);
			

		
		return http.build();
     
    }
	



	
}












