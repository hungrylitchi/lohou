package com.litchi.cool.lohou.link.util;

public class Bit62NumericConvertUtil
{
    /**
     * 在进制表示中的字符集合，0-Z分别用于表示最大为62进制的符号表示
     */
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
        'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
        'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String to62Bit(long number)
    {
        if (number < 0)
        {
            number = ((long)2 * 0x7fffffff) + number + 2;
        }
        char[] buf = new char[32];
        int charPos = 32;
        while ((number / 62) > 0)
        {
            buf[--charPos] = digits[(int)(number % 62)];
            number /= 62;
        }
        buf[--charPos] = digits[(int)(number % 62)];
        return new String(buf, charPos, (32 - charPos));
    }

    public static long toDecimalNumber(String number)
    {
        char[] charBuf = number.toCharArray();
        long result = 0, base = 1;

        for (int i = charBuf.length - 1; i >= 0; i-- )
        {
            int index = 0;
            for (int j = 0, length = digits.length; j < length; j++ )
            {
                // 找到对应字符的下标，对应的下标才是具体的数值
                if (digits[j] == charBuf[i])
                {
                    index = j;
                }
            }
            result += index * base;
            base *= 62;
        }
        return result;
    }

    public static void main(String[] args)
    {
        long time = 1000000001111L;
        System.out.println("16进制结果" + to62Bit(time));

    }


}
