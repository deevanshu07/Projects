package com.info.jira.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

@Service("issueService")
public class IssueService implements IssueServiceHandler {

	
	@Override
	public String createIssue() {
		// TODO Auto-generated method stub
		String statusResponse="";
		Client client = Client.create();

		String data = "{"
				+ "\"fields\": {"
				+ "\"project\":"
				+ "{"
				+ "\"key\": \"OKM\""
				+ "},"
				+ "\"summary\": \"Divided by Zero not permitted.\","
				+ "\"description\": \"Issue while dividing the number by Zero\","
				+ "\"issuetype\": {" + "\"name\": \"Bug\"" + "}" + "}"
				+ "}";
		WebResource webResource = client
				.resource("http://localhost:8056/rest/api/latest/issue/");
		String auth = new String(Base64.encode("deevanshumahajan07" + ":"
				+ "Password"));
		ClientResponse response = webResource
				.header("Authorization", "Basic " + auth)
				.type("application/json").accept("application/json")
				.post(ClientResponse.class, data);
		return response.getEntity(String.class);
	}
}
