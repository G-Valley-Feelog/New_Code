package com.example.feelog.Service;

import com.example.feelog.DTO.BlogRequest;
import com.example.feelog.Entity.Blog;
import com.example.feelog.Entity.Member;
import com.example.feelog.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogService {

    @Autowired
    private final BlogRepository blogRepository;


    public Blog insertBlog(BlogRequest dto, Member member) {
        Blog blog = new Blog(dto,member);
        System.out.println("saved Blog Title : " + blog.getTitle());
        System.out.println("saved Member : " + member);
        return blogRepository.save(blog);
        //blog insert
    }

    public List<Blog> getBlogList(){
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "blogId"));
    }

    public Long getBlogCount(){
        return blogRepository.count();
    }

    public Blog getBlogById(Long blogId) {
        return blogRepository.getReferenceById(blogId);
    }

}
