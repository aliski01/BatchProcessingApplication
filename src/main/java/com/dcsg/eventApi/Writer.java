package com.dcsg.eventApi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.dcsg.eventApi.dto.Event;

public class Writer implements ItemWriter<Event> {
	private static final Logger log = LoggerFactory.getLogger(Writer.class);

	@Override
	public void write(List<? extends Event> events) throws Exception {
		for (Event event : events) {
			
			log.debug("Writing the Event data, Id:: " + event.id +"   Short Title ::  " + event.short_title);
		}
	}

}
