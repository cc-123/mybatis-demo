package com.cc.mybatisdemo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(name = "spring.datasource.dbcp2.url", matchIfMissing = false)
@MapperScan(value = {"com.cc.mybatisdemo.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class BaseDataSourceConfiguration {

    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.datasource.dbcp2")
    public DataSource dataSource() {
        return new BasicDataSource();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManger(@Qualifier("datasource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/base/**/*Mapper.xml"));
        return sessionFactory.getObject();
    }
}
