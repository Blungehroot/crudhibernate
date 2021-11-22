package com.crudhibernate.app.repository.postgresrepository;

import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.repository.LabelRepository;
import com.crudhibernate.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public class LabelRepositoryImpl implements LabelRepository {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session;

    @Override
    public Label getById(Integer id) {
        session = sessionFactory.openSession();
        return session.get(Label.class, id);
    }

    @Override
    public List<Label> getAll() {
        session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Label> cq = cb.createQuery(Label.class);
        Root<Label> rootEntry = cq.from(Label.class);
        CriteriaQuery<Label> all = cq.select(rootEntry);

        TypedQuery<Label> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Label save(Label label) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(label);
        session.getTransaction().commit();
        session.close();

        return label;
    }

    @Override
    public Label update(Label label) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(label);
        session.getTransaction().commit();
        session.close();

        return label;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Label label = session.get(Label.class, id);
        session.delete(label);
        session.getTransaction().commit();
    }
}
