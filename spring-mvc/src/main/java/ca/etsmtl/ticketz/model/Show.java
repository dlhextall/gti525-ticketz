package ca.etsmtl.ticketz.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="Show")
public class Show {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="venue")
	private String venue;
	@Column(name="address")
	private String address;
	@Column(name="imageFeaturedUrl")
	private String imageFeaturedUrl;
	@Column(name="imageThumbUrl")
	private String imageThumbUrl;
	@Column(name="imageDetailUrl")
	private String imageDetailUrl;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Show_Representation",
				joinColumns={@JoinColumn(name="s_id")},
				inverseJoinColumns={@JoinColumn(name="r_id")})
	private List<Representation> representations;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Show_Artist",
				joinColumns={@JoinColumn(name="s_id")},
				inverseJoinColumns={@JoinColumn(name="a_id")})
	private List<Artist> artists;
	@Column(name="featured")
	private boolean featured;
	
	
	public Show() {
		representations = new ArrayList<Representation>();
		artists = new ArrayList<Artist>();
	}
	public Show(int _id, String _name, String _description, String _venue, String _address, String _imageUrl, List<Representation> _representations, List<Artist> _artists) {
		id = _id;
		name = _name;
		description = _description;
		venue = _venue;
		address = _address;
		imageFeaturedUrl = _imageUrl;
		imageThumbUrl = _imageUrl;
		imageDetailUrl = _imageUrl;
		representations = _representations;
		artists = _artists;
	}
	public Show(int _id, String _name, String _description, String _venue, String _address, String _imageUrl, Representation _representation, Artist _artist) {
		this(_id, _name, _description, _venue, _address, _imageUrl, new ArrayList<Representation>(), new ArrayList<Artist>());
		representations.add(_representation);
		artists.add(_artist);
	}
	public Show(int _id, String _name, String _description, String _venue, String _address, String _imageUrl, List<Representation> _representations, List<Artist> _artists, boolean _featured) {
		this(_id, _name, _description, _venue, _address, _imageUrl, _representations, _artists);
		featured = _featured;
	}
	public Show(int _id, String _name, String _description, String _venue, String _address, String _imageUrl, Representation _representation, Artist _artist, boolean _featured) {
		this(_id, _name, _description, _venue, _address, _imageUrl, _representation, _artist);
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
	public String getVenue() {
		return venue;
	}
	public void setVenue(String _venue) {
		venue = _venue;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String _address) {
		address = _address;
	}
	public String getImageFeaturedUrl() {
		return imageFeaturedUrl;
	}
	public void setImageFeaturedUrl(String _imageFeaturedUrl) {
		imageFeaturedUrl = _imageFeaturedUrl;
	}
	public String getImageThumbUrl() {
		return (imageThumbUrl != null) ? imageThumbUrl : imageFeaturedUrl;
	}
	public void setImageThumbUrl(String _imageThumbUrl) {
		imageThumbUrl = _imageThumbUrl;
	}
	public String getImageDetailUrl() {
		return (imageDetailUrl != null) ? imageDetailUrl : imageFeaturedUrl;
	}
	public void setImageDetailurl(String _imageDetailUrl) {
		imageDetailUrl = _imageDetailUrl;
	}
	public List<Representation> getRepresentations() {
		return representations;
	}
	public Representation getRepresentationAt(int _index) {
		 
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
		if (representations.size() == 0) {
			return null;
		}
		Collections.sort(representations, new Comparator<Representation>() {
			public int compare(Representation r1, Representation r2) {
				return r1.getDate().compareTo(r2.getDate());
			}
		});
		return representations.get(0).getDate();
	}
	public DateTime getDateEnd() {
		if (representations.size() == 0) {
			return null;
		}
		Collections.sort(representations, new Comparator<Representation>() {
			public int compare(Representation r1, Representation r2) {
				return r1.getDate().compareTo(r2.getDate());
			}
		});
		return representations.get(representations.size() - 1).getDate();
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean _featured) {
		featured = _featured;
	}
}
