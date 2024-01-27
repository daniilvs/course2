package ex_3_2_1;

public interface Actable {
    enum Result {CONTINUE, NEXT_ROOM, EXIT}
    Result act(Hero hero);
    String getDescription();
}
