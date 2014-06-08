package ca.etsmtl.ticketz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Show implements Serializable {
	
	private int id;
	private String name;
	private List<Artist> artists;
	private DateTime dateStart;
	private DateTime dateEnd;
	private boolean featured;
	
	
	public Show() {
		this("", new ArrayList<Artist>(), DateTime.now(), DateTime.now());
	}
	public Show(String _name, List<Artist> _artists, DateTime _dateStart, DateTime _dateEnd) {
		name = _name;
		artists = _artists;
		dateStart = _dateStart;
		dateEnd = _dateEnd;
	}
	public Show(String _name, Artist _artist, DateTime _dateStart, DateTime _dateEnd) {
		this(_name, new ArrayList<Artist>(), _dateStart, _dateEnd);
		artists.add(_artist);
	}
	public Show(String _name, List<Artist> _artists, DateTime _dateStart, DateTime _dateEnd, boolean _featured) {
		this(_name, _artists, _dateStart, _dateEnd);
		featured = _featured;
	}
	public Show(String _name, Artist _artist, DateTime _dateStart, DateTime _dateEnd, boolean _featured) {
		this(_name, _artist, _dateStart, _dateEnd);
		featured = _featured;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int _id) {
		id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public List<Artist> getArtists() {
		return artists;
	}
	public Artist getArtistAt(int _index) {
		return artists.get(_index);
	}
	public void setArtists(List<Artist> _artists) {
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
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean _featured) {
		featured = _featured;
	}
}
