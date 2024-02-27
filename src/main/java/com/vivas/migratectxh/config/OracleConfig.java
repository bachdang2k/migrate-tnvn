package com.vivas.migratectxh.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
        entityManagerFactoryRef = "oracleEntityManagerFactory",
        basePackages = {"com.vivas.migratectxh.repository.oracle"},
        transactionManagerRef = "oracleTransactionManager"
)
@RequiredArgsConstructor
public class OracleConfig {

    public final Environment env;

    @Primary
    @Bean(name= "oracleDataSource")
    public DataSource dataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(env.getProperty("app.datasource.oracle.username"));
        hikariConfig.setPassword(env.getProperty("app.datasource.oracle.password"));
        hikariConfig.setJdbcUrl(env.getProperty("app.datasource.oracle.url"));
        hikariConfig.setDriverClassName(Objects.requireNonNull(env.getProperty("app.datasource.oracle.driver-class-name")));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(Objects.requireNonNull(env.getProperty("app.datasource.oracle.hikari.maxPoolSize"))));
        hikariConfig.setConnectionTimeout(Long.parseLong(Objects.requireNonNull(env.getProperty("app.datasource.oracle.hikari.connectionTimeout"))));
        hikariConfig.setIdleTimeout(Long.parseLong(Objects.requireNonNull(env.getProperty("app.datasource.oracle.hikari.idleTimeout"))));
        hikariConfig.setMaxLifetime(Long.parseLong(Objects.requireNonNull(env.getProperty("app.datasource.oracle.hikari.maxLifetime"))));

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "oracleEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.vivas.migratectxh.entity.oracle");

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
