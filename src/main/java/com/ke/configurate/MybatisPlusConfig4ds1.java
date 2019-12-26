/**   
* @Title: MybatisPlusConfig4ds1.java 
* @Package com.ke.configurate 
* @Description: TODO(用一句话描述该文件做什么) 
* @author dbr
* @date 2019年12月26日 上午9:01:27 
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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

/** 
* @ClassName: MybatisPlusConfig4ds1 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author dbr
* @date 2019年12月26日 上午9:01:27 
*  
*/
/**
 * Mybatis主数据源ds1配置 多数据源配置依赖数据源配置
 * 
 * @see DataSourceConfig
 */
@Configuration
@MapperScan(basePackages = "com.ke.ds1.mapper.**", sqlSessionTemplateRef = "ds1SqlSessionTemplate")
public class MybatisPlusConfig4ds1 {

	// 主数据源 ds1数据源
	@Primary
	@Bean("ds1SqlSessionFactory")
	public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("ds1DataSource") DataSource dataSource) throws Exception {
		MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:com/ke/ds1/mapper/**/*.xml"));
		return sqlSessionFactory.getObject();
	}

	@Primary
	@Bean(name = "ds1TransactionManager")
	public DataSourceTransactionManager ds1TransactionManager(@Qualifier("ds1DataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Primary
	@Bean(name = "ds1SqlSessionTemplate")
	public SqlSessionTemplate ds1SqlSessionTemplate(
			@Qualifier("ds1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
