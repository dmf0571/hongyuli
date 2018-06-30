package com.hongyuli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @创建人 李弘昱
 * @创建时间 2018/6/29
 * @描述
 */
@Controller
public class PageController {

    /**
     * 打开首页
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    /**
     * 跳转到其他页面
     * @return
     */
    @RequestMapping("/{page}")
    public String showIndex(@PathVariable String page) {
        return page;
    }
}
