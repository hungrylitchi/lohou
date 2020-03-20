package com.litchi.cool.lohou.link.service;

public interface LinkService {

    String getLongLinkByShortLink(String sl);

    String createWithLongLink(String longLink);
}
