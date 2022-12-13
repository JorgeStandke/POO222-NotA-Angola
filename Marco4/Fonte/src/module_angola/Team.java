package module_angola;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;


public class Team {
    HashMap<Integer, Player> players = new HashMap<>();
    HashMap<String, Technical> technicals = new HashMap<>();

    public Team(){
        loadValues();
    }
    
    private void loadValues(){
		ObjectMapper m = new ObjectMapper();
		try {
			List<Player> aux = m.readValue(Paths.get(Angola.getAngolajsonpath()).toFile(), m.getTypeFactory().constructCollectionType(List.class, Player.class));
			for (Player value : aux) {
				this.players.put(value.getNumber(), value);
			}
            List<Technical> aux2 = m.readValue(Paths.get(Angola.getAngolajsonpath()).toFile(), m.getTypeFactory().constructCollectionType(List.class, Technical.class));
			for (Technical value : aux2) {
				this.technicals.put(value.getName(), value);
			}
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
   
    public int playersQuantity(){
        return this.players.size();
    }
    
    public int technicalsquantity(){
        return this.technicals.size();
    }

    public Player getPlayers(int number) {
        return players.get(number);
    }

    public HashMap<Integer, Player> getAllPlayers(){
        return players;
    }

    public void setPlayers(Player player) {
        players.put(player.getNumber(), player);
        try {
            ObjectMapper m = new ObjectMapper();
            m.writeValue(Paths.get(Angola.getAngolajsonpath()).toFile(), player);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Technical getTechnical(String name) {
        return technicals.get(name);
    }

    public void setTechnicals(Technical technical) {
        technicals.put(technical.getName(), technical);
        try {
            ObjectMapper m = new ObjectMapper();
            m.writeValue(Paths.get(Angola.getAngolajsonpath()).toFile(), technical);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int oldestPlayer(){
        int age = Integer.MIN_VALUE;
        for (int chave : players.keySet()) {      
            if(getPlayers(chave).getAge() > age){
                age = getPlayers(chave).getAge();
            }
        };
        return age;
    }

    public int youngestPlayer(){
        int age = Integer.MAX_VALUE;
        for (int chave : players.keySet()) {      
            if(getPlayers(chave).getAge() < age){
                age = getPlayers(chave).getAge();
            }
        };
        return age;
    }

    public double averageAge(){
        int aux = 0;
        for (int chave : players.keySet()) {      
           aux += getPlayers(chave).getAge();
        };
        return aux / playersQuantity();
    }
}
