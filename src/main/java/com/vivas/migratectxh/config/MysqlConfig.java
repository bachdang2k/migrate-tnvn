package com.vivas.migratectxh.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
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
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        basePackages = {"com.vivas.migratectxh.repository.mysql"},
        transactionManagerRef = "mysqlTransactionManager"
)
@RequiredArgsConstructor
public class MysqlConfig {

    public final Environment env;

    @Primary
    @Bean(name= "mysqlDataSource")
    public DataSource dataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(env.getProperty("app.datasource.mysql.username"));
        hikariConfig.setPassword(env.getProperty("app.datasource.mysql.password"));
        hikariConfig.setJdbcUrl(env.getProperty("app.datasource.mysql.url"));
        hikariConfig.setDriverClassName(Objects.requireNonNull(env.getProperty("app.datasource.mysql.driver-class-name")));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(Objects.requireNonNull(env.getProperty("app.datasource.mysql.hikari.maxPoolSize"))));
        hikariConfig.setConnectionTimeout(Long.parseLong(Objects.requireNonNull(env.getProperty("app.datasource.mysql.hikari.connectionTimeout"))));
        hikariConfig.setIdleTimeout(Long.parseLong(Objects.requireNonNull(env.getProperty("app.datasource.mysql.hikari.idleTimeout"))));
        hikariConfig.setMaxLifetime(Long.parseLong(Objects.requireNonNull(env.getProperty("app.datasource.mysql.hikari.maxLifetime"))));

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "mysqlEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.vivas.migratectxh.entity.mysql");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hibernate.show.sql", "true");
        properties.put("hibernate.hibernate.format_sql", "true");
        em.setJpaPropertyMap(properties);
        return em;
    }


    @Bean("oracleTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(
            @Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManager) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mysqlEntityManager.getObject());
        return transactionManager;
    }

}
