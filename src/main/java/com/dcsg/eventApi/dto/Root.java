package com.dcsg.eventApi.dto;

import java.util.ArrayList;

public class Root {
    private ArrayList<Event> events;
    private Meta meta;
    
    public ArrayList<Event> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
}
