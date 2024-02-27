package com.vivas.migratectxh.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
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
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        basePackages = {"com.vivas.migratectxh.repository.mysql"},
        transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlConfig {

    @Value("${app.datasource.mysql.username}")
    private String username;

    @Value("${app.datasource.mysql.password}")
    private String password;

    @Value("${app.datasource.mysql.url}")
    private String url;

    @Value("${app.datasource.mysql.driver-class-name}")
    private String driverClassName;

    @Value("${app.datasource.mysql.hikari.maxPoolSize}")
    private Integer maxPoolSize;

    @Value("${app.datasource.mysql.hikari.connectionTimeout}")
    private Long connectionTimeout;

    @Value("${app.datasource.mysql.hikari.idleTimeout}")
    private Long idleTimeout;

    @Value("${app.datasource.mysql.hikari.maxLifetime}")
    private Long maxLifetime;

    @Primary
    @Bean(name= "mysqlDataSource")
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
