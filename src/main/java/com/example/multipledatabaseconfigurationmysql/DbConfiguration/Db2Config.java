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
        entityManagerFactoryRef = "entityManagerFactoryBean2",
        transactionManagerRef = "transactionManager2",
        basePackages = {"com.example.multipledatabaseconfigurationmysql.repository.repo2"}
)
public class Db2Config {

    @Autowired
    Environment env;


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource2(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource2.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource2.url"));
        dataSource.setUsername(env.getProperty("spring.datasource2.username"));
        dataSource.setPassword(env.getProperty("spring.datasource2.password"));
        return dataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean2(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource2());
        entityManagerFactoryBean.setPackagesToScan(new String[]{"com.example.multipledatabaseconfigurationmysql.model"});
        entityManagerFactoryBean.setPersistenceUnitName("datasource2");

        HashMap<String,Object> map=new HashMap<>();

        HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        map.put("hibernate.dialect",env.getProperty("spring.jpa.properties.hibernate.dialect.2"));
        map.put("hibernate.show_sql",env.getProperty("spring.jpa.show_sql.2"));

        entityManagerFactoryBean.setJpaPropertyMap(map);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }


    @Bean
    public PlatformTransactionManager transactionManager2(){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean2().getObject());
        return transactionManager;
    }

}
