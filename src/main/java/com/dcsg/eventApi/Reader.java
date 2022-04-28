package com.dcsg.eventApi;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dcsg.eventApi.dto.Event;
import com.dcsg.eventApi.dto.Meta;
import com.dcsg.eventApi.dto.Root;

@Component
public class Reader implements ItemReader<Event> {

	private static final Logger log = LoggerFactory.getLogger(Reader.class);

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private HttpEntity<String> entity;

	Meta meta = new Meta();
	Root root = new Root();

	private int nextEventIndex;
	ArrayList<Event> eventData;

	@Override
	public Event read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		log.info("Reading the information of the next Event");

		if (EventDataIsNotInitialized()) {
			root = fetchEventDataFromRestApi();
			meta = root.getMeta();
			eventData = root.getEvents();
			log.info("Eventdata fetched.");


		}
		Event nextEvent = null;

		/*
		 * if (eventData == null || nextEventIndex >= meta.per_page) { meta.page++;
		 * log.debug("Reading page " + meta.page); // nextEventIndex++;
		 * log.debug("nextEventIndex:: " + nextEventIndex); log.debug("perpage:: " +
		 * meta.per_page);
		 * 
		 * }
		 */
		log.debug("Reading from page: " + meta.page);
		if (nextEventIndex < meta.per_page) {

			nextEvent = eventData.get(nextEventIndex);
			nextEventIndex++;

			log.debug("Found Event: {}" + nextEvent);
			return nextEvent;
		} else {
			nextEventIndex = 0;
			eventData = null;
			// log.info("Inside else");
		}

		return nextEvent;

	}

	private boolean EventDataIsNotInitialized() {
		return this.eventData == null;
	}
	private String setUriBuilder(int page)
	{
		String baseUrl = "https://api.seatgeek.com/2/events";
		String clientId ="MjU4Mzc5MzJ8MTY0NTY5MTEwOC42NTQxODA4";
		String clientSecret ="75e407df985dad4c85127f6d3763e7ccf0e981125b9a699f60ee41f34125c4ba";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);

		builder.queryParam("per_page", 20)
		.queryParam("page", page)
		.queryParam("client_id", clientId)
		.queryParam("client_secret",clientSecret);
		//String sbuilder = "https://api.seatgeek.com/2/events?client_id=MjU4Mzc5MzJ8MTY0NTY5MTEwOC42NTQxODA4&client_secret=75e407df985dad4c85127f6d3763e7ccf0e981125b9a699f60ee41f34125c4ba";

		return builder.toUriString();
	}
	private Root fetchEventDataFromRestApi() {


		String builder = setUriBuilder(2);
		ResponseEntity<Root> response = restTemplate.exchange(builder, HttpMethod.GET, entity, Root.class);
		Root eventData = response.getBody();
		
		int total = eventData.getMeta().total;
		int page=eventData.getMeta().page;
		int perPage=20;
		total = total-(page*perPage);
		
		log.debug("eventData Size: " + eventData.getEvents().size());
		return eventData;
	}

}
