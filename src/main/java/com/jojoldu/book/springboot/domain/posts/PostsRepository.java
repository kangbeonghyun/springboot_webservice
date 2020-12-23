package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface PostsRepository extends JpaRepository<Posts,Long> {//<Entitity class, PK타입> 이렇게 상속하면 CRUD메소드 자동 생성

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
