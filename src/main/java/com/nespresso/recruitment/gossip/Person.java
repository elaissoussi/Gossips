package com.nespresso.recruitment.gossip;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String personName;
	private PersonType personType;
	private List<Person> hearFrom = new ArrayList<Person>();
	private List<String> messages = new ArrayList<String>();

	public Person(String personName, PersonType personType) {
		this.personName = personName;
		this.personType = personType;

	}

	public void addHearingPerson(Person fromPerson) {
		hearFrom.add(fromPerson);
	}

	public void addMessage(String message) {
		if (personType.equals(PersonType.Dr)) {
			messages.add(message);
		} else if (personType.equals(PersonType.Mr)) {
			messages.clear();
			messages.add(message);
		}

	}

	public String ask() {

		return String.join(", ", messages);
	}

	public Person hear(List<Person> gossipsPersonWhoAreOccuped) {
		for (Person currentPerson : hearFrom) {
			if (!currentPerson.messages.isEmpty()) {
				if (gossipsPersonWhoAreOccuped.contains(currentPerson)) {
					addMessageFromTheInitialCurrentPerson(currentPerson);
					continue;
				}
				return addMessageFromTheCurrentPerson(currentPerson);
			}
		}
		return null;
	}

	private Person addMessageFromTheCurrentPerson(Person currentPerson) {
		this.addMessage(currentPerson.messages.get(currentPerson.messages
				.size() - 1));
		if (!currentPerson.personType.equals(PersonType.Dr))
			currentPerson.messages.remove(0);
		return this;
	}

	private void addMessageFromTheInitialCurrentPerson(Person currentPerson) {
		if (isTheCurrentDrHasMessageLastTour(currentPerson)) {
			this.addMessage(currentPerson.messages.get(currentPerson.messages
					.size() - 2));
		}
	}

	private boolean isTheCurrentDrHasMessageLastTour(Person currentPerson) {
		return currentPerson.personType.equals(PersonType.Dr)
				&& currentPerson.messages.size() >= 2;
	}

	@Override
	public String toString() {
		return "Person [personName=" + personName + ", messages=" + messages
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((personName == null) ? 0 : personName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		return true;
	}

}
