package ca.etsmtl.ticketz.model;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Show {
	
	private String name;
	private ArrayList<Artist> artists;
	private DateTime dateStart;
	private DateTime dateEnd;
	
	
	public Show() {
		this("", new ArrayList<Artist>(), DateTime.now(), DateTime.now());
	}
	public Show(String _name, ArrayList<Artist> _artists, DateTime _dateStart, DateTime _dateEnd) {
		name = _name;
		artists = _artists;
		dateStart = _dateStart;
		dateEnd = _dateEnd;
	}
	public Show(String _name, Artist _artist, DateTime _dateStart, DateTime _dateEnd) {
		name = _name;
		artists = new ArrayList<Artist>();
		artists.add(_artist);
		dateStart = _dateStart;
		dateEnd = _dateEnd;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public ArrayList<Artist> getArtists() {
		return artists;
	}
	public Artist getArtistAt(int _index) {
		return artists.get(_index);
	}
	public void setArtists(ArrayList<Artist> _artists) {
		artists = _artists;
	}
	public void addArtist(Artist _artist) {
		artists.add(_artist);
	}
	public DateTime getDateStart() {
		return dateStart;
	}
	public void setDateStart(DateTime _dateStart) {
		dateStart = _dateStart;
	}
	public DateTime getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(DateTime _dateEnd) {
		dateEnd = _dateEnd;
	}
	
	

}
