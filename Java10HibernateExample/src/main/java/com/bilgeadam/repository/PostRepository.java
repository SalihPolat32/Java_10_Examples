package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Post;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}