//package com.example.springdatajpademo.common.repository.impl;
//
//import com.example.springdatajpademo.common.entity.Filter;
//import com.example.springdatajpademo.common.entity.ResultPage;
//import com.example.springdatajpademo.common.entity.business.DeleteEntity;
//import com.example.springdatajpademo.common.jpa.Modifier;
//import com.example.springdatajpademo.common.repository.BaseRepository;
//import org.hibernate.SQLQuery;
//import org.hibernate.query.internal.NativeQueryImpl;
//import org.hibernate.transform.Transformers;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Path;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.metamodel.EntityType;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author 周林
// * @Description 通用RepositoryImpl
// * @email prometheus@noask-ai.com
// * @date 2020/9/10 17:54
// */
//@Repository
//public class BaseRepositoryImpl implements BaseRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public void flush() {
//        this.em.flush();
//    }
//
//    @Override
//    public <T extends DeleteEntity> T save(T model, Integer operatorId) {
//        model.setCreateBy(operatorId);
//        model.setUpdateBy(operatorId);
//        Date now = new Date();
//        model.setCreateAt(now);
//        model.setUpdateAt(now);
//        this.em.persist(model);
//        return model;
//    }
//
//    @Override
//    public <T> T get(Class<T> clazz, Integer id) {
//        return this.em.find(clazz, id);
//    }
//
//    @Override
//    public <T extends DeleteEntity> T update(T model, Integer operatorId) {
//        if (operatorId != null) {
//            model.setUpdateBy(operatorId);
//        }
//        Date now = new Date();
//        model.setUpdateAt(now);
//        this.em.merge(model);
//        return model;
//    }
//
//    @Override
//    public <T> void delete(T entity) {
//        this.em.remove(entity);
////        this.em.flush();
//    }
//
//    @Override
//    public <T> T get(Class<T> clazz, String where, Object... parameters) {
//        Entity entity = clazz.getAnnotation(Entity.class);
//        String entityName = entity.name().trim();
//        entityName = (entityName.isEmpty()) ? clazz.getSimpleName() : entityName;
//        Query query = this.em.createQuery(" FROM " + entityName + " WHERE " + where, clazz);
//        if (parameters != null) {
//            for (int i = 0, len = parameters.length; i < len; i++) {
//                Object parameter = parameters[i];
//                query.setParameter(i, parameter);
//            }
//        }
//        List results = query.getResultList();
//        return (results != null && !results.isEmpty()) ? (T) results.get(0) : null;
//    }
//
//    @Override
//    public <T> List<T> find(Class<T> clazz, String where, Object... parameters) {
//        Entity entity = clazz.getAnnotation(Entity.class);
//        String entityName = entity.name().trim();
//        entityName = (entityName.isEmpty()) ? clazz.getSimpleName() : entityName;
//        Query query = this.em.createQuery(" FROM " + entityName + " WHERE " + where, clazz);
//        if (parameters != null) {
//            for (int i = 0, len = parameters.length; i < len; i++) {
//                Object parameter = parameters[i];
//                query.setParameter(i, parameter);
//            }
//        }
//        List results = query.getResultList();
//        return results;
//    }
//
//    @Override
//    public <T> List<T> find(Class<T> clazz, Integer firstResult, Integer maxResults, String where, Object... parameters) {
//        Entity entity = clazz.getAnnotation(Entity.class);
//        String entityName = entity.name().trim();
//        entityName = (entityName.isEmpty()) ? clazz.getSimpleName() : entityName;
//        Query query = this.em.createQuery(" FROM " + entityName + " WHERE " + where, clazz);
//        if (parameters != null) {
//            for (int i = 0, len = parameters.length; i < len; i++) {
//                Object parameter = parameters[i];
//                query.setParameter(i, parameter);
//            }
//        }
//        query.setFirstResult(firstResult);
//        query.setMaxResults(maxResults);
//        return query.getResultList();
//    }
//
//    @Override
//    public <T> List<T> find(Class<T> clazz, Filter filter) {
//        try {
//            CriteriaBuilder builder = this.em.getCriteriaBuilder();
//            CriteriaQuery query = builder.createQuery();
//            Path path = query.from(clazz);
//            query.select(path);
//            where(query, builder, path, this.em.getMetamodel().entity(clazz), filter);
//            Query _query = this.em.createQuery(query);
//            return _query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    private void where(CriteriaQuery query, CriteriaBuilder builder, Path path, EntityType entityType, Filter filter) throws Exception {
//        if (filter == null) {
//            return;
//        }
//        if (filter.getConditions() != null && !filter.getConditions().isEmpty()) {
//            List<Predicate> predicates = new ArrayList<Predicate>(filter.getConditions().size());
//            for (Filter.Condition _sub : filter.getConditions()) {
//                Predicate predicate = createPredicate(builder, path, entityType, _sub);
//                if (predicate != null) {
//                    predicates.add(predicate);
//                }
//            }
//            query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
//        }
//    }
//
//    @Override
//    public <T> ResultPage<T> page(Class<T> clazz, Integer pageNumber, Integer pageSize, String where, Object... parameters) {
//        String sql = "SELECT project1_.id AS projectId,schedule0_.id as scheduleId, project1_.flage,project1_.project_name,project1_.school_year,schedule0_.schedule_name,schedule0_.schedule_begin_time,\n" +
//                "schedule0_.schedule_end_time,project1_.training_form,grades6_.appraisal_scores,grades6_.actual_credits,schedulete4_.registration_status,school3_.school_name,organizati2_.organization_name,courses9_.course_status,notice10_.notice_status,leaves7_.check_status,evaluation8_.evaluation_status,evaluation8_.study_evaluation_status,notice10_.notice_path FROM SCHEDULE schedule0_ LEFT OUTER JOIN project project1_ ON schedule0_.project_id = project1_.id LEFT OUTER JOIN organization organizati2_ ON project1_.organization_id = organizati2_.id LEFT OUTER JOIN school school3_ ON project1_.school_id = school3_.id LEFT OUTER JOIN schedule_teacher schedulete4_ ON schedule0_.id = schedulete4_.schedule_id LEFT OUTER JOIN teacher teacher5_ ON schedulete4_.teacher_id = teacher5_.id LEFT OUTER JOIN grade grades6_ ON teacher5_.id = grades6_.teacher_id LEFT OUTER JOIN LEAVES leaves7_ ON teacher5_.id = leaves7_.teacher_id LEFT OUTER JOIN evaluation evaluation8_ ON schedule0_.id = evaluation8_.schedule_id LEFT OUTER JOIN course courses9_ ON schedule0_.id = courses9_.schedule_id LEFT OUTER JOIN notice notice10_ ON schedule0_.notice_id = notice10_.id WHERE schedulete4_.teacher_id =" + teacherId + " and if('" + schoolYear + "'!='null',project1_.school_year='" + schoolYear + "',1=1) and if('" + registrationStatus + "'!='null',schedulete4_.registration_status='" + registrationStatus + "',1=1) and if('" + evaluationStatus + "'!='null',evaluation8_.evaluation_status='" + evaluationStatus + "',1=1) and if('" + projectName + "'!='null',project1_.project_name  LIKE CONCAT('%','" + projectName + "','%'),1=1) ORDER BY schedule0_.id DESC limit " + page + "," + size + "";
//        Query query = this.em.createNativeQuery(sql);
////        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(TrainingAllListVo.class));
////        return query.getResultList();
//
//        Entity entity = clazz.getAnnotation(Entity.class);
//        String entityName = entity.name().trim();
//        entityName = (entityName.isEmpty()) ? clazz.getSimpleName() : entityName;
//        Query query = this.em.createQuery(" FROM " + entityName + " WHERE " + where, clazz);
//        if (parameters != null) {
//            for (int i = 0, len = parameters.length; i < len; i++) {
//                Object parameter = parameters[i];
//                query.setParameter(i, parameter);
//            }
//        }
//        query.setFirstResult((pageNumber - 1) * pageSize);
//        query.setMaxResults(pageSize);
//        List results = query.getResultList();
//
//        Query countQuery = this.em.createQuery("SELECT COUNT(*) FROM " + entityName + " WHERE " + where);
//        if (parameters != null) {
//            for (int i = 0, len = parameters.length; i < len; i++) {
//                Object parameter = parameters[i];
//                countQuery.setParameter(i, parameter);
//            }
//        }
//        Long totalCount = (Long) countQuery.getSingleResult();
//        return new ResultPage(results, pageNumber, pageSize, totalCount);
//    }
//
//    @Override
//    public <T> long count(Class<T> clazz, String where, Object... parameters) {
//        Entity entity = clazz.getAnnotation(Entity.class);
//        String entityName = entity.name().trim();
//        entityName = (entityName.isEmpty()) ? clazz.getSimpleName() : entityName;
//        Query countQuery = this.em.createQuery("SELECT COUNT(*) FROM " + entityName + " WHERE " + where);
//        if (parameters != null) {
//            for (int i = 0, len = parameters.length; i < len; i++) {
//                Object parameter = parameters[i];
//                countQuery.setParameter(i, parameter);
//            }
//        }
//        Long totalCount = (Long) countQuery.getSingleResult();
//        return totalCount;
//    }
//
//    @Override
//    public Object save(Object model) {
//        this.em.persist(model);
//        return model;
//    }
//
//    @Override
//    @Transactional
//    public Object update(Object model) {
//        this.em.merge(model);
//        return model;
//    }
//
//    private Predicate createPredicate(CriteriaBuilder builder, Path path
//            , EntityType entityType, Filter.Condition condition) throws Exception {
//        if (condition.getModifier() == Modifier.and) {
//            if (condition.getSet() != null && !condition.getSet().isEmpty()) {
//                List<Predicate> predicates = new ArrayList<Predicate>(condition.getSet().size());
//                for (Filter.Condition _sub : condition.getSet()) {
//                    Predicate predicate = createPredicate(builder, path, entityType, _sub);
//                    if (predicate != null) {
//                        predicates.add(predicate);
//                    }
//                }
//                return builder.and(predicates.toArray(new Predicate[predicates.size()]));
//            }
//        } else if (condition.getModifier() == Modifier.or) {
//            List<Predicate> predicates = new ArrayList<Predicate>(condition.getSet().size());
//            for (Filter.Condition _sub : condition.getSet()) {
//                Predicate predicate = createPredicate(builder, path, entityType, _sub);
//                if (predicate != null) {
//                    predicates.add(predicate);
//                }
//            }
//            return builder.or(predicates.toArray(new Predicate[predicates.size()]));
//        } else {
//            Modifier modifier = condition.getModifier() == null ? Modifier.eq : condition.getModifier();
//            return createPredicate(builder, path, entityType, condition.getPath(), modifier, condition.getValue());
//        }
//        return null;
//    }
//
//    private static final String percentStr = "%";
//
//    private Predicate createPredicate(CriteriaBuilder builder, Path path
//            , EntityType entityType, String field, Modifier modifier, Object value) throws Exception {
//        Class fieldClazz = entityType.getAttribute(field).getJavaType();
//        Object _value = conver(fieldClazz, value);
//        Path _field = path.get(field);
//        switch (modifier) {
//            case in:
//                if (_value instanceof Collection) {
//                    return _field.in((Collection) _value);
//                }
//                return _field.in(_value);
//            case notIn:
//                if (_value instanceof Collection) {
//                    return _field.in((Collection) _value).not();
//                }
//                return _field.in(_value).not();
//            case eq:
//                return builder.equal(_field, _value);
//            case notEq:
//                return builder.notEqual(_field, _value);
//            case lt:
//                return builder.lessThan(_field, (Comparable) _value);
//            case gt:
//                return builder.greaterThan(_field, (Comparable) _value);
//            case le:
//                return builder.lessThanOrEqualTo(_field, (Comparable) _value);
//            case ge:
//                return builder.greaterThanOrEqualTo(_field, (Comparable) _value);
//            case like:
//                return builder.like(_field, (String) _value);
//            case notLike:
//                return builder.notLike(_field, (String) _value);
//            case contains:
//                return builder.like(_field, percentStr + _value + percentStr);
//            case notContains:
//                return builder.notLike(_field, percentStr + _value + percentStr);
//            case startsWith:
//                return builder.like(_field, _value + percentStr);
//            case notStartsWith:
//                return builder.notLike(_field, _value + percentStr);
//            case endsWith:
//                return builder.like(_field, percentStr + _value);
//            case notEndsWith:
//                return builder.notLike(_field, percentStr + _value);
//            case isNull:
//                return builder.isNull(_field);
//            case isNotNull:
//                return builder.isNotNull(_field);
//            case isEmpty:
//                return builder.isEmpty(_field);
//            case isNotEmpty:
//                return builder.isNotEmpty(_field);
//        }
//        return null;
//    }
//
//
//    private Object conver(Class fieldClazz, Object value) throws Exception {
//        if (value == null)
//            return null;
//        if (value.getClass().isArray()) {
//            return converArray(fieldClazz, (Object[]) value);
//        } else if (Collection.class.isAssignableFrom(value.getClass())) {
////            fieldClazz.
//            return value;
//        } else {
//            return converObject(fieldClazz, value);
//        }
//    }
//
//    private Collection<Object> converArray(Class fieldClazz, Object[] values)
//            throws Exception {
//        if (values == null)
//            return null;
//        Collection array = new ArrayList(values.length);
//        for (int i = 0, len = values.length; i < len; i++) {
//            array.add(converObject(fieldClazz, values[i]));
//        }
//        return array;
//    }
//
//    private Object converObject(Class fieldClazz, Object value)
//            throws Exception {
//        if (value == null)
//            return null;
//        if (!value.getClass().equals(fieldClazz)) {
//            if (value instanceof String) {
//                return ArgumentTypeConverter.Conver((String) value, fieldClazz);
//            } else {
//                throw new Exception("不支持此类型的argument参数：" + value.getClass());
//            }
//        }
//        return value;
//    }
//
//    private
//}
