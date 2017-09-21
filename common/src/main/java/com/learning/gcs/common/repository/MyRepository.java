package com.learning.gcs.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author jk
 * @since 13-12-29
 */
@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID> {

    <S extends T> List<S> saveAll(Iterable<S> entities);

    @Transactional
    <S extends T> List<S> updateAll(Iterable<S> entities);

    /**
     * 通过HQL查询数据列表
     * @param hql 脚本
     * @return
     */
    public List<T> whFindByList(String hql);

    /**
     * 根据hql查询分页
     * @param hql 脚本
     * @param pageSize 每页显示数量
     * @param pageNo 页码
     * @return
     */
    public Page<T> findByHql(String hql, int pageSize, int pageNo);

    /**
     * 数据更新
     * @param hql 更新脚本
     * @return
     */
    public int updateByHql(String hql);

    /**
     * 数据删除
     * @param hql 删除脚本
     */
    public int deleteByHql(String hql);

    /**
     * 根据一组主键查询实体集合
     * @param pks
     * @return
     */
    public List<T> findListByPKs(ID[] pks);

    /**
     * 获取前几条数据
     * @param hql
     * @param count 数据量
     * @return
     */
    public List<T> findTopByHql(String hql, int count);
}
