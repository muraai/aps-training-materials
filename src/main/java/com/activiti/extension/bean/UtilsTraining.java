package com.activiti.extension.bean;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
@PropertySource(value = "classpath:alfresco_training.properties", ignoreResourceNotFound = true)
@Component("utilsTraining")
public class UtilsTraining {
	@Autowired 
	Environment evn;
	 public HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory()
	    {
	        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory= new HttpComponentsClientHttpRequestFactory();
	        clientHttpRequestFactory.setHttpClient(httpClient());
	        return clientHttpRequestFactory;
	    }
	     
	    public HttpClient httpClient()
	    {
	        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
	        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(evn.getProperty("apsUserName"), evn.getProperty("apsPassword")));
	        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();
	        return client;
	    }
}
