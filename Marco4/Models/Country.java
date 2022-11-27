package Marco4.Models;

public class Country {
	private String countryName;
	private Team soccerTeam;
	
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
