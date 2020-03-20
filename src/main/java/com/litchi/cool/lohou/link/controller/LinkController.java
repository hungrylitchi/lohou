package com.litchi.cool.lohou.link.controller;

import com.litchi.cool.lohou.common.base.BaseResponse;
import com.litchi.cool.lohou.link.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping()
@Slf4j
public class LinkController {

    @Autowired
    LinkService linkService;

    @GetMapping("{shortLink}")
    public void queryByShortLink(@PathVariable(value = "shortLink") String shortLink, HttpServletResponse response) throws IOException {
        String longLink = linkService.getLongLinkByShortLink(shortLink.trim());
        if (StringUtils.isEmpty(longLink)) {
            return;
        }
        response.sendRedirect(longLink);
    }

    @PostMapping("longLink")
    @ResponseBody
    public BaseResponse<String> create(@RequestParam(value = "longLink") String longLink) {
        String shortLink = linkService.createWithLongLink(longLink.trim());
        if (StringUtils.isEmpty(shortLink)) {
            return BaseResponse.fail();
        }
        return BaseResponse.success(shortLink);
    }

}
