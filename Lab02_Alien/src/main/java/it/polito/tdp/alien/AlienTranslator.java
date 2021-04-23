package it.polito.tdp.alien;

import java.util.TreeMap;

public class AlienTranslator {
	
	TreeMap<String, String> dizionario = new TreeMap<String, String>();
	
	public void addWord(String a, String b) {
		dizionario.put(a, b);
	}
	
	public String cercaParola(String a) {
		return dizionario.get(a);
	}

	public void reset() {
		dizionario.clear();		
	}

}
