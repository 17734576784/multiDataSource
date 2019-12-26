/**   
* @Title: MybatisPlusConfig4ds2.java 
* @Package com.ke.configurate 
* @Description: TODO(用一句话描述该文件做什么) 
* @author dbr
* @date 2019年12月26日 上午9:12:40 
* @version V1.0   
*/
package com.ke.configurate;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

/**
 * Mybatis 第二个ds2数据源配置 多数据源配置依赖数据源配置
 * 
 * @see DataSourceConfig
 */
@Configuration
@MapperScan(basePackages = "com.ke.ds2.mapper.**", sqlSessionTemplateRef = "ds2SqlSessionTemplate")
public class MybatisPlusConfig4ds2 {

	// ds2数据源
	@Bean("ds2SqlSessionFactory")
	public SqlSessionFactory ds2SqlSessionFactory(@Qualifier("ds2DataSource") DataSource dataSource) throws Exception {
		MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:com/ke/ds2/mapper/**/*.xml"));
		return sqlSessionFactory.getObject();
	}

//事务支持
	@Bean(name = "ds2TransactionManager")
	public DataSourceTransactionManager ds2TransactionManager(@Qualifier("ds2DataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "ds2SqlSessionTemplate")
	public SqlSessionTemplate ds2SqlSessionTemplate(
			@Qualifier("ds2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}