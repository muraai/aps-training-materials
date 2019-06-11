# aps-training-materials
The documentation and files for APS 1.x training
**APS Training**

**Start Events**

**      ** Start events define where a Process or Sub Process starts.

The process engine supports different types of start events:

1. None Start Event or Start Event

2. Start Timer Event

3. Start Signal Event

4. Start Message Event

5. Start Error Event

The engine requires at least one start event to instantiate a process. There can be a maximum of one blank or timer start event per process definition. 

There can be multiple message or signal start events.

**1.None start event or Start Events**

A start event with an unspecified trigger. 

Undefined trigger to start of process or Entry point to a Sub Process. 

It is visualized as a circle with no icon.

![image alt text](image_0.png)

A none start event can have a start form. If so, the start form will be displayed when selecting the process definition from the processes list. Note that a process instance is not started until the start form is submitted. A none start event without a form will simply have a button displayed to start the process instance.

![image alt text](image_1.png)

<table>
  <tr>
    <td>S.no</td>
    <td>Property</td>
    <td>Description</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Id</td>
    <td>A unique identifier for this element.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Name</td>
    <td>A name for this element.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Documentation</td>
    <td>A description of this element.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Execution listeners</td>
    <td>Execution listeners configured for this element instance. An execution listener is a piece of logic that is not shown in the diagram and can be used for technical purposes.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>Process Initiator</td>
    <td>The process variable in which the user ID of the initiator of this instance should be stored.</td>
  </tr>
  <tr>
    <td>6</td>
    <td>Form key</td>
    <td>A key that provides a reference to a form. This property is available for compatibility with Activiti , but should not be used directly when using Forms. Use the Referenced form property instead.</td>
  </tr>
  <tr>
    <td>7</td>
    <td>Referenced form</td>
    <td>A form reference.</td>
  </tr>
  <tr>
    <td>8</td>
    <td>Form properties</td>
    <td>A form definition with a list of form properties. Form properties are the way forms are defined in the community version of Alfresco Process Services. Configuring them has no impact on the rendered form in the Alfresco Process 
Services, the Referenced form property should be used instead.</td>
  </tr>
</table>


**Example**

![image alt text](image_2.png)

In this BPMN diagram example, the process shows that we first get our eggs, then scramble them and eat them for breakfast. We don’t indicate why the process was started. It could be because we were hungry, because we’re on a dietary schedule, or because our mom told us we had to eat our breakfast. We don’t know, or care. Trying to figure out what triggers the egg scrambling process doesn’t help us understand the process any better – so we use the none start event.

**2. Start Timer Event**

A timer start event initiates a process instance at specific time. You can use it both for processes which must start only once and for processes that must start in repeated time intervals.

It is visualized as a circle with a clock icon

![image alt text](image_3.png)

Note that a process instance started by a timer start event can’t have a start form, as it is started by the system. Similarly, it does not have a process initiator like a none start event. As such when assigning tasks later on in the process definition, keep in **mind that the assignment 'assigned to process initiator'** **will not work**.

**A subprocess can’t have a timer start event.**

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Description</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Id</td>
    <td>A unique identifier for this instance.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Name</td>
    <td>A name for this element.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Documentation</td>
    <td>A description of this element.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Execution listeners</td>
    <td>Execution listeners configured for this instance. An execution listeners is a piece of logic that is not shown in the diagram and can be used for technical purposes.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>Time Cycle</td>
    <td>A timer cycle defined in http://en.wikipedia.org/wiki/ISO_8601 format, for example: R3/PT10H.</td>
  </tr>
  <tr>
    <td>6</td>
    <td>Time Date in ISO-8601</td>
    <td>A point in time defined as a http://en.wikipedia.org/wiki/ISO_8601 date, for example: 2015-04-12T20:20:32Z.</td>
  </tr>
  <tr>
    <td>7</td>
    <td>Time Duration</td>
    <td>A period of time defined as a http://en.wikipedia.org/wiki/ISO_8601duration, for example: PT5M.</td>
  </tr>
</table>


![image alt text](image_4.png)

**Example**

![image alt text](image_5.png)

The timer event is used in BPMN diagrams to indicate that the process begins at a set time or date. It can also be used for processes that repeat on a schedule (hourly, daily, etc).

In our example, on the actor’s wedding anniversary, he buys a gift, gives it to his spouse, and then enjoys their anniversary. This process is triggered by the timing of the anniversary.

**3. Start Signal Event**

A signal start event starts a process instance using a named signal. The signal is fired from a process instance using the intermediary **signal throw event (or programmatically through the java or REST API)**. In both cases, a process instance for any process definitions that have a signal start event with the same name are started. You can select a synchronous or asynchronous start of the process instances.

