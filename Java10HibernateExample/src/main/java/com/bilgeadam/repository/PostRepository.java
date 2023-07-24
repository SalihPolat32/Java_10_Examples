package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Post;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class PostRepository implements ICrud<Post> {

    Session session;
    Transaction transaction;

    @Override
    public Post save(Post post) {

        try {

            session = HibernateUtility.getSessionFactory().openSession();

            System.out.println("Oturum Açıldı");

            transaction = session.beginTransaction();

            session.save(post);

            transaction.commit();

            System.out.println("Kayıt Başarılı");

        } catch (Exception e) {

            System.out.println("Bir Hata Oluştu: " + e);

            transaction.rollback();

        }finally {

            System.out.println("Oturum Kapatılıyor...");

            session.close();

        }
        return post;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    public Optional<User> findByUserWithPostId(Long postId) {

        String hql = "SELECT u FROM User AS u JOIN Post AS p ON u.id = p.id WHERE p.id = " + postId;

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

        User user = null;

        try {

            user = typedQuery.getSingleResult();

        } catch (Exception e) {

            System.out.println("Kullanıcı Bulunamadı!!!");

        }

        return Optional.ofNullable(user);
    }
}