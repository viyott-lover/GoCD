package com.metabuild.test.events;

import java.net.URI;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {
	
	private final EventRepository eventRepository;
	private final ModelMapper modelMapper;
	private final EventValidator eventValidator;
	
	public EventController(EventRepository eventRepository, ModelMapper modelMapper, EventValidator eventValidator) {
		this.eventRepository = eventRepository;
		this.modelMapper = modelMapper;
		this.eventValidator = eventValidator;
	}

	@PostMapping
	public ResponseEntity createEvent(@RequestBody EventDto eventDto, Errors errors) {
		
		
		if(errors.hasErrors()) { 
			//return ResponseEntity.badRequest().build();
			return ResponseEntity.badRequest().body(errors); 
		}
		eventValidator.validate(eventDto, errors);

		if(errors.hasErrors()) { 
			//return ResponseEntity.badRequest().build();
			return ResponseEntity.badRequest().body(errors); 
		}
		
		Event event = modelMapper.map(eventDto, Event.class);
		Event addEvent = this.eventRepository.save(event);
		
		WebMvcLinkBuilder selfLinkBuilder = WebMvcLinkBuilder.linkTo(EventController.class).slash(event.getId());
		URI createUri = selfLinkBuilder.toUri();
		
		return ResponseEntity.created(createUri).body(event);
	}
	
}
