package Marco4;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import Marco4.Interfaces.*;
import Marco4.Models.*;

public class Programa implements NationalTeamStats, NationalTeamInfos {

	private Country country = new Country("Angola");

    private int questionsCount = 0;


    @Override
    public int getHowManyQuestions() {

        return questionsCount;

    }

    @Override
    public int getHowManyCallsToPlayer(int number) {

        return country.getSoccerTeam().getPlayers(number).getCallsCount();

    }

    private void methodCount(){

        questionsCount++;

    }

    @Override
    public int getHowManyMembers() {
        return country.getSoccerTeam().playersQuantity() + country.getSoccerTeam().technicalsquantity();      
    }

    @Override
    public int getOldestPlayer() {
        return country.getSoccerTeam().oldestPlayer();
    }

    @Override
    public int getYoungestPlayer() {
        return country.getSoccerTeam().youngestPlayer();
    }

    @Override
    public double getAverageAge() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getPlayer(int number) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPressOfficerContacts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCountryName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ImageIO getFlagImage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Path getTechnicalCommittee() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NationalTeamStats getStatsResponsible() {
        // TODO Auto-generated method stub
        return null;
    }
}