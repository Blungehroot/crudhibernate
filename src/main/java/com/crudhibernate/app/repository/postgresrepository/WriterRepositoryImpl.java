package com.crudhibernate.app.repository.postgresrepository;

import com.crudhibernate.app.model.Writer;
import com.crudhibernate.app.repository.WriterRepository;
import com.crudhibernate.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {
    private static SessionFactory sessionFactory;
    private static Session session;

    public WriterRepositoryImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Writer getById(Integer id) {
        session = sessionFactory.openSession();
        return session.get(Writer.class, id);
    }

    @Override
    public List<Writer> getAll() {
        session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Writer> cq = cb.createQuery(Writer.class);
        Root<Writer> rootEntry = cq.from(Writer.class);
        CriteriaQuery<Writer> all = cq.select(rootEntry);

        TypedQuery<Writer> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Writer save(Writer writer) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(writer);
        session.getTransaction().commit();
        sessionFactory.close();

        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(writer);
        session.getTransaction().commit();
        sessionFactory.close();

        return writer;
    }

    @Override
    public void deleteById(Integer id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Writer writer = new Writer();
        writer.setId(id);
        writer.setPosts(null);
        session.delete(writer);
        session.getTransaction().commit();
    }
}