A signal start event is visualized as a circle with a triangle inside. The triangle is white inside.

![image alt text](image_6.png)

![image alt text](image_7.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Description</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Id</td>
    <td>A unique identifier for this element.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Name</td>
    <td>A name for this element.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Documentation</td>
    <td>A description of this element.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Execution listeners</td>
    <td>Execution listeners configured for this instance. An execution listeners is a piece of logic that is not shown in the diagram and can be used for technical purposes.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>Signal reference</td>
    <td>The name of the signal that initiates this event. Note that signal references are configured on the root level of the process instance and then linked to the signal start event via this property. To configure it, deselect any other element and click the Signal definitions property.</td>
  </tr>
</table>


**4. Start Message Event**

A message start event starts a process instance using a named message. It is mainly used for starting process instances from external systems.

It is depicted as a circle with an envelope icon inside. The envelope is white inside.

![image alt text](image_8.png)

When you deploy a process definition with one or more message start events, consider the following points:

1. The name of the message start event must be unique across the whole process definition. Alfresco Process Services will throw an exception on deployment of a process definition with two or more message start events that reference the same message or with two or more message start events that reference messages with the same name.

2. The name of the message start event must be unique across all deployed process definitions. Alfresco Process Services will throw an exception on deployment of a process definition with one or more message start events that reference a message with the same name as a message start event already deployed in a different process definition.

3. When a new version of a process definition is deployed, the message subscriptions of the previous version are canceled. This is also true for message events that are not present in the new version.

![image alt text](image_9.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Description</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Id</td>
    <td>A unique identifier for this element.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Name</td>
    <td>A name for this element.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Documentation</td>
    <td>A description of this element.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Execution listeners</td>
    <td>Execution listeners configured for this instance. An execution listener is a piece of logic that is not shown in the diagram and can be used for technical purposes.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>Message reference</td>
    <td>The name of the message that initiates this event. Note that messages are configured on the root level of the process instance and then linked to the message start event via this property. To configure it, deselect any other element and click the 'Message definitions' property.</td>
  </tr>
</table>


**Example**

![image alt text](image_10.png)

When a process is initiated by an outside actor sending us a message (telling us to start the event), we use the message start event.

This BPMN diagram example shows a process of getting water, giving it to a child, and returning to bed. The process is initiated by the receipt of a message. We become aware that the child is complaining of thirst and unable to sleep. When we receive that message, we initiate the process of getting water for the child.

**5. Start Error Event**

An error start event triggers an event Sub-Process. An error start event can’t be used for starting a process instance.

It is visualized as a circle with lightning icon inside. The icon is white inside.

![image alt text](image_11.png)

![image alt text](image_12.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Description</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Id</td>
    <td>A unique identifier for this element.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Name</td>
    <td>A name for this element.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Documentation</td>
    <td>A description of this element.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Execution listeners</td>
    <td>Execution listeners configured for this instance. An execution listeners is a piece of logic that is not shown in the diagram and can be used for technical purposes.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>Error reference</td>
    <td>The name of the error that initiates this event. This reference needs to match the error identifier thrown by the event that throws the particular error.</td>
  </tr>
</table>


**Example**

An error start event can only be used to trigger an Event Sub-Process - it cannot be used to start a process instance. The error start event is always interrupting.

![image alt text](image_13.png)

Two optional attributes can be added to the error start event, errorRef and camunda:errorCodeVariable:

<definitions>

  <error id="myException" errorCode="com.company.MyBusinessException" name="myBusinessException"/>

  ...

  <process>

    ...

    <subprocess>

      <startEvent id="myErrorStartEvent">

        <errorEventDefinition errorRef="myException" camunda:errorCodeVariable="myErrorVariable"/>

      </startEvent>

    ...

    </subprocess>

  ...

  </process>

</definitions>

If errorRef is omitted, the subprocess will start for every error event that occurs.

The camunda:errorCodeVariable will contain the error code that was specified with the error. The value can be retrieved like any other process variable, but only if the attribute was set.

**Service Task Example**

**Required:**

1) Identity management--->Organization-->Create group and Add user that group

2)  get the group id for below image

![image alt text](image_14.png)

3) Webservice Ref. APS API given link

