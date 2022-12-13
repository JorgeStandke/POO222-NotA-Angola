package module_angola;

public class TeamStats implements NationalTeamStats {
    private Country country;
    private int count;

    TeamStats(Country country, int count){
        this.country = country;
        this.count = count;
    }

    @Override
    public int getHowManyQuestions() {
        return count;
    }

    @Override
    public int getHowManyCallsToPlayer(int number) {
        return country.getSoccerTeam().getPlayers(number).getCallsCount();

    }
    
}
