package com.vivas.migratectxh.dao.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
        entityManagerFactoryRef = "oracleEntityManagerFactory",
        basePackages = {"com.vivas.migratectxh.dao.oracle.repo"},
        transactionManagerRef = "oracleTransactionManager"
)
public class OracleConfig {

    @Value("${app.datasource.oracle.username}")
    private String username;

    @Value("${app.datasource.oracle.password}")
    private String password;

    @Value("${app.datasource.oracle.url}")
    private String url;

    @Value("${app.datasource.oracle.driver-class-name}")
    private String driverClassName;

    @Value("${app.datasource.oracle.hikari.maxPoolSize}")
    private Integer maxPoolSize;

    @Value("${app.datasource.oracle.hikari.connectionTimeout}")
    private Long connectionTimeout;

    @Value("${app.datasource.oracle.hikari.idleTimeout}")
    private Long idleTimeout;

    @Value("${app.datasource.oracle.hikari.maxLifetime}")
    private Long maxLifetime;

    @Primary
    @Bean(name= "oracleDataSource")
    public DataSource dataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setMaximumPoolSize(maxPoolSize);
        hikariConfig.setConnectionTimeout(connectionTimeout);
        hikariConfig.setIdleTimeout(idleTimeout);
        hikariConfig.setMaxLifetime(maxLifetime);

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "oracleEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.vivas.migratectxh.dao.oracle.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        //properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean("mysqlTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mysqlEntityManager().getObject());
        return transactionManager;
    }

}