**[http://localhost:8080/activiti-app/api-explorer.htm**l](http://localhost:8080/activiti-app/api-explorer.html#!/groups/getUsersForGroupUsingGET)

![image alt text](image_15.png)

**Process**

![image alt text](image_16.png)

**Configured Global variables for the Process**

![image alt text](image_17.png)

**Global variables**

![image alt text](image_18.png)

**Global variable Tables**

<table>
  <tr>
    <td>S.No</td>
    <td>Variable name</td>
    <td>Variable Type</td>
  </tr>
  <tr>
    <td>1</td>
    <td>message</td>
    <td>string</td>
  </tr>
  <tr>
    <td>2</td>
    <td>groupDetails</td>
    <td>string</td>
  </tr>
  <tr>
    <td>3</td>
    <td>groupId</td>
    <td>string</td>
  </tr>
</table>


**Set initial value**

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>execution.setVariable("groupId", 3003);</td>
  </tr>
</table>


![image alt text](image_19.png)

![image alt text](image_20.png)

![image alt text](image_21.png)

![image alt text](image_22.png)

![image alt text](image_23.png)

![image alt text](image_24.png)

![image alt text](image_25.png)

**Back End Code**

**package** com.activiti.extension.conf;

 

**import** java.util.Arrays;

**import** java.util.Map;

 

**import** org.activiti.engine.delegate.DelegateExecution;

**import** org.activiti.engine.delegate.JavaDelegate;

**import** org.apache.http.auth.AuthScope;

**import** org.apache.http.auth.UsernamePasswordCredentials;

**import** org.apache.http.client.CredentialsProvider;

**import** org.apache.http.client.HttpClient;

**import** org.apache.http.impl.client.BasicCredentialsProvider;

**import** org.apache.http.impl.client.HttpClientBuilder;

**import** org.slf4j.Logger;

**import** org.slf4j.LoggerFactory;

**import** org.springframework.http.HttpEntity;

**import** org.springframework.http.HttpHeaders;

**import** org.springframework.http.HttpMethod;

**import** org.springframework.http.MediaType;

**import** org.springframework.http.ResponseEntity;

**import** org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

**import** org.springframework.web.client.RestTemplate;

 

**public** **class** MyJavaDelegate **implements** JavaDelegate {

 	

 	 	**private** **static** Logger *logger* = LoggerFactory.*getLogger*(MyJavaDelegate.**class**);

 		

       	@Override

    	**public** **void** execute(DelegateExecution execution) **throws** Exception {

    	   *logger*.info("--- Process variables:");

    	   Map<String, Object> procVars = execution.getVariables();

    	   **for** (Map.Entry<String, Object> procVar : procVars.entrySet()) {

    	    	*logger*.info("   [" + procVar.getKey() + " = " + procVar.getValue() + "]");

    	   }

    	   String groupId = execution.getVariable("groupId")+"";

    	   System.**_out_**.println("groupId===>"+groupId);

    	   String URL = "http://localhost:8080/activiti-app/api/enterprise/groups/"+groupId+"/users";

    	   System.**_out_**.println("URL==>"+URL);

 

     	// HttpHeaders

      	HttpHeaders headers = **new** HttpHeaders();

  

      	headers.setAccept(Arrays.*asList*(**new** MediaType[] { MediaType.**_APPLICATION_JSON_** }));

      	// Request to return JSON format

      	headers.setContentType(MediaType.**_APPLICATION_JSON_**);

//      	headers.set("my_other_key", "my_other_value");

  

      	// HttpEntity<String>: To get result as String.

      	HttpEntity<String> entity = **new** HttpEntity<String>(headers);

  

      	// RestTemplate

      	RestTemplate restTemplate = **new** RestTemplate(getClientHttpRequestFactory());

  

      	// Send request with GET method, and Headers.

      	ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.**_GET_**, entity, String.**class**);

       	String result = response.getBody();

    	  

       	execution.setVariable("message", "Service Task Response");

 

    	   execution.setVariable("groupDetails", result);

 	}

    	**public** HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory()

 		{

 	        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory= **new** HttpComponentsClientHttpRequestFactory();

 	        clientHttpRequestFactory.setHttpClient(httpClient());

 	        **return** clientHttpRequestFactory;

 		}

 	 	

 		**public** HttpClient httpClient()

 		{

 	        CredentialsProvider credentialsProvider = **new** BasicCredentialsProvider();

 	        credentialsProvider.setCredentials(AuthScope.**_ANY_**, **new** UsernamePasswordCredentials("admin@app.activiti.com", "admin"));

 	        HttpClient client = HttpClientBuilder.*create*().setDefaultCredentialsProvider(credentialsProvider).build();

 	        **return** client;

 		}

 

}

 

**Make the above java code to jar file  and put on the folder path**

**C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\webapps\activiti-app\WEB-INF\lib**

![image alt text](image_26.png)

**Output**

![image alt text](image_27.png)

**User And Email  And Script Task Examples**

**Change the following properties in both file**

**File location are given bellow**

1. **C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\lib\activiti-app.properties**

2. **C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\webapps\activiti-app\WEB-INF\classes\META-INF\activiti-app\activiti-app.properties**

**#Email Task**

email.enabled=true

email.host=smtp.gmail.com

