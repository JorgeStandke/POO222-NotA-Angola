package module_angola;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Country {
	private String countryName;
	private Team soccerTeam;
	private PressOfficer pressOfficer;
	private Image flagImage;
	private static final String FLAG_PATH = "resources/flag.png";
	

	public Country(String countryName) {
		this.countryName = countryName;
		this.soccerTeam = new Team();	
		try {
			this.flagImage = ImageIO.read(new File(FLAG_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadValues();
	}

	private void loadValues(){
		ObjectMapper m = new ObjectMapper();
		try {
			List<PressOfficer> aux = m.readValue(Paths.get(Angola.getAngolajsonpath()).toFile(), m.getTypeFactory().constructCollectionType(List.class, PressOfficer.class));
			for (PressOfficer value : aux) {
				this.pressOfficer = value;
			}
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public int getCommitteeQuantity(){
		return getSoccerTeam().playersQuantity() + getSoccerTeam().technicalsquantity() + 1; //pressOfficer     
	}
	
	public PressOfficer getPressOfficer() {
		return pressOfficer;
	}

	public void setPressOfficer(PressOfficer pressOfficer) {
		this.pressOfficer = pressOfficer;
        try {
            ObjectMapper m = new ObjectMapper();
            m.writeValue(Paths.get(Angola.getAngolajsonpath()).toFile(), pressOfficer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public Image getFlagImage() {
		return flagImage;
	}

	public void setFlagImage(Image flagImage) {
		this.flagImage = flagImage;
	}

	public Team getSoccerTeam() {
		return soccerTeam;
	}

	public void setSoccerTeam(Team soccerTeam) {
		this.soccerTeam = soccerTeam;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
