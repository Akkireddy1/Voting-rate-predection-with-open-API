package com.scb.election.voting.bean;

import java.util.Comparator;

public class ElectionData implements Comparator<ElectionData> {

	public int region;
	public double voting;

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public double getVoting() {
		return voting;
	}

	public void setVoting(double voting) {
		this.voting = voting;
	}

	public ElectionData(int region, double voting) {
		super();
		this.region = region;
		this.voting = voting;
	}

	public ElectionData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int compare(ElectionData t1, ElectionData t2) {
		if (t1.voting > t2.voting) {
			return 1;
		}
		if (t1.voting < t2.voting) {
			return -1;
		} else {
			return 0;
		}
	}

}
