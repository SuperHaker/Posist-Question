public class IdGenerator extends AbstractHashFunction {

    private static long INT_MASK = 0x00000000ffffffffL;

    private static long BYTE_MASK = 0x00000000000000ffL;

    private static long rot(long val, int pos) {
        return ((Integer.rotateLeft((int) (val & INT_MASK), pos)) & INT_MASK);
    }

    public int hash(byte[] key, int nbytes, int initval) {
        int length = nbytes;
        long a, b, c;
        a = b = c = (0x00000000deadbeefL + length + initval) & INT_MASK;
        int offset = 0;
        for (; length > 12; offset += 12, length -= 12) {
            a = (a + (key[offset + 0] & BYTE_MASK)) & INT_MASK;
            a = (a + (((key[offset + 1] & BYTE_MASK) << 8) & INT_MASK))
                    & INT_MASK;
            a = (a + (((key[offset + 2] & BYTE_MASK) << 16) & INT_MASK))
                    & INT_MASK;
            a = (a + (((key[offset + 3] & BYTE_MASK) << 24) & INT_MASK))
                    & INT_MASK;
            b = (b + (key[offset + 4] & BYTE_MASK)) & INT_MASK;
            b = (b + (((key[offset + 5] & BYTE_MASK) << 8) & INT_MASK))
                    & INT_MASK;
            b = (b + (((key[offset + 6] & BYTE_MASK) << 16) & INT_MASK))
                    & INT_MASK;
            b = (b + (((key[offset + 7] & BYTE_MASK) << 24) & INT_MASK))
                    & INT_MASK;
            c = (c + (key[offset + 8] & BYTE_MASK)) & INT_MASK;
            c = (c + (((key[offset + 9] & BYTE_MASK) << 8) & INT_MASK))
                    & INT_MASK;
            c = (c + (((key[offset + 10] & BYTE_MASK) << 16) & INT_MASK))
                    & INT_MASK;
            c = (c + (((key[offset + 11] & BYTE_MASK) << 24) & INT_MASK))
                    & INT_MASK;

            a = (a - c) & INT_MASK;
            a ^= rot(c, 4);
            c = (c + b) & INT_MASK;
            b = (b - a) & INT_MASK;
            b ^= rot(a, 6);
            a = (a + c) & INT_MASK;
            c = (c - b) & INT_MASK;
            c ^= rot(b, 8);
            b = (b + a) & INT_MASK;
            a = (a - c) & INT_MASK;
            a ^= rot(c, 16);
            c = (c + b) & INT_MASK;
            b = (b - a) & INT_MASK;
            b ^= rot(a, 19);
            a = (a + c) & INT_MASK;
            c = (c - b) & INT_MASK;
            c ^= rot(b, 4);
            b = (b + a) & INT_MASK;
        }

        // -------------------------------- last block: affect all 32 bits of
        // (c)
        switch (length) { // all the case statements fall through
            case 12:
                c = (c + (((key[offset + 11] & BYTE_MASK) << 24) & INT_MASK))
                        & INT_MASK;
            case 11:
                c = (c + (((key[offset + 10] & BYTE_MASK) << 16) & INT_MASK))
                        & INT_MASK;
            case 10:
                c = (c + (((key[offset + 9] & BYTE_MASK) << 8) & INT_MASK))
                        & INT_MASK;
            case 9:
                c = (c + (key[offset + 8] & BYTE_MASK)) & INT_MASK;
            case 8:
                b = (b + (((key[offset + 7] & BYTE_MASK) << 24) & INT_MASK))
                        & INT_MASK;
            case 7:
                b = (b + (((key[offset + 6] & BYTE_MASK) << 16) & INT_MASK))
                        & INT_MASK;
            case 6:
                b = (b + (((key[offset + 5] & BYTE_MASK) << 8) & INT_MASK))
                        & INT_MASK;
            case 5:
                b = (b + (key[offset + 4] & BYTE_MASK)) & INT_MASK;
            case 4:
                a = (a + (((key[offset + 3] & BYTE_MASK) << 24) & INT_MASK))
                        & INT_MASK;
            case 3:
                a = (a + (((key[offset + 2] & BYTE_MASK) << 16) & INT_MASK))
                        & INT_MASK;
            case 2:
                a = (a + (((key[offset + 1] & BYTE_MASK) << 8) & INT_MASK))
                        & INT_MASK;
            case 1:
                a = (a + (key[offset + 0] & BYTE_MASK)) & INT_MASK;
                break;
            case 0:
                return (int) (c & INT_MASK);
        }
        c ^= b;
        c = (c - rot(b, 14)) & INT_MASK;
        a ^= c;
        a = (a - rot(c, 11)) & INT_MASK;
        b ^= a;
        b = (b - rot(a, 25)) & INT_MASK;
        c ^= b;
        c = (c - rot(b, 16)) & INT_MASK;
        a ^= c;
        a = (a - rot(c, 4)) & INT_MASK;
        b ^= a;
        b = (b - rot(a, 14)) & INT_MASK;
        c ^= b;
        c = (c - rot(b, 24)) & INT_MASK;

        return (int) (c & INT_MASK);
    }

}

abstract class AbstractHashFunction implements HashFunction {

    public int hash(byte[] bytes, int initval) {
        return hash(bytes, bytes.length, initval);
    }

    public int hash(byte[] bytes) {
        return hash(bytes, bytes.length, -1);
    }

}

interface HashFunction {

    int hash(byte[] bytes);

    int hash(byte[] bytes, int initval);

    int hash(byte[] bytes, int length, int initval);

}
