package com.crudhibernate.app.service;


import com.crudhibernate.app.model.Post;

import java.util.List;

public interface PostService {
    Post getById(int id);

    List<Post> getAll();

    Post save(Post post);

    Post update(Post post);

    void deleteById(int id);
}
