package Marco4.Interfaces;
import java.nio.file.Path;
import java.awt.Image;

public interface NationalTeamInfos {
	abstract int getHowManyMembers();
	abstract int getOldestPlayer();
	abstract int getYoungestPlayer();
	abstract double getAverageAge();
	abstract String getPlayer(int number);
	abstract String getPressOfficerContacts();
	abstract String getCountryName();
	abstract Image getFlagImage();
	abstract Path getTechnicalCommittee();
	abstract NationalTeamStats getStatsResponsible();
	
}
