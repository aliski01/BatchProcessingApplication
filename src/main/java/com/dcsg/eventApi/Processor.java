package com.dcsg.eventApi;

import org.springframework.batch.item.ItemProcessor;

import com.dcsg.eventApi.dto.Event;

public class Processor implements ItemProcessor<Event, Event> {

	@Override
	public Event process(Event data) throws Exception {
		return data;
	}

}
