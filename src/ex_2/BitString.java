package ex_2;


public class BitString {

    private long[] data = new long[1];
    private int len;

    public boolean get(int index) {
        if (index / Long.SIZE > 0) {
            expand(index / Long.SIZE + 1);
        }
        return (data[index / Long.SIZE] << (index % Long.SIZE)) < 0;
    }

    public void reset(int index) {
        int longIndex = index / Long.SIZE;
        int bitIndex = index % Long.SIZE;
        long mask = 1L << Long.SIZE - bitIndex - 1;
        data[longIndex] &= ~mask;
    }

    public void set(int index) {
        if (index >= len) {
            len = index + 1;
        }
        int longIndex = index / Long.SIZE;
        int bitIndex = index % Long.SIZE;
        long mask = 1L << Long.SIZE - bitIndex - 1;
        if (longIndex > 0) {
            expand(longIndex + 1);
        }
        data[longIndex] |= mask;
    }

    public BitString and(BitString second) {
        BitString res = new BitString("");
        int lim = Math.max(this.len, second.len);
        res.expand(lim / Long.SIZE + 1);
        res.len = lim;
        for (int i = 0; i < lim; i++) {
            if (this.get(i) && second.get(i)) {
                res.set(i);
            }
        }
        return res;
    }


    public BitString or(BitString second) {
        BitString res = new BitString("");
        int lim = Math.max(this.len, second.len);
        res.expand(lim / Long.SIZE + 1);
        res.len = lim;
        for (int i = 0; i < lim; i++) {
            if (this.get(i) || second.get(i)) {
                res.set(i);
            }
        }
        return res;
    }

    public BitString not() {
        for (int i = 0; i < len; i++) {
            if (this.get(i)) {
                this.reset(i);
            } else {
                this.set(i);
            }
        }
        return this;
    }


    public BitString xor(BitString second) {
        BitString res = new BitString("");
        int lim = Math.max(this.len, second.len);
        res.expand(lim / Long.SIZE + 1);
        res.len = lim;
        for (int i = 0; i < lim; i++) {
            if (this.get(i) != second.get(i)) {
                res.set(i);
            }
        }
        return res;
    }

    private void expand(int newLength) {
        long[] newData = new long[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        var lim = len;
        for (long l : data) {
            for (long mask = 1L << 63; mask != 0; mask >>>= 1) {
                res.append(((l & mask) == 0 || (l == 0)) ? "0" : "1");
                lim--;
                if (lim <= 0) break;
            }
            res.append(" ");
        }
        return res.toString();
    }


    public BitString(String string) {
        len = string.length();
        if (len / Long.SIZE > 0) {
            this.expand(len / Long.SIZE + 1);
        }
        char[] chars = string.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '1') set(i);
        }
    }

    public static void main(String[] args) {
        var first = new BitString("10101001");
        var second = new BitString("11100000000000000000000000000000000000000000000000000000000000010100000000001");
        var third = new BitString("1111111111111111111111111111111111111111111111111111111111111111000000");
        System.out.printf("First is %s\n", first);
        System.out.printf("Second is %s\n", second);
        System.out.printf("Third is %s\n", third);
        first.reset(2);
        second.reset(2);
        third.set(70);
        System.out.printf("First is %s\n", first);
        System.out.printf("Second is %s\n", second);
        System.out.printf("Third is %s\n", third);

        System.out.println(first.xor(second));

    }

}
