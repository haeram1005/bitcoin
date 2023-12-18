package com.basic.springbootbasic;

import com.basic.springbootbasic.domain.MarketItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class MaketsTest {

    //마켓 현재가 조회
    @Test
    public void CoinPrice() throws IOException, InterruptedException, JSONException {
        MarketItem marketItem = new MarketItem();
        System.out.println(marketItem.getMarket());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.upbit.com/v1/ticker?markets="+marketItem.getMarket()))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONArray(response.body());
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        System.out.println("reponse" + response.body());
        System.out.println("array" + jsonArray);
        System.out.println("object" + jsonObject);
        System.out.println("결과 출력 " +jsonObject.getInt("trade_price"));
    }


    //마켓 종목을 이용한 현재가 조회
    @Test
    void CoinNameAndCoinPrice() throws IOException, InterruptedException {
    }

    //마켓 종목 조회
    @Test
    void CoinName() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.upbit.com/v1/market/all?isDetails=true"))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONArray(response.body());
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        List<MarketItem> marketItemList =new Gson().fromJson(jsonArray.toString(), new TypeToken<List<MarketItem>>() {}.getType());

        //코인 코드명
        List<String> marketsList = marketItemList.stream().map(MarketItem::getMarket).collect(Collectors.toList());
        String market = String.join(",",marketsList);
        //코인 한글명
        List<String> korean_nameList = marketItemList.stream().map(MarketItem::getKorean_name).collect(Collectors.toList());
        String korean_name = String.join(",",korean_nameList);
        //코인 영문명
        List<String> english_nameList = marketItemList.stream().map(MarketItem::getEnglish_name).collect(Collectors.toList());
        String english_name = String.join(",",english_nameList);

//        for(MarketItem marketItem : marketItemList){
//            markets.append(marketItem.getMarket());
//            System.out.println("markets : " + markets);
//        }


    }
}
