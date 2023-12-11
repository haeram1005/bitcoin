package com.basic.springbootbasic.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity // NOTE:클래스가 DB에 있는 테이블이란걸 의미 / 어노테이션 사용으로 인해서 jpa가 자동으로 테이블설정을 읽음
@Data // NOTE: 클래스안의 변수를 호출하기 위함 혹은 getter , setter 이용
public class Board {

    @Id //pk의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity = mysql , seq = oracle
    private Integer id;
    private String title;
    private String content;

}
