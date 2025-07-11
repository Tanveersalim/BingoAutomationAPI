package api.payload;

import java.util.List;

public class adminchest {
	
	String chestid;
	String shortcode;
	String name;
	String image;
	String imagelarge;
	String description;
	String ticketcount;
	private String min;
	private String max;
	private String rarity;
	private List<adminchest> powerUps;
	
	 public adminchest() {
		 
	 }
	    
	    public List<adminchest> getPowerUps() {
		return powerUps;
	}

	 public void setPowerUps(List<adminchest> powerUps) {
		 this.powerUps = powerUps;
	 }

		public adminchest(String min, String max, String rarity) {
	        this.min = min;
	        this.max = max;
	        this.rarity = rarity;
	    }
	
	
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public String getChestid() {
		return chestid;
	}
	public void setChestid(String chestid) {
		this.chestid = chestid;
	}
	public String getShortcode() {
		return shortcode;
	}
	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImagelarge() {
		return imagelarge;
	}
	public void setImagelarge(String imagelarge) {
		this.imagelarge = imagelarge;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTicketcount() {
		return ticketcount;
	}
	public void setTicketcount(String ticketcount) {
		this.ticketcount = ticketcount;
	}
	
	

}
