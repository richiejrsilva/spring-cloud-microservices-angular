package org.wipo.hague.auth;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * This class configures manually the Spring repositories and a h2 datasource to be used in tests
 * without having to initialize the whole Spring Boot context. It allows us to remove all the
 * convoluted code in TestUtils used to mock Spring repositories and mimic database contents.
 *
 */
@TestConfiguration
@EnableJpaRepositories(basePackages = "org.wipo.hague.auth.db")
@PropertySource("h2-test-datasource.properties")
public class AuthTestsJpaConfiguration {

  @Autowired
  private Environment environment;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
    dataSource.setUrl(environment.getProperty("jdbc.url"));
    dataSource.setUsername(environment.getProperty("jdbc.user"));

    return dataSource;
  }

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    // jpaVendorAdapter.setGenerateDdl(true);
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(jpaVendorAdapter);

    factory.setPackagesToScan("org.wipo.hague.auth.db.model");
    factory.setDataSource(dataSource());

    // Spring Boot is not in control of the database configuration anymore, I have to do it here
    // manually. Probably there are more elegant ways of achieving this(@DataJpaTest?
    // @AutoConfigureTestDatabase?) but I don't want to invest more time and this
    // gets me what I want: a database properly configured without having to start an embedded
    // Tomcat and a full Spring Boot context.
    // This is the first way I got it working and this is the way is going to stay for the moment...
    Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
    jpaProperties.setProperty("hibernate.hbm2ddl.import_files", "mock_data.sql");
    jpaProperties.setProperty("hibernate.hbm2ddl.import_files_sql_extractor",
        "org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor");
    jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    jpaProperties.setProperty("hibernate.show_sql", "true");
    factory.setJpaProperties(jpaProperties);

    factory.afterPropertiesSet();

    return factory.getObject();
  }

}
