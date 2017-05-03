package com.zto.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;

@Configuration
public class TBScheduleJobConfig {
	
	/**
	 *创建好Bean之后调用TBScheduleManagerFactory的初始化方法init()来进行初始化
	 */
	@Bean(initMethod="init")
	public TBScheduleManagerFactory tbScheduleManagerFactory(
			@Value("${job.zkConfig.zkConnectString}")String zkConnectString,
			@Value("${job.zkConfig.rootPath}")String rootPath,
			@Value("${job.zkConfig.zkSessionTimeout}")String zkSessionTimeout,
			@Value("${job.zkConfig.userName}")String userName,
			@Value("${job.zkConfig.password}")String password,
			@Value("${job.zkConfig.isCheckParentPath}")String isCheckParentPath){
		TBScheduleManagerFactory tbScheduleManagerFactory = new TBScheduleManagerFactory();
		Map<String, String> zkConfig = new HashMap<String, String>();
		zkConfig.put("zkConnectString", zkConnectString);
		zkConfig.put("rootPath", rootPath);
		zkConfig.put("zkSessionTimeout", zkSessionTimeout);
		zkConfig.put("userName", userName);
		zkConfig.put("password", password);
		System.out.println("userName:"+userName+", password:"+password);
		zkConfig.put("isCheckParentPath", isCheckParentPath);
        tbScheduleManagerFactory.setZkConfig(zkConfig);  
        return tbScheduleManagerFactory;  
	}
	
	

}
