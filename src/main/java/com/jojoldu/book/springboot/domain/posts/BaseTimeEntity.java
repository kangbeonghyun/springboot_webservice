package com.jojoldu.book.springboot.domain.posts;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass//JPA 엔티티 클래스들이 BaseTimeEntity를 상속할 경우 필드(createdDate,modifiedDate)도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)//해당 클래스에 auditing 기능을 포함시킴
public abstract class BaseTimeEntity {//모든 엔티티의 상위 클래스

    @CreatedDate//엔티티 생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate//엔티티 변경될때
    private LocalDateTime modifiedDate;
}
