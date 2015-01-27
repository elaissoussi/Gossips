package com.nespresso.recruitment.gossip;

import java.util.HashMap;

public class Parser {

	public HashMap<String, Person> parsePersons(String[] persons) {
		HashMap<String, Person> personsGossip = new HashMap<String, Person>();
		for (String currentPersonInput : persons) {
			String personName = currentPersonInput.split(" ")[1];
			PersonType personType = PersonType.valueOf(currentPersonInput
					.split(" ")[0]);
			Person person = new Person(personName, personType);
			personsGossip.put(personName, person);
		}
		return personsGossip;
	}

}
