package Marco4.Models;

import javax.imageio.ImageIO;

public class Country {
	private String countryName;
	private Team soccerTeam;
	private PressOfficer pressOfficer;
	private ImageIO flagImage;

	public int getCommitteeQuantity(){
		return getSoccerTeam().playersQuantity() + getSoccerTeam().technicalsquantity() + 1; //pressOfficer     
	}
	
	public PressOfficer getPressOfficer() {
		return pressOfficer;
	}

	public void setPressOfficer(PressOfficer pressOfficer) {
		this.pressOfficer = pressOfficer;
	}

	public ImageIO getFlagImage() {
		return flagImage;
	}

	public void setFlagImage(ImageIO flagImage) {
		this.flagImage = flagImage;
	}

	public Team getSoccerTeam() {
		return soccerTeam;
	}

	public void setSoccerTeam(Team soccerTeam) {
		this.soccerTeam = soccerTeam;
	}

	public Country(String countryName) {
		setCountryName(countryName);
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
