package ex_3_2;

public abstract class Item implements Actables{
    protected String name;
    protected int hpBuff;
    protected int dmgBuff;
    protected int rate;
    protected int quantity;
    protected boolean back;
    protected String dice;

    public Item(String name, int hpBuff, int dmgBuff, int rate, int quantity, boolean back, String dice) {
        this.name = name;
        this.hpBuff = hpBuff;
        this.dmgBuff = dmgBuff;
        this.rate = rate;
        this.quantity = quantity;
        this.back = back;
        this.dice = dice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", hpBuff='" + hpBuff + '\'' +
                ", rate=" + rate +
                ", quantity=" + quantity +
                ", back=" + back +
                ", dice='" + dice + '\'' +
                '}';
    }


}
