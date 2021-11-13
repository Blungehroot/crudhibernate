package com.crudhibernate.app.service.serviceimpl;

import com.crudhibernate.app.model.Post;
import com.crudhibernate.app.repository.PostRepository;
import com.crudhibernate.app.repository.postgresrepository.PostRepositoryImpl;
import com.crudhibernate.app.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    private PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public Post getById(int id) {
        return postRepository.getById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.update(post);
    }

    @Override
    public void deleteById(int id) {
        postRepository.deleteById(id);
    }
}
