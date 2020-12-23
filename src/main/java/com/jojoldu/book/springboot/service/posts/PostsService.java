package com.jojoldu.book.springboot.service.posts;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import javafx.geometry.Pos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.List;
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional //db와 커넥션이 있는 중요한 메소드들은 이걸 다 걸어야 한다.
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글 없음. id="+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글 없음. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()//postsrepository에서 넘어온 posts의 스트림을 map을통해 postslistresponsedto->list로 반환하는 것.
                .map(PostsListResponseDto::new)//람다식, 원래는 .map(posts->new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글 없음 id="+id));
        postsRepository.delete(posts);
    }


}
