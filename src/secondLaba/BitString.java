package secondLaba;


public class BitString {

    private long[] data = new long[1];
    private int len;

    public boolean get(int index) {
        return (data[index / Long.SIZE] << (index % Long.SIZE)) < 0;
    }

    public void reset(int index) {
        int longIndex = (len - index - 1) / Long.SIZE;
        int bitIndex = index % Long.SIZE;
        long mask = 1L << bitIndex;
        data[longIndex] &= ~mask;
    }

    public void set(int index) {
        int longIndex = index / Long.SIZE;
        int bitIndex = index % Long.SIZE;
        long mask = 1L << len - bitIndex - 1;
        if (longIndex >= 0) {
            expand(longIndex + 1);
        }
        data[longIndex] |= mask;
    }

    private void expand(int newLength) {
        long[] newData = new long[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (long l : data) {
            for (long mask = 1L << 63; mask != 0; mask >>>= 1) {
                res.append((l & mask) == 0 ? "0" : "1");
            }
            res.append(" ");
        }
        return res.toString();
    }

    public static void setTest() {
        var test = new BitString("");
        test.set(0);
        test.set(63);
        test.set(64);
        System.out.println(test);
    }


    public BitString(String string) {
        len = string.length();
        char[] chars = string.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '1') set(i);
            }
//        if ((len % Long.SIZE) > 0) {
//            data[len / Long.SIZE] >>>= (Long.SIZE - len);
//        }

    }


//        int i = 0;
//        while (!string.isEmpty()) {
//            int index = string.length() / Long.SIZE;
//            if (index > data.length - 1) {
//                expand(index + 1);
//            }
//            int end = index > 0 ? Long.SIZE : string.length();
//            data[i] = Long.parseLong(string.substring(0, end));
//            try {
//                string = string.substring(end, end + (string.length() % Long.SIZE));
//            } catch (IndexOutOfBoundsException e) {
//                break;
//            }
//            i++;
//        }
//
//    @Override
//    public String toString() {
//        return this.data.stream().map(Object::toString).collect(Collectors.joining(""));
//    }
//
//    private static void equate(BitString first, BitString second) {
//        int diff = first.data.size() - second.data.size();
//        if (first.data.size() > second.data.size()) {
//            for (; diff > 0; diff--) second.data.add(0, 0);
//        }
//        else {
//            for (; diff > 0; diff--) first.data.add(0, 0);
//        }
//    }
//
//    private void removeZeros() {
//        while (this.data.get(0) == 0) {
//            this.data.remove(0);
//        }
//    }
//
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
//
//    public static BitString and(BitString first, BitString second) {
//        equate(first, second);
//        BitString res = new BitString();
//        for (int i = 0; i < first.data.size(); i++) {
//            res.data.add((first.data.get(i) + second.data.get(i)) > 0 ? 1 : 0);
//        }
//        first.removeZeros();
//        return res;
//    }
//
//    public static BitString or(BitString first, BitString second) {
//        equate(first, second);
//        BitString res = new BitString();
//        for (int i = 0; i < first.data.size(); i++) {
//            res.data.add((first.data.get(i) * second.data.get(i)) == 1 ? 1 : 0);
//        }
//        res.removeZeros();
//        return res;
//    }
//
//    public BitString not() {
//        this.data.replaceAll(integer -> integer == 0 ? 1 : 0);
//        return this;
//    }
//
//    public static BitString xor(BitString first, BitString second) {
//        equate(first, second);
//        BitString res = new BitString();
//        for (int i = 0; i < first.data.size(); i++) {
//            res.data.add(!Objects.equals(first.data.get(i), second.data.get(i)) ? 1 : 0);
//        }
//        res.removeZeros();
//        return res;
//    }
//
//    public BitString set(int index, int bit) {
//        this.data.set(index, bit);
//        return this;
//    }

    public static void main(String[] args) {
        var first = new BitString("10101001");
        var second = new BitString("10111001010101010010100101010100101010101010101111111000000000101001001001010010001");
        var third = new BitString("1111111111111111111111111111111111111111111111111111111111111111000000");
        System.out.printf("First is %s\n", first);
        System.out.printf("Second is %s\n", second);
        System.out.printf("Third is %s\n", third);
        first.reset(3);
        second.reset(33);
        System.out.printf("First is %s\n", first);
        System.out.printf("Second is %s\n", second);
        System.out.printf("Third is %s\n", third);
//
//        setTest();
    }

}
