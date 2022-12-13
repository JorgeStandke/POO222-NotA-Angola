package Marco4.Models;

import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.xml.sax.Parser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

public class Team {
    HashMap<Integer, Player> players = new HashMap<>();
    HashMap<String, Technical> technicals = new HashMap<>();
    private JSONParser parser = new JSONParser();
   
    public Team(){
        //lido json, ter salvo todos os objetos de players
        //for each
        //this.players.put(player.getNumber(), Player);
        
        //lido json, ter salvo todos os objetos de technicals
        //for each
        //this.technicals.put(technical.getName(), Technical);
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

    public void setPlayers(Player player) {
        //fazer um método para salvar no json o player novo
    	try {
    		JSONParser parser = new JSONParser();
        	Object obj = parser.parse(new FileReader("src/resources/Angola.json"));
        	JSONObject jsonObject = (JSONObject) obj;
        	jsonObject.put("number", player.getNumber());
        	jsonObject.put("name", player.getName());
        	jsonObject.put("nickname", player.getNickname());
        	jsonObject.put("weight", player.getWeight());
        	jsonObject.put("height", player.getHeight());
        	jsonObject.put("birthDate", player.getBirthDate());
        	jsonObject.put("position", player.getPosition());
        	jsonObject.put("currentClub", player.getCurrentClub());
        	FileWriter file = new FileWriter("src/resources/Angola.json");
            file.write(jsonObject.toJSONString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        this.players.put(player.getNumber(), player);
    }

    public Technical getTechnical(String name) {
        return technicals.get(name);
    }

    public void setTechnicals(Technical technical) {
        //fazer um método para salvar no json o technical novo
    	try {
    		JSONParser parser = new JSONParser();
        	Object obj = parser.parse(new FileReader("src/resources/Angola.json"));
        	JSONObject jsonObject = (JSONObject) obj;
        	jsonObject.put("name", technical.getName());
        	jsonObject.put("nickname", technical.getNickname());
        	jsonObject.put("birthDate", technical.getAge());
        	FileWriter file = new FileWriter("src/resources/Angola.json");
            file.write(jsonObject.toJSONString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        this.technicals.put(technical.getName(), technical);
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
