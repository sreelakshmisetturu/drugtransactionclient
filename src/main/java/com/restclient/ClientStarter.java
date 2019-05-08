package com.restclient;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import com.opencsv.CSVReader;
import com.restclient.model.Transaction;

public class ClientStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Long> users = new HashSet<Long>();
		FetchFrequency fetch = new FetchFrequency();
		addTransactions(users);
		
		// call fetch frequency method 
		Iterator<Long> it = users.iterator();
		while (it.hasNext()) {
			fetch.fetchTopMerchants(it.next());
		}
	}

	private static void addTransactions(HashSet<Long> users) {
		String datafile = "src/main/resources/coding_challenge_data.csv";
		PostRequestTemplate pst = new PostRequestTemplate();
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(datafile));
			String[] line;
			while ((line = reader.readNext()) != null) {
				Transaction transaction = new Transaction();
				transaction.setUserId(Long.parseLong(line[0]));
				transaction.setMerchant(line[1]);
				transaction.setPrice(Double.parseDouble(line[3]));
				LocalDateTime dateTime = LocalDateTime.parse(line[4]);
				Date date = null;
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
					date = dateFormat.parse(line[4]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				transaction.setPurchaseDate(date);
				transaction.setTranId(Long.parseLong(line[5]));
				users.add(transaction.getUserId());
				pst.saveTransaction(transaction);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
