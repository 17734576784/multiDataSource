/**   
* @Title: Ds1CommonMapper.java 
* @Package com.nb.mapper 
* @Description: TODO(用一句话描述该文件做什么) 
* @author dbr
* @date 2019年4月10日 下午4:10:12 
* @version V1.0   
*/
package com.ke.ds2.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/** 
* @ClassName: CommonMapper 
* @Description: 公共数据库操作类
* @author dbr
* @date 2019年4月10日 下午4:10:12 
*  
*/
@Mapper
public interface CommonMapper {
	
	/** 
	* @Title: getNbInfoByDeviceId 
	* @Description: 根据设备编号获取水表rtuId mpId
	* @param @param deviceId
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	*/
	Map<String, Object> getLastRtu();

}
