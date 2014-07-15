package ca.etsmtl.ticketz.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Show implements Serializable {
	
	private int id;
	private String name;
	private String description;
	public String salle;
	public String imageUrl;
	public List<Representation> representations;
	private List<Artist> artists;
	private DateTime dateStart;
	private DateTime dateEnd;
	private boolean featured;
	
	
	public Show() {
		representations = new ArrayList<Representation>();
		artists = new ArrayList<Artist>();
	}
	public Show(int _id, String _name, String _description, String _salle, String _imageUrl, List<Representation> _representations, List<Artist> _artists, DateTime _dateStart, DateTime _dateEnd) {
		id = _id;
		name = _name;
		description = _description;
		salle = _salle;
		imageUrl = _imageUrl;
		representations = _representations;
		artists = _artists;
		dateStart = _dateStart;
		dateEnd = _dateEnd;
	}
	public Show(int _id, String _name, String _description, String _salle, String _imageUrl, Representation _representation, Artist _artist, DateTime _dateStart, DateTime _dateEnd) {
		this(_id, _name, _description, _salle, _imageUrl, new ArrayList<Representation>(), new ArrayList<Artist>(), _dateStart, _dateEnd);
		representations.add(_representation);
		artists.add(_artist);
	}
	public Show(int _id, String _name, String _description, String _salle, String _imageUrl, List<Representation> _representations, List<Artist> _artists, DateTime _dateStart, DateTime _dateEnd, boolean _featured) {
		this(_id, _name, _description, _salle, _imageUrl, _representations, _artists, _dateStart, _dateEnd);
		featured = _featured;
	}
	public Show(int _id, String _name, String _description, String _salle, String _imageUrl, Representation _representation, Artist _artist, DateTime _dateStart, DateTime _dateEnd, boolean _featured) {
		this(_id, _name, _description, _salle, _imageUrl, _representation, _artist, _dateStart, _dateEnd);
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String _descr) {
		description = _descr;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String _salle) {
		salle = _salle;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String _imageUrl) {
		imageUrl = _imageUrl;
	}
	public List<Representation> getRepresentations() {
		return representations;
	}
	public Representation getRepresentationAt(int _index) {
		DecimalFormat format = new DecimalFormat("0.00"); 
		format.format(_index);
		return representations.get(_index);
	}
	public void setRepresentations(List<Representation> _representations) {
		representations = _representations;
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
