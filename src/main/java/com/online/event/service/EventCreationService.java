package com.online.event.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.event.model.Event;
import com.online.event.repository.EventCreationRepository;


@Service
public class EventCreationService {

	@Autowired
	private EventCreationRepository eventCreationRepository;

	@Autowired
	private SequenceDaoImpl sequenceDaoImpl;
	public Event save(Event event) throws Exception {
		
		event.setId(sequenceDaoImpl.getNextSequenceId("Hosting"));
		return eventCreationRepository.save(event);
	}
}