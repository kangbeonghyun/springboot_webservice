package com.jojoldu.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.
SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication//스프링 부트의 자동 설정, 스프링 bean읽기와 생성을 자동화, 여기서 부터 읽기 떄문에 항상 상단에 위치시키기.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);//내장 was 실행, 서버에 톰캣을 설피할 필요가 없고 스프링 부트로 만들어진 jar(실행 가능한 java 패키징 파일)로 실행하면 된다.
    }
}
