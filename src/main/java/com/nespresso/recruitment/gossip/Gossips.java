package com.nespresso.recruitment.gossip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Gossips {
	private HashMap<String, Person> personsGossip = new HashMap<String, Person>();
	private Person fromPerson;
	private String message;

	public Gossips(String... persons) {
		Parser parser = new Parser();
		personsGossip = parser.parsePersons(persons);
	}

	public Gossips from(String person) {
		this.fromPerson = personsGossip.get(person);
		return this;
	}

	public Gossips to(String personGossip) {
		Person person = personsGossip.get(personGossip);
		if (this.fromPerson != null) {
			person.addHearingPerson(this.fromPerson);
			this.fromPerson = null;
		} else if (this.message != null) {
			person.addMessage(this.message);
		}
		return this;
	}

	public Gossips say(String message) {
		this.message = message;
		return this;
	}

	public String ask(String person) {

		return personsGossip.get(person).ask();
	}

	public void spread() {
		List<Person> gossipsPersonWhoAreOccuped = new ArrayList<Person>();
		for (Person currentPerson : personsGossip.values()) {
			Person personGossip = currentPerson.hear(gossipsPersonWhoAreOccuped);
			if (personGossip != null)
				gossipsPersonWhoAreOccuped.add(personGossip);
		}
	}

}
