package Marco4.Interfaces;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public interface NationalTeamInfos {
	abstract int getHowManyMembers();
	abstract int getOldestPlayer();
	abstract int getYoungestPlayer();
	abstract double getAverageAge();
	abstract String getPlayer(int number);
	abstract String getPressOfficerContacts();
	abstract String getCountryName();
	abstract ImageIO getFlagImage();
	abstract Path getTechnicalCommittee();
	abstract NationalTeamStats getStatsResponsible();
	
}
