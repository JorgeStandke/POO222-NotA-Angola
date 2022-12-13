package module_angola;

public class Technical extends Person{
    private String nickname;
    public Technical(String name, int age, String nickname) {
		super(name, age);
		this.nickname = nickname;
	}
	public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
