package com.gmail.kutilandrej.config;

import java.util.Properties;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.gmail.kutilandrej")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

  @Bean
  public DataSource dataSource() {
    ComboPooledDataSource datasource = new ComboPooledDataSource();
    try {
      datasource.setDriverClass("com.mysql.cj.jdbc.Driver");
      datasource.setJdbcUrl("jdbc:mysql://localhost:3306/db?useSSL=false");
      datasource.setUser("user");
      datasource.setPassword("M4Q5ZVBDRB2fRmNbVg6P");
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }
    return datasource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setPackagesToScan("com.gmail.kutilandrej.entity");
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    properties.setProperty("hibernate.show_sql", "true");
    sessionFactoryBean.setHibernateProperties(properties);
    return sessionFactoryBean;
  }

  @Bean
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }
}