package ru.java.web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.java.web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void save(User user) {
        if (entityManager.contains(user)) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
