package de.mvc.crm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;// add a reference to our security data source

	@Override
	protected void configure(AuthenticationManagerBuilder jdbcAuth) throws Exception {
		jdbcAuth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/api/weather*").permitAll()
			.antMatchers("/index").permitAll()
			.antMatchers("/customer/add*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/employee/add*").hasRole("ADMIN")
			.antMatchers("/customer/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/employee/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/**/delete*").hasRole("ADMIN")
			.antMatchers("/**/update*").hasRole("ADMIN")
			.antMatchers("/**/list*").hasRole("EMPLOYEE")
			.antMatchers("/resources/**").permitAll()
			
			.and()
			
			.formLogin()
			.loginPage("/loginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			
			.and()
			
			.logout().logoutUrl("/myLogout")
			.logoutSuccessUrl("/?logout")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.permitAll()
			
			.and()
			
			.exceptionHandling().accessDeniedPage("/access-denied");
	}

	
	

	@Bean
	public UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		return jdbcUserDetailsManager;
	}
	

}
