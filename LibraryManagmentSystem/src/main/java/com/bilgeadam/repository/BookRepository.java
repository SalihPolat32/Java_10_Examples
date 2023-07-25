package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Book;
import com.bilgeadam.repository.enums.EBookType;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class BookRepository implements ICrud<Book> {

    Session session;
    Transaction transaction;

    @Override
    public Book save(Book book) {

        try {

            session = HibernateUtility.getSESSION_FACTORY().openSession();

            transaction = session.beginTransaction();

            System.out.println("Oturum Açıldı");

            session.save(book);

            transaction.commit();

            System.out.println("Kayıt Başarılı");

        } catch (Exception e) {

            e.printStackTrace();

            transaction.rollback();

        } finally {

            System.out.println("Oturum Kapandı");

            session.close();

        }
        return book;
    }

    @Override
    public Book update(Book book) {

        try {

            session = HibernateUtility.getSESSION_FACTORY().openSession();

            transaction = session.beginTransaction();

            System.out.println("Oturum Açıldı");

            session.update(book);

            transaction.commit();

            System.out.println("Güncelleme Başarılı");

        } catch (Exception e) {

            e.printStackTrace();

            transaction.rollback();

        } finally {

            System.out.println("Oturum Kapandı");

            session.close();

        }
        return book;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    public List<Book> getBooksByType(EBookType type) {

        String hql = "SELECT b FROM Book AS b WHERE b.bookType =: x";

        session = HibernateUtility.getSESSION_FACTORY().openSession();

        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);

        typedQuery.setParameter("x", type);

        List<Book> list = typedQuery.getResultList();

        session.close();

        return list;
    }

    public List<Book> getBooksByType() {

        String hql = "SELECT b FROM Book AS b WHERE b.bookType = 'NOVEL'";

        session = HibernateUtility.getSESSION_FACTORY().openSession();

        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);

        List<Book> list = typedQuery.getResultList();

        session.close();

        return list;
    }

    public List<Book> getBooksWithAuthorNameStartWith(String value) {

        String hql = "SELECT b FROM Book AS b WHERE b.author.firstName LIKE '" + value + "%'";

        session = HibernateUtility.getSESSION_FACTORY().openSession();

        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);

        List<Book> list = typedQuery.getResultList();

        session.close();

        return list;
    }


    public List<Book> getBooksByTypeWithCriteria(EBookType type) {

        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> root = criteriaQuery.from(Book.class);

        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("bookType"), type));

        List<Book> list = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.close();

        return list;
    }

    public List<Book> getBooksByTypeNamedQuery(EBookType type) {

        session = HibernateUtility.getSESSION_FACTORY().openSession();

        TypedQuery<Book> typedQuery = session.createNamedQuery("findByBookType", Book.class);

        typedQuery.setParameter("myType", type);

        List<Book> list = typedQuery.getResultList();

        session.close();

        return list;
    }

    public Optional<Book> findByTitle(String title) {

        String hql = "SELECT b FROM Book AS b WHERE b.title =: x";

        session = HibernateUtility.getSESSION_FACTORY().openSession();

        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);

        typedQuery.setParameter("x", title);

        Book book = null;

        try {

            book = typedQuery.getSingleResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();

        }

        return Optional.ofNullable(book);
    }

    // Listeli Çözüm
    public List<Book> findByTitle2(String title) {

        String hql = "SELECT b FROM Book AS b WHERE b.title =: x";

        session = HibernateUtility.getSESSION_FACTORY().openSession();

        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);

        typedQuery.setParameter("x", title);

//        typedQuery.setMaxResults(1);

        List<Book> list = typedQuery.getResultList();

        session.close();

        return list;
    }

    public List<Book> findByTitleWithCrieria(String title) {

        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> root = criteriaQuery.from(Book.class);

        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("title"), title));

        List<Book> list = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.close();

        return list;
    }

    public List<Object[]> findByTitleWithCrieria2(String title) {

        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

        Root<Book> root = criteriaQuery.from(Book.class);

        criteriaQuery.multiselect(root.get("title"), root.get("author").get("firstName")).where(criteriaBuilder.equal(root.get("title"), title));

        List<Object[]> list = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.close();

        return list;
    }

    public List<Object[]> getBooksCountByBookType() {

        String hql = "SELECT b.bookType, COUNT(*) FROM Book AS b GROUP BY bookType";

        session = HibernateUtility.getSESSION_FACTORY().openSession();

        TypedQuery<Object[]> typedQuery = session.createQuery(hql, Object[].class);

        List<Object[]> list = typedQuery.getResultList();

        session.close();

        return list;
    }

    public List<Object[]> getBooksCountByBookTypeWithCriteria() {

        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

        Root<Book> root = criteriaQuery.from(Book.class);

        criteriaQuery.multiselect(root.get("bookType"), criteriaBuilder.count(root)).groupBy(root.get("bookType"));

        List<Object[]> list = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.close();

        return list;
    }

    public List<Object[]> getBooksCountByBookTypeWithNamedQuery() {

        session = HibernateUtility.getSESSION_FACTORY().openSession();

        TypedQuery<Object[]> typedQuery = session.createNamedQuery("countBookType", Object[].class);

        List<Object[]> list = typedQuery.getResultList();

        session.close();

        return list;
    }
}