package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PostsRepository extends JpaRepository<Posts,Long> {//<Entitity class, PK타입> 이렇게 상속하면 CRUD메소드 자동 생성
}
