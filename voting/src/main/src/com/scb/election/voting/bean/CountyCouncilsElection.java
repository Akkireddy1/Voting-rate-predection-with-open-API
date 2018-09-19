package com.scb.election.voting.bean;

import java.util.List;

public class CountyCouncilsElection {

	private List<Columns> columns;

	private List<Comments> comments;

	private List<Data> data;

	public List<Columns> getColumns() {
		return columns;
	}

	public void setColumns(List<Columns> columns) {
		this.columns = columns;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

}