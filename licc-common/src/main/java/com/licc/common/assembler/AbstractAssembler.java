package com.licc.common.assembler;
/**
 * @author lichangcaho
 */



import com.licc.common.util.BeanMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 领域模型和视图模型转换抽象类
 */
public abstract class AbstractAssembler<V, E> {

    private transient Class<V> dtoClass;
    private transient Class<E> entityClass;


    public AbstractAssembler(Class dtoClass, Class entityClass) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    /**
     * 业务对象转成DTO
     * @param e 业务对象
     * @return DTO
     */
    public V toDTO(E e) {
        return BeanMapper.map(e, dtoClass);
    }

    /**
     * 业务对象批量转成DTO
     * @param es 业务对象集合
     * @return DTO集合，如果源业务对象集合为空或NULL，将返回空集合Collections.emptyList()
     * @see Collections#emptyList
     */
    public Collection<V> toDTOs(final Collection<E> es) {
        if (es == null || es.isEmpty()) {
            return Collections.emptyList();
        }
        Collection<V> ds = new ArrayList<V>();
        for (E e : es) {
            ds.add(toDTO(e));
        }
        return ds;
    }

    /**
     * DTO转成业务对象
     * @param d DTO
     * @return 业务对象
     */
    public E toEntity(final V d) {
        return BeanMapper.map(d, entityClass);
    }

    /**
     * 业务对象批量转成DTO
     * @param ds DTO集合
     * @return 业务对象集合，如果源DTO集合为空或NULL，将返回空集合Collections.emptyList()
     * @see Collections#emptyList
     */
    public Collection<E> toEntities(final Collection<V> ds) {
        if (ds == null || ds.isEmpty()) {
            return Collections.emptyList();
        }
        Collection<E> es = new ArrayList<E>();
        for (V d : ds) {
            es.add(toEntity(d));
        }
        return es;
    }
}
