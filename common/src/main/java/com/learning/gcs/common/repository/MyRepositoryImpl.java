package com.learning.gcs.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyRepositoryImpl<T, ID extends Serializable>
  extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

  private final EntityManager em;

  public MyRepositoryImpl(JpaEntityInformation entityInformation,
                          EntityManager entityManager) {
    super(entityInformation, entityManager);

    // Keep the EntityManager around to used from the newly introduced methods.
    this.em = entityManager;
  }

  //TODO 未完批量一次性插入功能
  @Override
  @Transactional
  public <S extends T> List<S> saveAll(Iterable<S> entities) {
    em.setFlushMode(FlushModeType.COMMIT);
    List<S> result = new ArrayList<S>();
    if (entities == null) {
      return result;
    }
    for (S entity : entities) {
      em.persist(entity);
      result.add(entity);
    }
    return result;
  }

  @Override
  @Transactional
  public <S extends T> List<S> updateAll(Iterable<S> entities) {
    em.setFlushMode(FlushModeType.COMMIT);
    List<S> result = new ArrayList<S>();
    if (entities == null) {
      return result;
    }
    for (S entity : entities) {
      result.add(em.merge(entity));
    }
    return result;
  }

  //通过HQL查询数据列表
  @SuppressWarnings("unchecked")
  @Override
  public List<T> whFindByList(String hql) {
    Query query = this.em.createQuery(hql);
    return (List<T>) query.getResultList();
  }

  //根据hql查询分页，参数每页显示数量、页码
  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public Page<T> findByHql(String hql, int pageSize, int pageNo) {
    Page<T> page = null;
    Query query = em.createQuery(hql);
    int total = emHql(hql);
    // 设置查询结果的结束记录数
    int maxResults = pageSize;
    query.setMaxResults(maxResults);
    // 设置查询结果的开始记录数（从0开始计数）
    int firstResult = (pageNo - 1) * pageSize;
    query.setFirstResult(firstResult);
    List<T> rlist = query.getResultList();
    page = new PageImpl(rlist, new PageRequest(pageNo - 1, pageSize), total);

    return page;
  }

  //通过HQL更新数据
  @Override
  public int updateByHql(String hql) {
    Query query = this.em.createQuery(hql);
    return query.executeUpdate();
  }

  //通过HQL删除数据
  @Override
  public int deleteByHql(String hql) {
    Query query = this.em.createQuery(hql);
    return query.executeUpdate();
  }

  //通过主键查询数据列表
  @SuppressWarnings("unchecked")
  @Override
  public List<T> findListByPKs(ID[] pks){
    Iterable<ID> pk = (Iterable<ID>) Arrays.asList(pks).iterator();
    List<T> list = findAll(pk);
    return list;
  }

  //查询数据条数
  public int emHql(String hql) {
    Query query = em.createQuery(hql);
    return query.getResultList().size();
  }

  /**
   * 获取前几条数据
   * @param hql
   * @param count 数据量
   * @return
   */
  @Override
  public List<T> findTopByHql(String hql, int count) {
    Query query = em.createQuery(hql);
    query.setFirstResult(0);
    query.setMaxResults(count);
    return query.getResultList();
  }
}