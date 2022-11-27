package Marco4;
import Marco4.Interfaces.*;
import Marco4.Models.*;

public class Programa implements NationalTeamStats {

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
}