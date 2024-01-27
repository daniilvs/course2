package ex_2;


public class BitString {

    private long[] data;
    private int len;

    public BitString(String string) {
        len = string.length();
        this.data = new long[1];
        if (len / Long.SIZE > 0) {
            this.expand(len / Long.SIZE + 1);
        }
        char[] chars = string.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '1') set(i);
        }
    }

    private BitString(int len) {
        this.len = len;
        this.data = new long[len / Long.SIZE + 1];
    }

    private void expand(int newLength) {
        long[] newData = new long[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

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
        int len = Math.min(this.len, second.len);
        BitString res = new BitString(len);
        for (int i = 0; i < res.data.length; i++) {
            res.data[i] = this.data[i] & second.data[i];
        }

        return res;
    }

    public BitString or(BitString second) {
        int len = Math.max(this.len, second.len);
        int lim = Math.min(this.len, second.len) / Long.SIZE + 1;
        BitString res = new BitString(len);
        int i;
        for (i = 0; i < lim; i++) {
            res.data[i] = this.data[i] | second.data[i];
        }
        for (; i < this.data.length; i++) {
            res.data[i] = this.data[i];
        }
        for (; i < second.data.length; i++) {
            res.data[i] = second.data[i];
        }

        return res;
    }


    public BitString not() {
        int n = 64 - (len % Long.SIZE);
        long mask = -1;
        for (int i = 0; i < data.length; i++) {
            data[i] = ~data[i];
        }
        data[len / Long.SIZE] &= (mask << n);

        return this;
    }


    public BitString xor(BitString second) {
        int len = Math.max(this.len, second.len);
        int lim = Math.min(this.len, second.len) / Long.SIZE + 1;
        BitString res = new BitString(len);
        int i;
        for (i = 0; i < lim; i++) {
            res.data[i] = this.data[i] ^ second.data[i];
        }
        for (; i < this.data.length; i++) {
            res.data[i] = this.data[i];
        }
        for (; i < second.data.length; i++) {
            res.data[i] = second.data[i];
        }

        return res;
    }

    public String toStringXD() {
        StringBuilder res = new StringBuilder();
        var lim = data.length * 64;
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


    public static void main(String[] args) {
        var first = new BitString("10101001");
        var second = new BitString("11100000000000000000000000000000000000000000000000000000000000010100000000001");
        var third = new BitString("1111111111111111111111111111111111111111111111111111111111111111000000");
//        System.out.printf("First is %s\n", first);
//        System.out.printf("Second is %s\n", second);
//        System.out.printf("Third is %s\n", third);
//        first.reset(2);
//        second.reset(2);
//        third.set(70);
        System.out.printf("First  is %s\n", first);
        System.out.printf("Second is %s\n", second);
//        System.out.printf("Third  is %s\n", third);

        System.out.printf("Result is %s\n", first.xor(second));
        System.out.printf("~first is %s\n", first.not());
        System.out.printf(" All bits %s\n", first.toStringXD());

    }

}
