package com.dcsg.eventApi.dto;

import java.util.ArrayList;
import java.util.Date;


public class Event {
	public String type;
    public int id;
    public Date datetime_utc;
    public Venue venue;
    public boolean datetime_tbd;
    public ArrayList<Performer> performers;
    public boolean is_open;
    public ArrayList<Object> links;
    public Date datetime_local;
    public boolean time_tbd;
    public String short_title;
    public Date visible_until_utc;
    public Stats stats;
    public ArrayList<Taxonomy> taxonomies;
    public String url;
    public double score;
    public Date announce_date;
    public Date created_at;
    public boolean date_tbd;
    public String title;
    public double popularity;
    public String description;
    public String status;
    public Object access_method;
    public Object event_promotion;
    public Announcements announcements;
    public boolean conditional;
    public Object enddatetime_utc;
    public ArrayList<Object> themes;
    public ArrayList<Object> domain_information;
}
