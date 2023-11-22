package first;

public class Tasks {
    static String zodiac(int day, int month) {
        String[] signs = new String[]{"Козерог", "Водолей", "Рыбы", "Овен", "Телец", "Близнецы", "Рак", "Лев", "Дева", "Весы", "Скорпион", "Стрелец", "Козерог"};
        int i = (day <= 21) ? month : (month + 1);
        return signs[i-1];
    }
}
