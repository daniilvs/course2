package secondLaba;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BitString {
    private final ArrayList<Integer> data = new ArrayList<Integer>(List.of(0));

    public BitString() {}

    public BitString(String string) {
        var charArr = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            this.data.add(Character.getNumericValue(charArr[i]));
        }
    }

    @Override
    public String toString() {
        return this.data.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    private static void equate(BitString first, BitString second) {
        int diff = first.data.size() - second.data.size();
        if (first.data.size() > second.data.size()) {
            for (; diff > 0; diff--) second.data.add(0, 0);
        }
        else {
            for (; diff > 0; diff--) first.data.add(0, 0);
        }
    }

    private void removeZeros() {
        while (this.data.get(0) == 0) {
            this.data.remove(0);
        }
    }

//    public BitString and(BitString second) {
//        equate(this, second);
//        for (int i = 0; i < this.data.size(); i++) {
//            if ((this.data.get(i) + second.data.get(i)) > 0) {
//                this.data.set(i, 1);
//            }
//        }
//        this.removeZeros();
//        return this;
//    }
//
//    public BitString or(BitString second) {
//        equate(this, second);
//        for (int i = 0; i < this.data.size(); i++) {
//            if ((this.data.get(i) * second.data.get(i)) == 1) {
//                this.data.set(i, 1);
//            }
//            else {
//                this.data.set(i, 0);
//            }
//        }
//        this.removeZeros();
//        return this;
//    }

    public static BitString and(BitString first, BitString second) {
        equate(first, second);
        BitString res = new BitString();
        for (int i = 0; i < first.data.size(); i++) {
            if ((first.data.get(i) + second.data.get(i)) > 0) {
                res.data.add(1);
            }
            else {
                res.data.add(0);
            }
        }
        first.removeZeros();
        return res;
    }

    public static BitString or(BitString first, BitString second) {
        equate(first, second);
        BitString res = new BitString();
        for (int i = 0; i < first.data.size(); i++) {
            if ((first.data.get(i) * second.data.get(i)) == 1) {
                res.data.add(1);
            }
            else {
                res.data.add(0);
            }
        }
        res.removeZeros();
        return res;
    }

    public static void main(String[] args) {
        var first = new BitString("10101001");
        var second = new BitString("0010111");
        equate(first, second);
        System.out.println(first);
        System.out.println(second);

        System.out.println(or(first, second));
        System.out.println(and(first, second));

    }

}
