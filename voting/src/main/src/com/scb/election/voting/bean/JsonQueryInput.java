package com.scb.election.voting.bean;

import java.util.ArrayList;
import java.util.List;

public class JsonQueryInput {

	private List<Query> query;
	private Response response;

	public List<Query> getQuery() {
		if(query == null)
			query = new ArrayList<Query>();
		return query;
	}

	public void setQuery(List<Query> query) {
		this.query = query;
	}

	public Response getResponse() {
		if(response ==null)
			response = new Response();
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}
