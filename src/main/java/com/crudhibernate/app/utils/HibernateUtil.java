package com.crudhibernate.app.utils;

import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.model.Post;
import com.crudhibernate.app.model.Writer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = createSessionFactory();

    public static SessionFactory createSessionFactory() {
        try {
            Configuration configuration = new Configuration();
                    ;
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Label.class);
            configuration.addAnnotatedClass(Post.class);
            configuration.addAnnotatedClass(Writer.class);
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
