package Marco4.Models;

import java.util.HashMap;

public class Team {
    HashMap<Integer, Player> players;
    HashMap<String, Technical> technicals;
   

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
        this.players.put(player.getNumber(), player);
    }
    public Technical getTechnical(String name) {
        return technicals.get(name);
    }
    public void setTechnicals(Technical technical) {
        this.technicals.put(technical.getName(), technical);
    }
    public int oldestPlayer(){
        int age = Integer.MIN_VALUE;
        players.forEach((key, value)  -> {
            if(value.getAge() > age){
                age = value.getAge();
            }
        } );
        return age;
    }
    public int youngestPlayer(){
        int age = Integer.MIN_VALUE;
        players.forEach((key, value) -> {
            if(value.getAge() > age){
                age = value.getAge();
            }
        } );
        return age;
    }
}
