package Marco4;
import java.nio.file.Path;
import org.json.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import Marco4.Interfaces.*;
import Marco4.Models.*;

public class Programa implements NationalTeamInfos {

	private static Country country = new Country("Angola");
    private static final String FLAG_PATH = "src/flag.png";
    private int questionsCount = 0;
    private static final String angolaJsonPath = "src/resources/Angola.json";
    
    public static void main(String[] args) {
		System.out.println(country.getSoccerTeam().getPlayers(10));
	}

    public Programa(PressOfficer officer, int questionsCount) {
		super();
	}

	private void methodCount(){

        questionsCount++;

    }

    @Override
    public int getHowManyMembers() {
        methodCount();
        return  country.getCommitteeQuantity();
    }

    @Override
    public int getOldestPlayer() {
        methodCount();
        return country.getSoccerTeam().oldestPlayer();
    }

    @Override
    public int getYoungestPlayer() {
        methodCount();
        return country.getSoccerTeam().youngestPlayer();
    }

    @Override
    public double getAverageAge() {
        methodCount();
        return country.getSoccerTeam().averageAge();
    }

    @Override
    public String getPlayer(int number) {
        methodCount();
        JSONObject JSON = new JSONObject(angolaJsonPath);
        String data = JSON.get("name").toString();
        return data;
    }

    @Override
    public String getPressOfficerContacts() {
        methodCount();
        return "";
    }

    @Override
    public String getCountryName() {
        methodCount();
        return country.getCountryName();
    }

    @Override
    public Image getFlagImage() {
        methodCount();
        Image image;

        try {
            image = ImageIO.read(new File(FLAG_PATH));
            ImageIcon icon = new ImageIcon(image);
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

        return image;
    }

    @Override
    public Path getTechnicalCommittee() {
        methodCount();
        return null;
    }

    @Override
    public NationalTeamStats getStatsResponsible() {
        return new TeamStats(country, questionsCount);
    }
}