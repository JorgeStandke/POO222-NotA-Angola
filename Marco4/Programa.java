package Marco4;
import java.nio.file.Path;
//import org.json.*;
import java.awt.Image;
//import org.json.JSONObject;
import Marco4.Interfaces.*;
import Marco4.Models.*;

public class Programa implements NationalTeamInfos {

	private static Country country = new Country("Angola");
    private int questionsCount = 0;
    //private static final String angolaJsonPath = "src/resources/Angola.json";
    
    public static void main(String[] args) {
		System.out.println(country.getSoccerTeam().getPlayers(10));
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
        //JSONObject JSON = new JSONObject(angolaJsonPath);
        //String data = JSON.get("name").toString();
        return null;
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
        return null;
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