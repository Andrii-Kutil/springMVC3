package com.gmail.kutilandrej.dao;

import com.gmail.kutilandrej.entity.Human;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HumanDaoImpl implements com.gmail.kutilandrej.dao.HumanDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Human> getAllHumans() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Human", Human.class).getResultList();
  }

  @Override
  public void saveHuman(Human human) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(human);
  }

  @Override
  public Human getHuman(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Human.class, id);
  }

  @Override
  public void deleteHuman(int id) {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("delete from Human as h where h.id=:id");
    query.setParameter("id", id);
    query.executeUpdate();
  }
}
