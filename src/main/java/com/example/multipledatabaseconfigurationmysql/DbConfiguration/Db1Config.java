package com.example.multipledatabaseconfigurationmysql.DbConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySources({@PropertySource("classpath:application.properties")})
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory1",
        transactionManagerRef = "transactionManager1",
        basePackages = {"com.example.multipledatabaseconfigurationmysql.repository.repo1"}
)
public class Db1Config {

    @Autowired
    Environment env;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasouce1")
    public DataSource dataSource1() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource1.driver-class-name"));
        dataSource.setUsername(env.getProperty("spring.datasource1.username"));
        dataSource.setPassword(env.getProperty("spring.datasource1.password"));
        dataSource.setUrl(env.getProperty("spring.datasource1.url"));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource1());

        entityManagerFactoryBean.setPackagesToScan(new String[]{"com.example.multipledatabaseconfigurationmysql.model"});
        entityManagerFactoryBean.setPersistenceUnitName("datasource1");

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        HashMap<String, Object> map = new HashMap<>();

        map.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.1"));
        map.put("hibernate.show_sql", env.getProperty("spring.jpa.show_sql.1"));

        entityManagerFactoryBean.setJpaPropertyMap(map);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager1() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory1().getObject());
        return transactionManager;
    }

}
