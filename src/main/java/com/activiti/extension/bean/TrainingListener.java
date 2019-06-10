package com.activiti.extension.bean;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.activiti.engine.runtime.Execution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("TrainingListener")
public class TrainingListener implements ActivitiEventListener {
	
	@Autowired
    private RuntimeService runtimeService;
	
	private static final Logger log = LoggerFactory.getLogger(TrainingListener.class);
	@Override
	public void onEvent(ActivitiEvent event) {
		try {
			log.info("EVENT TYPE ENTRY "+event.getType());
			if (event.getType().equals(ActivitiEventType.TASK_COMPLETED)) {
				DelegateTask task = (DelegateTask) ((ActivitiEntityEvent) event).getEntity();
				
	        	 switch(task.getTaskDefinitionKey().toLowerCase())
					{
					case "develop_book_concept":
			        	 try {
			        		 List<Execution> execs1=runtimeService.createExecutionQuery().messageEventSubscriptionName("conceptReady").processInstanceId(event.getProcessInstanceId()).list();
			        		 for (Execution ex : execs1) {
					               try {
					            	   if(event.getProcessInstanceId().equalsIgnoreCase(ex.getProcessInstanceId())) {
					               runtimeService.messageEventReceived("conceptReady", ex.getId());
					            	   }
					               } catch (Exception e) {
					                    System.out.println(e.getMessage());
					               }
					          }
			        	 }catch(Exception e) {e.printStackTrace();}
						break;
						
					case "boundary_signal_event_example":
						try {
							 List<Execution> exlist=runtimeService.createExecutionQuery().signalEventSubscriptionName("signaltest").processInstanceId(event.getProcessInstanceId()).list();
							 for (Execution ex : exlist) {
					               try {
					            	   if(event.getProcessInstanceId().equalsIgnoreCase(ex.getProcessInstanceId())) {
					               runtimeService.signalEventReceived("signaltest", ex.getId());
					            	   }
					               } catch (Exception e) {
					                    System.out.println(e.getMessage());
					               }
					          }
						}catch (Exception e) {
						
						e.printStackTrace();
						}
						break;
						
					case "boundary_message_event_example":
						try {
							 List<Execution> exlist=runtimeService.createExecutionQuery().messageEventSubscriptionName("messageTrigger").processInstanceId(event.getProcessInstanceId()).list();
							 for (Execution ex : exlist) {
					               try {
					            	   if(event.getProcessInstanceId().equalsIgnoreCase(ex.getProcessInstanceId())) {
					               runtimeService.messageEventReceived("messageTrigger", ex.getId());
					            	   }
					               } catch (Exception e) {
					                    System.out.println(e.getMessage());
					               }
					          }
						}catch (Exception e) {
						
						e.printStackTrace();
						}
						break;
					}
			}
		}
		catch (Exception e) {
			log.error("Error Message " + e.getMessage(), e);
			log.error("Unable to  the process " + event.getProcessInstanceId() + " For the event "+ event.getType());
		}
	}

	@Override
	public boolean isFailOnException() {
		// TODO Auto-generated method stub
		return false;
	}
}
