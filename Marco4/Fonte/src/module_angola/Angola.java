package module_angola;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Angola implements NationalTeamInfos {

	private static Country country;
    private int questionsCount = 0;
    private static final String angolaJsonPath = "resources/Angola.json";
    
    public static String getAngolajsonpath() {
        return angolaJsonPath;
    }

    public static void main(String[] args) {
		new Angola();
	}

    public Angola(){
      country = new Country("Angola");
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
        ObjectMapper m = new ObjectMapper();
        country.getSoccerTeam().getPlayers(number).updateCount();
        try {
            return m.writeValueAsString(country.getSoccerTeam().getPlayers(number));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getPressOfficerContacts() {
        methodCount();
        ObjectMapper m = new ObjectMapper();
        try {
            return m.writeValueAsString(country.getPressOfficer());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getCountryName() {
        methodCount();
        return country.getCountryName();
    }

    @Override
    public Image getFlagImage() {
        methodCount();   
        return country.getFlagImage();
    }

    @Override
    public Path getTechnicalCommittee() {
        methodCount();
        return Paths.get(angolaJsonPath);
    }

    @Override
    public NationalTeamStats getStatsResponsible() {
        return new TeamStats(country, questionsCount);
    }
}