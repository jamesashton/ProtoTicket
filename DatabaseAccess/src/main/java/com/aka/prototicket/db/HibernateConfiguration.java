package com.aka.prototicket.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.aka.prototicket.db.entity.Role;
import com.aka.prototicket.db.entity.User;

@Configuration
public class HibernateConfiguration {

	@Value("#{dataSource}")
	private DataSource dataSource;

	@Bean
	public AnnotationSessionFactoryBean sessionFactoryBean() {
		Properties props = new Properties();
		props.put("hibernate.dialect", MySQL5Dialect.class.getName());
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto","create");
		props.put("current_session_context_class", "thread");
		AnnotationSessionFactoryBean bean = new AnnotationSessionFactoryBean();
		bean.setAnnotatedClasses(new Class[]{User.class, Role.class});		
		bean.setHibernateProperties(props);
		bean.setDataSource(this.dataSource);
		bean.setSchemaUpdate(true); 
		return bean;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager( sessionFactoryBean().getObject() );
	}

}
