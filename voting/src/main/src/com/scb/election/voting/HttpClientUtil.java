package com.scb.election.voting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scb.election.voting.bean.CountyCouncilsElection;
import com.scb.election.voting.bean.Data;
import com.scb.election.voting.bean.ElectionData;
import com.scb.election.voting.bean.HighestVotingData;
import com.scb.election.voting.bean.JsonQueryInput;
import com.scb.election.voting.bean.Query;
import com.scb.election.voting.bean.Selection;

public class HttpClientUtil {

	public static void main(String[] args) throws IOException {

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			// Calling Rest API for getting country voting data
			HttpPost postRequest = new HttpPost(
					"http://api.scb.se/OV0104/v1/doris/en/ssd/START/ME/ME0104/ME0104D/ME0104T4");

			StringEntity input = createStringEntity();
			input.setContentType("application/json;charset=UTF-8");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent()), "UTF-8"));
			StringBuilder outputString = new StringBuilder();
			String line = null;
			System.out.println("Output from Server .... \n");
			while ((line = br.readLine()) != null) {
				outputString.append(line);
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			CountyCouncilsElection councilsElection = gson.fromJson(outputString.toString(),
					CountyCouncilsElection.class);

			getHighestVotingDistrictData(councilsElection);

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * For creating Json input for Post API
	 * 
	 * @return String Entity for input
	 * @throws UnsupportedEncodingException
	 */
	private static StringEntity createStringEntity() throws UnsupportedEncodingException {
		JsonQueryInput jsonInput = createJsonQueryInput();
		Gson gson = new Gson();
		String jsonString = gson.toJson(jsonInput);
		StringEntity input = new StringEntity(jsonString);
		return input;
	}

	/**
	 * For Creating Json Input object for Post method
	 * 
	 * @return
	 */
	private static JsonQueryInput createJsonQueryInput() {
		JsonQueryInput jsonQueryInput = new JsonQueryInput();

		jsonQueryInput.getResponse().setFormat("json");
		Query regionQuery = new Query();
		regionQuery.setCode("Region");
		Selection selection = new Selection();
		selection.setFilter("vs:RegionKommun07+BaraEjAggr");
		selection.setValues(new String[] { "0114", "0115", "0117", "0120", "0123", "0125", "0126", "0127", "0128",
				"0136", "0138", "0139", "0140", "0160", "0162", "0163", "0180", "0181", "0182", "0183", "0184", "0186",
				"0187", "0188", "0191", "0192", "0305", "0319", "0330", "0331", "0360", "0380", "0381", "0382", "0428",
				"0461", "0480", "0481", "0482", "0483", "0484", "0486", "0488", "0509", "0512", "0513", "0560", "0561",
				"0562", "0563", "0580", "0581", "0582", "0583", "0584", "0586", "0604", "0617", "0642", "0643", "0662",
				"0665", "0680", "0682", "0683", "0684", "0685", "0686", "0687", "0760", "0761", "0763", "0764", "0765",
				"0767", "0780", "0781", "0821", "0834", "0840", "0860", "0861", "0862", "0880", "0881", "0882", "0883",
				"0884", "0885", "0980", "1060", "1080", "1081", "1082", "1083", "1214", "1229", "1230", "1231", "1233",
				"1256", "1257", "1260", "1261", "1262", "1263", "1264", "1265", "1266", "1267", "1270", "1272", "1273",
				"1275", "1276", "1277", "1278", "1280", "1281", "1282", "1283", "1284", "1285", "1286", "1287", "1290",
				"1291", "1292", "1293", "1315", "1380", "1381", "1382", "1383", "1384", "1401", "1402", "1407", "1415",
				"1419", "1421", "1427", "1430", "1435", "1438", "1439", "1440", "1441", "1442", "1443", "1444", "1445",
				"1446", "1447", "1452", "1460", "1461", "1462", "1463", "1465", "1466", "1470", "1471", "1472", "1473",
				"1480", "1481", "1482", "1484", "1485", "1486", "1487", "1488", "1489", "1490", "1491", "1492", "1493",
				"1494", "1495", "1496", "1497", "1498", "1499", "1715", "1730", "1737", "1760", "1761", "1762", "1763",
				"1764", "1765", "1766", "1780", "1781", "1782", "1783", "1784", "1785", "1814", "1860", "1861", "1862",
				"1863", "1864", "1880", "1881", "1882", "1883", "1884", "1885", "1904", "1907", "1960", "1961", "1962",
				"1980", "1981", "1982", "1983", "1984", "2021", "2023", "2026", "2029", "2031", "2034", "2039", "2061",
				"2062", "2080", "2081", "2082", "2083", "2084", "2085", "2101", "2104", "2121", "2132", "2161", "2180",
				"2181", "2182", "2183", "2184", "2260", "2262", "2280", "2281", "2282", "2283", "2284", "2303", "2305",
				"2309", "2313", "2321", "2326", "2361", "2380", "2401", "2403", "2404", "2409", "2417", "2418", "2421",
				"2422", "2425", "2460", "2462", "2463", "2480", "2481", "2482", "2505", "2506", "2510", "2513", "2514",
				"2518", "2521", "2523", "2560", "2580", "2581", "2582", "2583", "2584" });
		regionQuery.setSelection(selection);

		Query contentsCodeQuery = new Query();
		contentsCodeQuery.setCode("ContentsCode");
		Selection contentsCodeQuerySelection = new Selection();
		contentsCodeQuerySelection.setFilter("item");
		contentsCodeQuerySelection.setValues(new String[] { "ME0104C5" });
		contentsCodeQuery.setSelection(contentsCodeQuerySelection);
		jsonQueryInput.getQuery().add(regionQuery);
		jsonQueryInput.getQuery().add(contentsCodeQuery);

		return jsonQueryInput;
	}

	/**
	 * For Getting Historical Voting data
	 * 
	 * @param councilsElection Output from Post Query
	 */
	public static void getHighestVotingDistrictData(CountyCouncilsElection councilsElection) {

		HighestVotingData votingData = new HighestVotingData();

		for (Data data : councilsElection.getData()) {

			if (votingData.getDistrictdata().containsKey(data.getKey()[1])) {

				List<ElectionData> electionDatas = new ArrayList<ElectionData>();
				electionDatas.addAll(votingData.getDistrictdata().get(data.getKey()[1]));
				electionDatas.add(new ElectionData(Integer.parseInt(data.getKey()[0]),
						data.getValues()[0].equalsIgnoreCase("..") ? 0.0 : Double.parseDouble(data.getValues()[0])));
				votingData.getDistrictdata().put(data.getKey()[1], electionDatas);

			} else {
				List<ElectionData> electionDatas = new ArrayList<ElectionData>();
				electionDatas.add(new ElectionData(Integer.parseInt(data.getKey()[0]),
						data.getValues()[0].equalsIgnoreCase("..") ? 0.0 : Double.parseDouble(data.getValues()[0])));
				votingData.getDistrictdata().put(data.getKey()[1], electionDatas);
			}

		}

		for (Map.Entry<String, List<ElectionData>> entry : votingData.getDistrictdata().entrySet()) {
			String year = entry.getKey();
			List<ElectionData> electionDatas = entry.getValue();
			Collections.sort(electionDatas, new Comparator<ElectionData>() {

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
			});

			System.out.println(year + " " + electionDatas.get(electionDatas.size() - 1).getRegion() + " "
					+ electionDatas.get(electionDatas.size() - 1).getVoting());
		}

	}

}
