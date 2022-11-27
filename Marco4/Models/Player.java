package Marco4.Models;

import java.util.Date;

public class Player extends Person{
    private String nickname;
    private int number;
    private Double weight;
    private Double height;
    private Date birthDate;
    private String position;
    private String currentClub;
    private int callsCount;

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getCurrentClub() {
        return currentClub;
    }
    public void setCurrentClub(String currentClub) {
        this.currentClub = currentClub;
    }
    public int getCallsCount() {
        return callsCount;
    }
    public void setCallsCount(int callsCount) {
        this.callsCount = callsCount;
    }
}
