package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)//Junit에 내장된 실행자 외 다른 실행자(여기선 spingrunner) 실행, 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)//웹에 징중할수 있는 어놑테이션

public class HelloControllerTest {

    @Autowired//스프링이 관리하는 bean 주입
    private MockMvc mvc;//스프링 mvc테스트의 시작점, 웹 API 테스트 시 활용

    @Test
    public void hello가_리턴된다()throws Exception{
        String hello="hello";

        mvc.perform(get("/hello"))//mockmvc를 통해 hello 주소로 http get요청
                .andExpect(status().isOk())//perform의 결과 및 http header의 status 검증(200,400 그런거)
                .andExpect(content().string(hello));//perform의 결과 및 응답 본문 내용 검증
    }

    @Test
    public void helloDto가_리턴된다()throws Exception{
        String name="hello";
        int amount=1000;


        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))//param은 문자열만 가
                .andExpect(status().isOk())//perform의 결과 및 http header의 status 검증(200,400 그런거)
                .andExpect(jsonPath("$.name",is(name)))//json 응답값을 필드별로 검증할 수 있는 메소드. $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount",is(amount)));//perform의 결과 및 응답 본문 내용 검증
    }

}
