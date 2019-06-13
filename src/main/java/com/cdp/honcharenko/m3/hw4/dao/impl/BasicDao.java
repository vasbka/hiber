package com.cdp.honcharenko.m3.hw4.dao.impl;

import com.cdp.honcharenko.m3.hw4.HibernateSessionFactoryUtil;
import com.cdp.honcharenko.m3.hw4.entity.Enrollee;
import com.cdp.honcharenko.m3.hw4.entity.EntityId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public abstract class BasicDao<E> {
    public E findById(int id, Class<E> type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaQuery<E> criteriaQuery = getCriteriaQueryWithWhereConditionByParamNameAndValue(type, "id", id, session);
        Query<E> query = session.createQuery(criteriaQuery).setCacheable(true);
        E result = query.getSingleResult();
        HibernateSessionFactoryUtil.closeResources(session, transaction);
        return result;
    }

    public int create(E object) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        HibernateSessionFactoryUtil.closeResources(session, transaction);
        return getId(object);

    }

    abstract int getId(Object object);

    public void delete (E object, Class<E> type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(String.format("delete from %s where id = :id", type.getSimpleName())).setParameter("id", ((EntityId)object).getId());
        query.executeUpdate();
        HibernateSessionFactoryUtil.closeResources(session, transaction);
    }

    public void update(E object) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(object);
        HibernateSessionFactoryUtil.closeResources(session, transaction);
    }

    public List<E> getAll(Class type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List resultList = session.createQuery(getCriteriaQueryByEntity(type, session)).getResultList();
        HibernateSessionFactoryUtil.closeResources(session, transaction);
        return resultList;
    }

    protected CriteriaQuery<E> getCriteriaQueryWithWhereConditionByParamNameAndValue(Class<E> type, String paramName, Object paramValue, Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<E> from = criteriaQuery.from(type);
        CriteriaQuery<E> result = criteriaQuery.select(from).where(criteriaBuilder.equal(from.get(paramName), paramValue));
        return result;
    }

    private CriteriaQuery<E> getCriteriaQueryByEntity(Class<E> type, Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<E> from = criteriaQuery.from(type);
        return criteriaQuery.select(from);
    }
}
