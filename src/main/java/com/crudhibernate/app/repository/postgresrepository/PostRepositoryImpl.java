package com.crudhibernate.app.repository.postgresrepository;

import com.crudhibernate.app.model.Post;
import com.crudhibernate.app.repository.PostRepository;
import com.crudhibernate.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session;

    @Override
    public Post getById(Integer id) {
        session = sessionFactory.openSession();
        return session.get(Post.class, id);
    }

    @Override
    public List<Post> getAll() {
        session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> rootEntry = cq.from(Post.class);
        CriteriaQuery<Post> all = cq.select(rootEntry);

        TypedQuery<Post> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Post save(Post post) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        sessionFactory.close();

        return post;
    }

    @Override
    public Post update(Post post) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
        sessionFactory.close();

        return post;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Post post = new Post();
        post.setId(id);
        post.setLabels(null);
        session.delete(post);
        session.getTransaction().commit();
    }
}
