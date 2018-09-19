package com.scb.election.voting.bean;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HighestVotingData {

	private Map<String, List<ElectionData>> districtdata;

	public Map<String, List<ElectionData>> getDistrictdata() {
		if(districtdata == null)
			districtdata = new TreeMap<String, List<ElectionData>>();
		return districtdata;
	}

	public void setDistrictdata(Map<String, List<ElectionData>> districtdata) {
		this.districtdata = districtdata;
	}

}
