package de.mvc.crm.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("de.mvc.crm")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class AppConfig implements WebMvcConfigurer{

	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// JDBC Data source
	@Bean
	public DataSource jdbcDataSource() {
		ComboPooledDataSource jdbcDataSource = new ComboPooledDataSource(); // create connection pool
		try { jdbcDataSource.setDriverClass(env.getProperty("jdbc.driver")); }
		catch (PropertyVetoException exc) { throw new RuntimeException(exc);}
		
		logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		// set database connection props
		jdbcDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		jdbcDataSource.setUser(env.getProperty("jdbc.user"));
		jdbcDataSource.setPassword(env.getProperty("jdbc.password"));
		// set connection pool props
		jdbcDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		jdbcDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		jdbcDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));		
		jdbcDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return jdbcDataSource;
	}
	
	
	private Properties getHibernateProperties() {
		Properties props = new Properties();// set hibernate properties
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return props;				
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();// create session factorys
		// set the properties
		sessionFactory.setDataSource(jdbcDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	// setup transaction manager based on session factory
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}	
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }	
	
	// read environment property and convert to int
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}	
	
}
