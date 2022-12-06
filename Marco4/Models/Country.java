package Marco4.Models;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.FlowLayout;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Country {
	private String countryName;
	private Team soccerTeam;
	private PressOfficer pressOfficer;
	private Image flagImage;
	private static final String FLAG_PATH = "src/flag.png";
	

	public Country(String countryName) {
		super();
		this.countryName = countryName;
		this.soccerTeam = new Team();
		//this.pressOfficer =//Script pra puxar do Json o objeto PressOfficer;	
		try {
			this.flagImage = ImageIO.read(new File(FLAG_PATH));
			ImageIcon icon = new ImageIcon(flagImage);
			JFrame frame = new JFrame();
			frame.setLayout(new FlowLayout());
			frame.setSize(800, 600);
			JLabel lbl = new JLabel();
			lbl.setIcon(icon);
			frame.add(lbl);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public int getCommitteeQuantity(){
		return getSoccerTeam().playersQuantity() + getSoccerTeam().technicalsquantity() + 1; //pressOfficer     
	}
	
	public PressOfficer getPressOfficer() {
		return pressOfficer;
	}

	public void setPressOfficer(PressOfficer pressOfficer) {
		//fazer um método para salvar no json o pressofficer novo
		try {
    		JSONParser parser = new JSONParser();
        	Object obj = parser.parse(new FileReader("src/resources/Angola.json"));
        	JSONObject jsonObject = (JSONObject) obj;
        	jsonObject.put("name", pressOfficer.getName());
        	jsonObject.put("tel1", pressOfficer.getTel1());
        	jsonObject.put("tel2", pressOfficer.getTel2());
        	jsonObject.put("emailAccount", pressOfficer.getEmailAccount());
        	jsonObject.put("name", pressOfficer.getAge());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		this.pressOfficer = pressOfficer;
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
