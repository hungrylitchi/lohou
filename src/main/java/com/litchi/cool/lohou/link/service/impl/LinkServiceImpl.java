package com.litchi.cool.lohou.link.service.impl;

import com.litchi.cool.lohou.common.enums.RetCodeEnum;
import com.litchi.cool.lohou.common.exception.LohouException;
import com.litchi.cool.lohou.link.entity.LinkMap;
import com.litchi.cool.lohou.link.mapper.LinkMapMapper;
import com.litchi.cool.lohou.link.service.LinkService;
import com.litchi.cool.lohou.link.util.ShortLinkUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
@Slf4j
public class LinkServiceImpl implements LinkService {

    @Resource
    LinkMapMapper linkMapMapper;

    @Override
    public String getLongLinkByShortLink(String shortLink) {
        log.info("shortLink={}", shortLink);
        Long shortLinkId = ShortLinkUtil.convertLink2Id(shortLink);
        String longLink = linkMapMapper.selectLongLinkByShortLinkId(shortLinkId);
        log.info("longLink={}", longLink);
        if (!StringUtils.isEmpty(longLink)) {
            return longLink;
        }
        return "";
    }

    @Override
    public String createWithLongLink(String longLink) {
        log.info("createWithLongLink longLink={}", longLink);
        checkLongLink(longLink);
        Long shortLinkId = ShortLinkUtil.generateShortLinkId();
        String shortLink = ShortLinkUtil.convertId2Link(shortLinkId);
        LinkMap linkMap = new LinkMap();
        linkMap.setShortLink(shortLink);
        linkMap.setShortLinkId(shortLinkId);
        linkMap.setLongLink(longLink);
        Integer result = linkMapMapper.insertOne(linkMap);
        if (result == 1) {
            return shortLink;
        }
        throw new LohouException(RetCodeEnum.LINK_INSERT_FAILED);
    }

    private void checkLongLink(String longLink) {
        String s = longLink.toLowerCase();
        if (!s.startsWith("http://") && !s.startsWith("https://")) {
            throw new LohouException(RetCodeEnum.LINK_PROTOCOL_CHECK_FAILED);
        }
        if (s.contains(" ")) {
            throw new LohouException(RetCodeEnum.LINK_BLINK_CHECK_FAILED);
        }
    }

}
