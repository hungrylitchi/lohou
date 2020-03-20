package com.litchi.cool.lohou.link.mapper;

import com.litchi.cool.lohou.link.entity.LinkMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkMapMapper {

    LinkMap selectOneByShortLink(@Param("shortLink") String shortLink);

    String selectLongLinkByShortLink(@Param("shortLink") String shortLink);

    String selectLongLinkByShortLinkId(@Param("shortLinkId") Long shortLinkId);

    Integer insertOne(@Param("shortLinkId") Long shortLinkId, @Param("shortLink") String shortLink, @Param("longLink") String longLink);

    Integer insertOne(LinkMap linkMap);

}
