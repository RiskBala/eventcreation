package com.online.event.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.event.model.Event;
import com.online.event.service.EventCreationService;


@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class EventCreationController {

	@Autowired
	private EventCreationService eventCreationService;

	@RequestMapping(value = "event/v1/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> create(@Valid @RequestBody Event event, @RequestHeader(value = "userId", required = true) String userId,
			@RequestHeader(value = "roles", required = true) String roles) throws Exception {
		event.setCreatedDate(new Date());
		event.setCreatedBy(userId);
		event.setStatus("open");
		eventCreationService.save(event);
		return ResponseEntity.ok("Event created");
	}
	

}
