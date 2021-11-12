package com.crudhibernate.app;

import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.model.Post;
import com.crudhibernate.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Label label = new Label();
        label.setId(1);
        label.setName("kekr");
        List<Label> labels = new ArrayList<>();
        labels.add(label);
        Post post = new Post();
        post.setName("kok");
        post.setContent("contety");
        post.setLabels(labels);
        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
