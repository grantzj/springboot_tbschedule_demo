package com.zto.demo.schedule.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import com.zto.demo.schedule.model.TaskModel;


@Component("syncABean")
public class DataSyncABean implements IScheduleTaskDealSingle<TaskModel>{
	
	private static final Logger LOG = Logger.getLogger(DataSyncABean.class);

	@Override
	public Comparator<TaskModel> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskModel> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
			List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
	    LOG.info("IScheduleTaskDealSingleTest配置的参数，taskParameter:"+taskParameter
			+",ownSign:"+ownSign
			+",taskQueueNum:"+taskQueueNum
			+",taskItemList:"+taskItemList
			+", eachFetchDataNum:"+eachFetchDataNum
	    	);  
	    LOG.info("");
	    List<TaskModel> modelList = new ArrayList<TaskModel>();
	    modelList.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "test1"));
	    modelList.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "test2"));

		return modelList;
	}

	@Override
	public boolean execute(TaskModel model, String ownSign) throws Exception {
		System.out.println(model.getJob()+" ************************ "+model.getName());
		return true;
	}

}
