package com.jojoldu.book.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter//클래스내 모든 필드의 getter 메소드 자동생성
@NoArgsConstructor//기본 생성자 자동 추가, public Post(){}와 같은 효과
@Entity//테이블과 링크될 클래스임을 명시, setter가 없는데 setter를 사용할 경우 코드의 명확한 구분이 어려워 사용하지 않고 대신 메소드를 추가한다.
public class Posts extends BaseTimeEntity{//DB 테이블과 매칭될 클래스

    @Id//pk 필드를 나타낸다.
    @GeneratedValue(strategy=GenerationType.IDENTITY)//pk 생성규칙, indentity옵션을 추가해야 auto increment활성화
    private Long id;

    @Column(length = 500,nullable=false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder//해당 클래스의 빌더 패턴 클래스 생성, 기본적으로 생성자를 통해서 db에 값을 집어넣는데 여기선 builder를 이용.(어차피 생성되는 시점에 값을 채워주는 역할 똑같으므로)
    public Posts(String title,String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }
}
