package roguelike;


public class Location {
    String description;
    String[] enemies;
    String[] loot;
    int[] doorsTo;

    public Location(int quantity) {
        this.doorsTo = new int[quantity];
    }
}
