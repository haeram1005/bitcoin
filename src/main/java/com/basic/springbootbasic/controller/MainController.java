package com.basic.springbootbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/market/market")
    public String marketMain() {
        return "/market/market";
    }

    @GetMapping("/exchange/exchange")
    public String exchangeMain() {
        return "/exchange/exch";
    }

    @GetMapping("/information/information")
    public String informationMain() {
        return "/information/info";
    }

    @GetMapping("/board/board")
    public String boardMain() {
        return "/board/boar";
    }

    @GetMapping("/signin/signin")
    public String signMain() {
        return "/signin/signin";
    }



    

}
