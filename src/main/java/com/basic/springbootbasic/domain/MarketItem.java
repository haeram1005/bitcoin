package com.basic.springbootbasic.domain;

public class MarketItem {
    private String market;
    private String korean_name;
    private String english_name;

    @Override
    public String toString() {
        return "MarketPriceItem{" +
                "market='" + market + '\'' +
                ", korean_name='" + korean_name + '\'' +
                ", english_name='" + english_name + '\'' +
                '}';
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getKorean_name() {
        return korean_name;
    }

    public void setKorean_name(String korean_name) {
        this.korean_name = korean_name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }
}
