package com.scb.election.voting.bean;

public class Query {

	private String code;
	private Selection selection;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Selection getSelection() {
		if(selection == null)
			selection = new Selection();
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

}
