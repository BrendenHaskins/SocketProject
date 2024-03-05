public class Boss {
    private int[] healthPool = new int[3];
    private String[] descPool = new String[3];

    public int health;
    public String desc;

    public Boss() {
        healthPool[0] = 100;
        healthPool[1] = 150;
        healthPool[2] = 200;

        descPool[0] = "Bronze Dragon";
        descPool[1] = "Ancient Gargoyle";
        descPool[2] = "Evil Eye";

        int random = (int)(Math.random() * 3);
        this.health = healthPool[random];
        this.desc = descPool[random];

    }
}
