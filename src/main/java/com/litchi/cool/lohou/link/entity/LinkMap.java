package com.litchi.cool.lohou.link.entity;

import lombok.Data;

import java.util.Date;


@Data
public class LinkMap {

    /**
     * 主键
     **/
    private Long id;

    /**
     * 短链id
     **/
    private Long shortLinkId;

    /**
     * 短链
     **/
    private String shortLink;

    /**
     * 长链
     **/
    private String longLink;

    /**
     * 创建时间
     **/
    private Date createTime;

    /**
     * 修改时间
     **/
    private Date modifyTime;
}