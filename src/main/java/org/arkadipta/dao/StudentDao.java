package org.arkadipta.dao;

import org.arkadipta.entities.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDao {
    @Autowired
    private  SessionFactory sessionFactory;

    @Transactional
    public int save(Student s) {
        sessionFactory.getCurrentSession().persist(s);
        return 0;
    }
    @Transactional(readOnly = true)
    public Student view(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Transactional
    public Student update(Student s){
       return sessionFactory.getCurrentSession().merge(s);
    }

    @Transactional
    public void delete(int id){
        sessionFactory.getCurrentSession().remove(findById(id));
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public Student findById(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }
}
