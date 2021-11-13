package com.crudhibernate.app.controller;


import com.crudhibernate.app.model.Post;
import com.crudhibernate.app.model.Writer;
import com.crudhibernate.app.service.LabelService;
import com.crudhibernate.app.service.PostService;
import com.crudhibernate.app.service.WriterService;
import com.crudhibernate.app.service.serviceimpl.LabelServiceImpl;
import com.crudhibernate.app.service.serviceimpl.PostServiceImpl;
import com.crudhibernate.app.service.serviceimpl.WriterServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WriterController {
    private final WriterService writerService;
    private final PostService postService;
    private final LabelService labelService;

    public WriterController() {
        writerService = new WriterServiceImpl();
        postService = new PostServiceImpl();
        labelService = new LabelServiceImpl();
    }

    private List<Post> getListPostsById(String ids) {
        List<Post> allExistPosts = postService.getAll();
        List<Post> temp;
        String[] idsArray = ids.split(",");
        int size = idsArray.length;
        Long[] intIds = new Long[size];

        for (int i = 0; i < size; i++) {
            intIds[i] = Long.parseLong(idsArray[i]);
        }

        List<Long> listOfIds = Arrays.asList(intIds);
        temp = allExistPosts
                .stream()
                .filter(post -> listOfIds.contains(post.getId()))
                .collect(Collectors.toList());
        return temp;
    }

    public List<Writer> getAll() {
        return writerService.getAll();
    }

    public Writer getById(int id) {
        if (writerService.getById(id).getId() == null) {
            try {
                throw new Exception("Writer with id = " + id + " is not present");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return writerService.getById(id);
    }

    public Writer create(String name, String postsIds) {
        Writer writer = new Writer();
        writer.setName(name);
        writer.setPosts(getListPostsById(postsIds));
        return writerService.save(writer);
    }

    public Writer update(int id, String name, String postsIds) {
        Writer writer = new Writer();
        writer.setId(id);
        writer.setName(name);
        writer.setPosts(null);
        writer.setPosts(getListPostsById(postsIds));
        return writerService.update(writer);
    }

    public void delete(int id) {
        if (writerService.getById(id).getId() == null) {
            try {
                throw new Exception("Writer with id = " + id + " is not present and cannot be deleted");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        writerService.deleteById(id);
    }
}
