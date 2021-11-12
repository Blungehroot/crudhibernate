package com.crudhibernate.app;

import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.model.Post;
import com.crudhibernate.app.repository.postgresrepository.LabelRepositoryImpl;
import com.crudhibernate.app.repository.postgresrepository.PostRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Label label = new Label();
        label.setName("kek1");
        label.setId(7);

        Label label1 = new Label();
        label1.setName("kek1");
        label1.setId(6);
        List<Label> labels = new ArrayList<>();
        labels.add(label);
        labels.add(label1);
        Post post = new Post();
        post.setName("Poster");
        post.setContent("kldsk");
        post.setLabels(labels);
        LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        //System.out.println(postRepository.save(post));
        postRepository.deleteById(5);


    }
}
