package com.nespresso.recruitment.gossip;

import java.util.List;

public interface Hearing {
	Person hear(List<Person> gossipsPersonWhoAreOccuped, List<Person> hearFrom);
}
