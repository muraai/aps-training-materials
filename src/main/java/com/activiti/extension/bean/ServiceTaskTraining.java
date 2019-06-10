package com.activiti.extension.bean;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\webapps\activiti-app\WEB-INF\classes\activiti\beans-whitelist.conf
@Component("serviceTaskTraining")
@PropertySource(value = "classpath:alfresco_training.properties", ignoreResourceNotFound = true)
public class ServiceTaskTraining {
	@Autowired 
	Environment evn;
	
	@Autowired 
	UtilsTraining utilsTraining;
	
	private static final Logger log = LoggerFactory.getLogger(ServiceTaskTraining.class);
//	${serviceTaskTraining.getUserMessage()} //Service task property Expression  return value is set to global variable  Result variable name property
	public String getUserMessage() {
		log.info("serviceTaskTraining   getUserMessage() Method call");
		return "Welcome";
	}
	
//	${serviceTaskTraining.getGroupDetails("3003")}
	public String getGroupDetails(String groupId)
	{
		String URL = evn.getProperty("apsHost")+"/activiti-app/api/enterprise/groups/"+groupId+"/users";
		  // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");
 
        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate(utilsTraining.getClientHttpRequestFactory());
 
        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
 
        String result = response.getBody();
 
        System.out.println(result);
		
		return result;
	}
	
}