email.port=587

email.tls=true

email.useCredentials=true

email.username=trainee_muraai@muraai.com

email.password=Welcome123

# The base url that will be used to create urls in emails.

email.base.url=http://localhost:8080/activiti-app

email.from.default=no-reply@alfresco.com

email.from.default.name=Alfresco Process Services

email.feedback.default=activiti@alfresco.com

**#Script Task**

validator.editor.bpmn.disable.executionlistener=false

validator.editor.bpmn.disable.cameltask=false

validator.editor.bpmn.disable.muletask=false

validator.editor.bpmn.disable.mailtask=false

**validator.editor.bpmn.disable.scripttask=false**

**validator.editor.bpmn.disable.scripttask.groovy=false**

validator.editor.bpmn.disable.manualtask=false

validator.editor.bpmn.disable.businessruletask=false

validator.editor.bpmn.disable.servicetask=false

validator.editor.bpmn.disable.intermediatethrowevent=false

validator.editor.bpmn.disable.startevent.timer=false

validator.editor.bpmn.disable.startevent.signal=false

validator.editor.bpmn.disable.startevent.message=false

validator.editor.bpmn.disable.startevent.error=false

validator.editor.bpmn.disable.startevent.timecycle=false

validator.editor.bpmn.disable.loopback=false

validator.editor.bpmn.limit.servicetask.only-class=false

validator.editor.bpmn.limit.multiinstance.loop=false

validator.editor.bpmn.limit.usertask.assignment.only-idm=false

editor.form.javascript.disable=false

javascript.secure-scripting.enabled=false

## only classes in activiti/javascript-whitelist-classes.conf will be allowed

**javascript.secure-scripting.enable-class-whitelisting=true**

## max stack depth to avoid stackoverflow exceptions 

javascript.secure-scripting.max-stack-depth=100

## max execution time in milliseconds

javascript.secure-scripting.max-execution-time=3000

## max memory in bytes (eg. 5242880 = 5MB) 

javascript.secure-scripting.max-memory=5242880

## number instructions to execute before checking max memory & max execution time 

javascript.secure-scripting.instructions-before-callback=100

**Change the configuration for this file**

**C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\webapps\activiti-app\WEB-INF\classes\activiti\whitelisted-scripts.conf**

#Here you can specify which script types are allowed to be executed

javascript

js

ecmascript

groovy

juel

**Create Process and change the property for Variable**

![image alt text](image_28.png)

