package com.fangjian.zhenbao.business.system.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * 封装MyBatis操作数据库工具DAO层
 */
public class SystemBaseDao extends SqlSessionDaoSupport {

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 插入一条记录
     *
     * @param key
     * @param object
     * @auth fangjian
     * @return：影响的行数
     */
    public int save(String key, Object object) {
        return getSqlSession().insert(key, object);
    }

    /**
     * 更新一条记录
     *
     * @param key
     * @param object
     * @auth fangjian
     * @return：影响的行数
     */
    public int update(String key, Object object) {
        return getSqlSession().update(key, object);
    }

    /**
     * 更新一条记录
     *
     * @param key
     * @auth fangjian
     * @return：影响的行数
     */
    public int update(String key) {
        return getSqlSession().update(key);
    }

    /**
     * 根据id删除一条记录
     *
     * @param key
     * @param id
     * @auth fangjian
     * @return：影响的行数
     */
    public int delete(String key, Serializable id) {
        return getSqlSession().delete(key, id);
    }

    /**
     * 条件删除记录
     *
     * @param key
     * @param object
     * @auth fangjian
     * @return：影响的行数
     */
    public int delete(String key, Object object) {
        return getSqlSession().delete(key, object);
    }

    /**
     * 获取一条记录
     *
     * @param key
     * @param object
     * @auth fangjian
     * @return：获取的对象实体
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key, Object object) {
        T t = getSqlSession().selectOne(key, object);
        getSqlSession().clearCache();
        return t;
    }

    /**
     * 获取一条记录
     *
     * @param key
     * @auth fangjian
     * @return：获取的对象
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        T t = getSqlSession().selectOne(key);
        getSqlSession().clearCache();
        return t;
    }

    /**
     * 获取多条记录
     *
     * @param key
     * @auth fangjian
     * @return：获取的对象列表
     */
    public <T> List<T> getList(String key) {
        return getSqlSession().selectList(key);
    }

    /**
     * 获取多条记录
     *
     * @param key
     * @param object
     * @auth fangjian
     * @return：获取的对象列表
     */
    public <T> List<T> getList(String key, Object object) {
        return getSqlSession().selectList(key, object);
    }
}
