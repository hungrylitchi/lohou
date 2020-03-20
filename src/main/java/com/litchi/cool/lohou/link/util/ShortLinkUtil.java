package com.litchi.cool.lohou.link.util;

import org.springframework.util.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class ShortLinkUtil {

    private static final Integer END_POINT = 9900;
    private static final Integer START_POINT = 1000;
    private volatile static AtomicInteger shortIdTail = new AtomicInteger(START_POINT);

    private ShortLinkUtil() {
    }

    public static Long generateShortLinkId() {
        Long ShortId = System.currentTimeMillis() + shortIdTail.incrementAndGet();
        if (shortIdTail.get() > END_POINT) {
            resetShortIdTail();
        }
        return ShortId;
    }

    private synchronized static void resetShortIdTail() {
        if (shortIdTail.get() > END_POINT) {
            shortIdTail.set(START_POINT);
        }
    }

    public static String convertId2Link(Long shortLinkId) {
        if (shortLinkId == null) {
            return null;
        }
        return Bit62NumericConvertUtil.to62Bit(shortLinkId);
    }

    public static Long convertLink2Id(String shortLink) {
        if (StringUtils.isEmpty(shortLink)) {
            return null;
        }
        return Bit62NumericConvertUtil.toDecimalNumber(shortLink);
    }


}
