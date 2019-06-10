package com.activiti.extension.conf;

import java.util.Arrays;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.context.annotation.Bean;

import com.activiti.extension.bean.UtilsTraining;

//com.activiti.extension.bean.MyJavaDelegate service task property class response value is setvaribale required.
//@PropertySource(value = "classpath:alfresco_training.properties", ignoreResourceNotFound = true)
//com.activiti.extension.bean.MyJavaDelegate
//com.activiti.extension.conf.MyJavaDelegate
//@Configurable
//@Bean
public class MyJavaDelegate implements JavaDelegate {
	
	//@Autowired not working this file.
	
	/*public MyJavaDelegate() {
		// TODO Auto-generated constructor stub
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}*/
	private static Logger logger = LoggerFactory.getLogger(MyJavaDelegate.class);
	
	 
	 
	/*@Autowired
	Environment evn;
	
	@Autowired 
	UtilsTraining utilsTraining;*/

	
	//https://community.alfresco.com/community/bpm/blog/2016/11/15/activiti-enterprise-developer-series-service-tasks-java-delegates
	
//	more
//	https://alfresco-ext.jiveon.com/community/bpm/blog/2016/11
	/*@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Dharumaiyan G  Hello com.activiti.extension.bean.MyJavaDelegate from the class delegate");
		
		 logger.info("Dharumaiyan G [Process=" + execution.getProcessInstanceId() +
                 "][Java Delegate=" + this + "]"); 
		 
        execution.setVariable("message", "Hello from the class delegate");
        
        String initiator = (String)execution.getVariable("initiator");
        execution.setVariable("greeting", "Hello World!");
        execution.setVariableLocal("greetingLocal", "Hello World Local!");

        logger.info("Initiator of the process has user ID = " + initiator);
        
        logger.info("--- Process variables:");
        Map<String, Object> procVars = execution.getVariables();
        for (Map.Entry<String, Object> procVar : procVars.entrySet()) {
          logger.info("   [" + procVar.getKey() + " = " + procVar.getValue() + "]");
        }*/
        @Override
        public void execute(DelegateExecution execution) throws Exception {
        	System.out.println("Dharumaiyan G  Hello com.activiti.extension.bean.MyJavaDelegate from the class delegate");
        	
        	 /*RuntimeService runtimeService = execution.getEngineServices().getRuntimeService();
        	 runtimeService.startProcessInstanceByMessage("");*/
        	
        	logger.info("--- Process variables:");
        	Map<String, Object> procVars = execution.getVariables();
        	for (Map.Entry<String, Object> procVar : procVars.entrySet()) {
        		logger.info("   [" + procVar.getKey() + " = " + procVar.getValue() + "]");
        	}
//        	execution.
        	
        	
        	logger.info("Dharumaiyan G [Process=" + execution.getProcessInstanceId() +
        			"][Java Delegate=" + this + "]"); 
        	String groupId = execution.getVariable("groupId")+"";
        	System.out.println("groupId===>"+groupId);
        	/*System.out.println("evn===>"+evn);
        	System.out.println("utilsTraining===>"+utilsTraining);*/
        	
//        	System.out.println("evn.getProperty(apsHost)==>"+evn.getProperty("apsHost"));
        	String URL = "http://localhost:8080/activiti-app/api/enterprise/groups/"+groupId+"/users";
        	System.out.println("URL==>"+URL);
  		  // HttpHeaders
          HttpHeaders headers = new HttpHeaders();
   
          headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
          // Request to return JSON format
          headers.setContentType(MediaType.APPLICATION_JSON);
          headers.set("my_other_key", "my_other_value");
   
          // HttpEntity<String>: To get result as String.
          HttpEntity<String> entity = new HttpEntity<String>(headers);
   
          // RestTemplate
          RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
   
          // Send request with GET method, and Headers.
          ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
   
          String result = response.getBody();

          
        	execution.setVariable("message", "Service Task Response");
        	execution.setVariable("groupDetails", result);
        	
//        	String initiator = (String)execution.getVariable("initiator");

	}
        public HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory()
	    {
	        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory= new HttpComponentsClientHttpRequestFactory();
	        clientHttpRequestFactory.setHttpClient(httpClient());
	        return clientHttpRequestFactory;
	    }
	     
	    public HttpClient httpClient()
	    {
	        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
	        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("admin@app.activiti.com", "admin"));
	        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();
	        return client;
	    }

}
