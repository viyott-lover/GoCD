package com.metabuild.test;

//import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.metabuild.test.events.Event;


public class EventTest {
	
	@Test
	public void builder() {
		Event event = Event.builder()
				.name("Spring REST API")
				.description("REST API development with Spring")
				.build();
		assertThat(event).isNotNull();
	}
	
	@Test
	public void javaBean() {
		
		//given
		String name = "Event";			
		String description = "Spring";
		
		//when
		Event event = new Event();
		event.setName(name);
		event.setDescription(description);
		
		//then
		assertThat(event.getName()).isEqualTo("Event");
		assertThat(event.getDescription()).isEqualTo("Spring");
	}
}
