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