![image alt text](image_29.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Variable name</td>
    <td>Variable Type</td>
  </tr>
  <tr>
    <td>1</td>
    <td>mailbody</td>
    <td>string</td>
  </tr>
  <tr>
    <td>2</td>
    <td>subject</td>
    <td>string</td>
  </tr>
  <tr>
    <td>3</td>
    <td>emailid</td>
    <td>string</td>
  </tr>
</table>


![image alt text](image_30.png)

**Forms**

![image alt text](image_31.png)

**Mapping the Variable**

![image alt text](image_32.png)

![image alt text](image_33.png)

**Change the property for **

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script Format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>execution.setVariable("emailid", 'malaivasan.d@muraai.com');</td>
  </tr>
</table>


![image alt text](image_34.png)

**Change the To Property:**

![image alt text](image_35.png)

**Change the Subject Property:**

![image alt text](image_36.png)

**Change the Text Property:**

![image alt text](image_37.png)

**Output**

![image alt text](image_38.png)

![image alt text](image_39.png)

**Rest call Task Examples**

**Configure Endpoints **

** **Go to Identity management -->Tenants-->Endpoints

![image alt text](image_40.png)

![image alt text](image_41.png)

![image alt text](image_42.png)

**Create Process and property variable**

![image alt text](image_43.png)

![image alt text](image_44.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Variable name</td>
    <td>Variable type</td>
  </tr>
  <tr>
    <td>1</td>
    <td>groupId</td>
    <td>string</td>
  </tr>
  <tr>
    <td>2</td>
    <td>message</td>
    <td>string</td>
  </tr>
  <tr>
    <td>3</td>
    <td>groupDetails</td>
    <td>string</td>
  </tr>
</table>


**Set initial value**

![image alt text](image_45.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>execution.setVariable("groupId", 3003);
execution.setVariable("message", 'Welcome');
</td>
  </tr>
</table>


**Call Service**

![image alt text](image_46.png)

**Change the property for Endpoint:**

![image alt text](image_47.png)

**Change the property for Response mapping**

![image alt text](image_48.png)

**Display  Result**

** **

![image alt text](image_49.png)

**Display Group Details Form**

![image alt text](image_50.png)

![image alt text](image_51.png)

![image alt text](image_52.png)

**Ref. more Rest API**

**[http://localhost:8080/activiti-app/api-explorer.html**#](http://localhost:8080/activiti-app/api-explorer.html#)

![image alt text](image_53.png)

**Output**

![image alt text](image_54.png)

**Decision Table Task Example**

**Required to change property**

Change the following properties in both file

File location are given bellow

3. C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\lib\activiti-app.properties

4. C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\webapps\activiti-app\WEB-INF\classes\META-INF\activiti-app\activiti-app.properties

**validator.editor.dmn.expression=true**

**Create Process And Add the property for variables**

![image alt text](image_55.png)

![image alt text](image_56.png)

**Variables Property **

<table>
  <tr>
    <td>S.No</td>
    <td>Variable name</td>
    <td>Variable type</td>
  </tr>
  <tr>
    <td>1</td>
    <td>total</td>
    <td>integer</td>
  </tr>
  <tr>
    <td>2</td>
    <td>avg</td>
    <td>integer</td>
  </tr>
  <tr>
    <td>3</td>
    <td>name</td>
    <td>string</td>
  </tr>
  <tr>
    <td>4</td>
    <td>m1</td>
    <td>string</td>
  </tr>
  <tr>
    <td>5</td>
    <td>m2</td>
    <td>string</td>
  </tr>
  <tr>
    <td>6</td>
    <td>m3</td>
    <td>string</td>
  </tr>
  <tr>
    <td>7</td>
    <td>grade</td>
    <td>string</td>
  </tr>
</table>


**submit the student details**

![image alt text](image_57.png)

**Student Form**

![image alt text](image_58.png)

![image alt text](image_59.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script Format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>execution.setVariable("total", execution.getVariable("mark1")+execution.getVariable("mark2")+execution.getVariable("mark3"));
execution.setVariable("avg", execution.getVariable("total")/3);
</td>
  </tr>
</table>


![image alt text](image_60.png)

**Grade Calculation **

![image alt text](image_61.png)

![image alt text](image_62.png)

![image alt text](image_63.png)

**Add Rules**

![image alt text](image_64.png)

![image alt text](image_65.png)

**Display  Result**

![image alt text](image_66.png)

**Student Display Form**

![image alt text](image_67.png)

![image alt text](image_68.png)

**Output**

![image alt text](image_69.png)

![image alt text](image_70.png)

**More Examples Ref the link**

**[https://docs.alfresco.com/process-services1.9/topics/business_rules_decision_tables.htm**l](https://docs.alfresco.com/process-services1.9/topics/business_rules_decision_tables.html)

**Generate document task Example**

**Create Document Template and upload the document to**

**      Identity management-->Tenants-->Document templates**

![image alt text](image_71.png)

**College ID.docx**

![image alt text](image_72.png)

**Ref more Document Template related link given below**

**[https://docs.alfresco.com/process-services1.9/topics/document_templates.htm**l](https://docs.alfresco.com/process-services1.9/topics/document_templates.html)

**Create Process And Add Variables Property**

![image alt text](image_73.png)

![image alt text](image_74.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Variable name</td>
    <td>Variable type</td>
  </tr>
  <tr>
    <td>1</td>
    <td>name</td>
    <td>string</td>
  </tr>
  <tr>
    <td>2</td>
    <td>course</td>
    <td>string</td>
  </tr>
  <tr>
    <td>3</td>
    <td>rollno</td>
    <td>string</td>
  </tr>
  <tr>
    <td>4</td>
    <td>batch</td>
    <td>string</td>
  </tr>
  <tr>
    <td>5</td>
    <td>year</td>
    <td>string</td>
  </tr>
  <tr>
    <td>6</td>
    <td>email</td>
    <td>string</td>
  </tr>
  <tr>
    <td>7</td>
    <td>blood</td>
    <td>string</td>
  </tr>
  <tr>
    <td>8</td>
    <td>phone</td>
    <td>string</td>
  </tr>
  <tr>
    <td>9</td>
    <td>street</td>
    <td>string</td>
  </tr>
  <tr>
    <td>10</td>
    <td>post</td>
    <td>string</td>
  </tr>
  <tr>
    <td>11</td>
    <td>talk</td>
    <td>string</td>
  </tr>
  <tr>
    <td>12</td>
    <td>dist</td>
    <td>string</td>
  </tr>
  <tr>
    <td>13</td>
    <td>pin</td>
    <td>string</td>
  </tr>
</table>


**Fill the Student  Details**

![image alt text](image_75.png)

**ID Card Data Form**

![image alt text](image_76.png)

![image alt text](image_77.png)

**Map Variables**

![image alt text](image_78.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Source process variable</td>
    <td>Form variable</td>
    <td>Target process variable</td>
  </tr>
  <tr>
    <td>1</td>
    <td></td>
    <td>name</td>
    <td>name</td>
  </tr>
  <tr>
    <td>2</td>
    <td></td>
    <td>course</td>
    <td>course</td>
  </tr>
  <tr>
    <td>3</td>
    <td></td>
    <td>rollno</td>
    <td>rollno</td>
  </tr>
  <tr>
    <td>4</td>
    <td></td>
    <td>batch</td>
    <td>batch</td>
  </tr>
  <tr>
    <td>5</td>
    <td></td>
    <td>year</td>
    <td>year</td>
  </tr>
  <tr>
    <td>6</td>
    <td></td>
    <td>email</td>
    <td>email</td>
  </tr>
  <tr>
    <td>7</td>
    <td></td>
    <td>blood</td>
    <td>blood</td>
  </tr>
  <tr>
    <td>8</td>
    <td></td>
    <td>phone</td>
    <td>phone</td>
  </tr>
  <tr>
    <td>9</td>
    <td></td>
    <td>street</td>
    <td>street</td>
  </tr>
  <tr>
    <td>10</td>
    <td></td>
    <td>post</td>
    <td>post</td>
  </tr>
  <tr>
    <td>11</td>
    <td></td>
    <td>talk</td>
    <td>talk</td>
  </tr>
  <tr>
    <td>12</td>
    <td></td>
    <td>dist</td>
    <td>dist</td>
  </tr>
  <tr>
    <td>13</td>
    <td></td>
    <td>pin</td>
    <td>pin</td>
  </tr>
</table>


**Value Initialization**

![image alt text](image_79.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>execution.setVariable("rollno","R-"+execution.getProcessInstanceId());</td>
  </tr>
</table>


**Generate pdf**

![image alt text](image_80.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Output format</td>
    <td>pdf</td>
  </tr>
  <tr>
    <td>2</td>
    <td>File Name</td>
    <td>ID Card</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Template</td>
    <td>College ID.docx</td>
  </tr>
</table>


**	**

**Ouput**

![image alt text](image_81.png)

![image alt text](image_82.png)

**Sub process Example**

**Create Process and Add Variables Property.**

![image alt text](image_83.png)

![image alt text](image_84.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Variables name</td>
    <td>Variable type</td>
  </tr>
  <tr>
    <td>1</td>
    <td>mailbody</td>
    <td>string</td>
  </tr>
  <tr>
    <td>2</td>
    <td>groupId</td>
    <td>integer</td>
  </tr>
  <tr>
    <td>3</td>
    <td>innerIndex</td>
    <td>integer</td>
  </tr>
  <tr>
    <td>4</td>
    <td>subject</td>
    <td>string</td>
  </tr>
</table>


**Type Mail Contentand Subject**

![image alt text](image_85.png)

**Sub Process Example Form**

![image alt text](image_86.png)

**Map Variables**

![image alt text](image_87.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Source process variable</td>
    <td>Form variable</td>
    <td>Target process variable</td>
  </tr>
  <tr>
    <td>1</td>
    <td></td>
    <td>mailbody</td>
    <td>mailbody</td>
  </tr>
  <tr>
    <td>2</td>
    <td></td>
    <td>subject</td>
    <td>subject</td>
  </tr>
</table>


**initialization variable**

![image alt text](image_88.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>execution.setVariable("groupId", 3003);
execution.setVariable("innerIndex", 0);</td>
  </tr>
</table>


**Get Group Details**

![image alt text](image_89.png)

**Change the Endpoint Property**

![image alt text](image_90.png)

**Change Property Response mapping**

![image alt text](image_91.png)

![image alt text](image_92.png)

![image alt text](image_93.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Multi-Instance type</td>
    <td>Parallel</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Cardinality (Multi-instance)</td>
    <td>${teamsize}</td>
  </tr>
</table>


**increment variable and get rest data one by one**

![image alt text](image_94.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>var i = execution.getVariable("innerIndex");
var temp = execution.getVariable("groupDetails");
var data = JSON.parse(temp);
execution.setVariable("assigneeUser", data[i].email);
i++;
execution.setVariable("innerIndex", i);
</td>
  </tr>
</table>


**Send Mail**

![image alt text](image_95.png)

**Change the To Property**

![image alt text](image_96.png)

**Change the Subject Property**

![image alt text](image_97.png)

**Change the Text Property**

![image alt text](image_98.png)

**Output**

![image alt text](image_99.png)

**Member 1**

![image alt text](image_100.png)

**Member 2**

![image alt text](image_101.png)

**Gateways Examples **

**Create Process and Add the Variable Property**![image alt text](image_102.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Variable name</td>
    <td>Variable type</td>
  </tr>
  <tr>
    <td>1</td>
    <td>name</td>
    <td>string</td>
  </tr>
  <tr>
    <td>2</td>
    <td>salary</td>
    <td>integer</td>
  </tr>
  <tr>
    <td>3</td>
    <td>experience</td>
    <td>integer</td>
  </tr>
</table>


**User Details**

![image alt text](image_103.png)

**Gateway Examples1 Form**

![image alt text](image_104.png)

**Map Variables**

![image alt text](image_105.png)

**Sequence flow**

![image alt text](image_106.png)

**Change flow condition Property**

![image alt text](image_107.png)

![image alt text](image_108.png)![image alt text](image_109.png)

![image alt text](image_110.png)

**Boundary Error Event  &  Error End Event Example**

**Create Process and Add Variables**

![image alt text](image_111.png)

**Change the Variables Property**

<table>
  <tr>
    <td>S.No</td>
    <td>Variable name</td>
    <td>Variable type</td>
  </tr>
  <tr>
    <td>1</td>
    <td>subject</td>
    <td>string</td>
  </tr>
  <tr>
    <td>2</td>
    <td>mailbody</td>
    <td>string</td>
  </tr>
  <tr>
    <td>3</td>
    <td>index</td>
    <td>string</td>
  </tr>
  <tr>
    <td>4</td>
    <td>groupId</td>
    <td>string</td>
  </tr>
  <tr>
    <td>5</td>
    <td>groupDetails</td>
    <td>string</td>
  </tr>
  <tr>
    <td>6</td>
    <td>groupSize</td>
    <td>string</td>
  </tr>
</table>


**Type Mail Contentand Subject**

![image alt text](image_112.png)

**Sub Process Examples Form**![image alt text](image_113.png)

**Map Variables **![image alt text](image_114.png)

**Initialization variable**

![image alt text](image_115.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>execution.setVariable("groupId", 3003);
execution.setVariable("index", 0);</td>
  </tr>
</table>


**Get Group details**

![image alt text](image_116.png)

**Get Loop Size**

![image alt text](image_117.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1.</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2.</td>
    <td>Script</td>
    <td>var data = JSON.parse(execution.getVariable("groupDetails"));
execution.setVariable("groupSize", data.total);</td>
  </tr>
</table>


![image alt text](image_118.png)

**Get Group Member one by one**

![image alt text](image_119.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>Value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>var i = execution.getVariable("index");
var temp = execution.getVariable("groupDetails");
var groupData = JSON.parse(temp);
execution.setVariable("assigneeUser", groupData.data[i].id);
execution.setVariable("subject", execution.getVariable("subject"));
execution.setVariable("mailbody", execution.getVariable("mailbody"));</td>
  </tr>
</table>


**Waiting  for Approval**

![image alt text](image_120.png)

**Referenced from**

![image alt text](image_121.png)

![image alt text](image_122.png)

**Loop Increment**

![image alt text](image_123.png)

<table>
  <tr>
    <td>S.No</td>
    <td>Property</td>
    <td>value</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Script format</td>
    <td>javascript</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Script</td>
    <td>var i = execution.getVariable("index");
i++;
execution.setVariable("index",i);</td>
  </tr>
</table>


![image alt text](image_124.png)

**Boundary Timer event Example**

![image alt text](image_125.png)

**Ref. More information**

**[https://docs.alfresco.com/process-services1.9/topics/boundary_timer_event.htm**l](https://docs.alfresco.com/process-services1.9/topics/boundary_timer_event.html)

**Boundary signal event Example**

**Create the process **

![image alt text](image_126.png)

**Change the Signal definitions Property**

![image alt text](image_127.png)

**Change Event listeners Property**

![image alt text](image_128.png)

![image alt text](image_129.png)

![image alt text](image_130.png)

**Back end Code**

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

 

** **

**@Component****(****"TrainingListener"****)**

public class TrainingListener implements ActivitiEventListener {

 	

 	@Autowired

	private RuntimeService runtimeService;

 	

 	private static final Logger *log* = LoggerFactory.*getLogger*(TrainingListener.class);

 	@Override

 	public void onEvent(ActivitiEvent event) {

       	try {

            	*log*.info("EVENT TYPE ENTRY "+event.getType());

            	if (event.getType().equals(ActivitiEventType.*TASK_COMPLETED*)) {

                 	DelegateTask task = (DelegateTask) ((ActivitiEntityEvent) event).getEntity();

 	            switch(task.getTaskDefinitionKey().toLowerCase())

                       	{

                       	

case "boundary_signal_event_example":

                            	

                            	try {

                                 	

                                 	 List<Execution> exlist=runtimeService.createExecutionQuery().signalEventSubscriptionName("signaltest").processInstanceId(event.getProcessInstanceId()).list();

                                 	 for (Execution ex : exlist) {

                       	           	try {

                       	        		   if(event.getProcessInstanceId().equalsIgnoreCase(ex.getProcessInstanceId())) {

                       	           	runtimeService.signalEventReceived("signaltest", ex.getId());

                       	        		   }

                       	           	} catch (Exception e) {

                       	                	System.*out*.println(e.getMessage());

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

            	*log*.error("Error Message " + e.getMessage(), e);

            	*log*.error("Unable to  the process " + event.getProcessInstanceId() + " For the event "+ event.getType());

       	}

       	

 	}

 

 	@Override

 	public boolean isFailOnException() {

       	// TODO Auto-generated method stub

       	return false;

 	}

}

** **

**Make the above java code to jar file  and put on the folder path**

**C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\webapps\activiti-app\WEB-INF\lib**

![image alt text](image_131.png)

**Boundary message event  Example**

**Create Process**

![image alt text](image_132.png)

**Change Event listeners Property**

![image alt text](image_133.png)

**Change the Message definitions Property**

![image alt text](image_134.png)

![image alt text](image_135.png)

![image alt text](image_136.png)

**Back end Code**

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

 	

 	private static final Logger *log* = LoggerFactory.*getLogger*(TrainingListener.class);

 	@Override

 	public void onEvent(ActivitiEvent event) {

       	try {

            	*log*.info("EVENT TYPE ENTRY "+event.getType());

            	if (event.getType().equals(ActivitiEventType.*TASK_COMPLETED*)) {

                 	DelegateTask task = (DelegateTask) ((ActivitiEntityEvent) event).getEntity();

 	    	    switch(task.getTaskDefinitionKey().toLowerCase())

                       	{

                       	                          	

                       	case "boundary_message_event_example":

                            	

                            	try {

                                 	

                                 	 List<Execution> exlist=runtimeService.createExecutionQuery().messageEventSubscriptionName("messageTrigger").processInstanceId(event.getProcessInstanceId()).list();

                                 	 for (Execution ex : exlist) {

                       	           	try {

                       	        		   if(event.getProcessInstanceId().equalsIgnoreCase(ex.getProcessInstanceId())) {

                       	           	runtimeService.messageEventReceived("messageTrigger", ex.getId());

                       	        		   }

                       	           	} catch (Exception e) {

                       	                	System.*out*.println(e.getMessage());

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

            	*log*.error("Error Message " + e.getMessage(), e);

            	*log*.error("Unable to  the process " + event.getProcessInstanceId() + " For the event "+ event.getType());

       	}

       	

 	}

 

 	@Override

 	public boolean isFailOnException() {

       	// TODO Auto-generated method stub

       	return false;

 	}

}

 

**Make the above java code to jar file  and put on the folder path**

**C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\webapps\activiti-app\WEB-INF\lib**

![image alt text](image_137.png)

**Intermediate signal throwing event & Intermediate signal catching event Example**

**Create Process **

![image alt text](image_138.png)

**Change the Signal definitions Property**

![image alt text](image_139.png)

**Intermediate signal throwing event**

![image alt text](image_140.png)

**Intermediate signal catching event**

![image alt text](image_141.png)

**Intermediate message catching event Example**

**Create the process**

![image alt text](image_142.png)

**Change Event listeners Property**

![image alt text](image_143.png)

**Change Message definitions Property**

![image alt text](image_144.png)

**Intermediate messages catching event**

![image alt text](image_145.png)

![image alt text](image_146.png)

**Back end code**

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

 	

 	private static final Logger *log* = LoggerFactory.*getLogger*(TrainingListener.class);

 	@Override

 	public void onEvent(ActivitiEvent event) {

       	try {

            	*log*.info("EVENT TYPE ENTRY "+event.getType());

            	if (event.getType().equals(ActivitiEventType.*TASK_COMPLETED*)) {

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

                       	                	System.*out*.println(e.getMessage());

                       	           	}

                       	      	}

            	    	    }catch(Exception e) {e.printStackTrace();}

            	    	    

                            	break;

                       	                       

                       	}

                 	

            	}

       	}

       	catch (Exception e) {

            	*log*.error("Error Message " + e.getMessage(), e);

            	*log*.error("Unable to  the process " + event.getProcessInstanceId() + " For the event "+ event.getType());

       	}

       	

 	}

 

 	@Override

 	public boolean isFailOnException() {

       	// TODO Auto-generated method stub

       	return false;

 	}

}

 

**Make the above java code to jar file  and put on the folder path**

**C:\Program Files (x86)\alfresco\process-services-1.9.0.3\tomcat\webapps\activiti-app\WEB-INF\lib**

![image alt text](image_147.png)

**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@**

![image alt text](image_148.png)

**Ref that **

