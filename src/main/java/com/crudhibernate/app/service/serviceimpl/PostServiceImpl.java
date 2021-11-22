package com.crudhibernate.app.service.serviceimpl;

import com.crudhibernate.app.model.Post;
import com.crudhibernate.app.repository.postgresrepository.PostRepositoryImpl;
import com.crudhibernate.app.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    private PostRepositoryImpl postRepositoryImpl;

    public PostServiceImpl() {
        this.postRepositoryImpl = new PostRepositoryImpl();
    }

    @Override
    public Post getById(int id) {
        return postRepositoryImpl.getById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepositoryImpl.getAll();
    }

    @Override
    public Post save(Post post) {
        return postRepositoryImpl.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepositoryImpl.update(post);
    }

    @Override
    public void deleteById(int id) {
        postRepositoryImpl.deleteById(id);
    }
}
