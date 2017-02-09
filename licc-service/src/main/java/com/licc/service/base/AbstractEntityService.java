package com.licc.service.base;


import com.licc.common.assembler.AbstractAssembler;
import com.licc.common.util.*;
import com.licc.dao.base.IEntity;
import com.licc.dao.base.IEntityMapper;
import com.licc.vo.UserVO;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 通用抽象实体Service
 *
 * @author lichangchao
 */
public abstract class AbstractEntityService<V, E extends IEntity, PK extends Serializable> {

    /**
     * 获取实体mapper对象
     *
     * @return
     */
    protected abstract IEntityMapper<E, PK> getEntityMapper();

    private AbstractAssembler<V, E> entityAssembler = new AbstractAssembler<V, E>(
            GenericsUtils.getSuperClassGenricType(this.getClass(), 0),
            GenericsUtils.getSuperClassGenricType(this.getClass(), 1)) {
    };


    /**
     * 分页查询
     *
     * @param queryParam 查询参数
     * @return
     */
    public PageResult<V> page(QueryParameters queryParam) {
        IEntityMapper<E, PK> entityMapper = getEntityMapper();
        PageInfo pageInfo = queryParam.getPage();

        int count = entityMapper.count(queryParam);
        if (count == 0) {
            return PageResult.valueOf(pageInfo.resetTotal(0),
                    (List<V>) Collections.emptyList());
        }

        pageInfo.resetTotal(count);

        List<E> entities = entityMapper.page(queryParam);
        if (entities == null || entities.isEmpty()) {
            return PageResult.valueOf(pageInfo,
                    (List<V>) Collections.emptyList());
        }

        Collection<V> dtos = entityAssembler.toDTOs(entities);
        return PageResult.valueOf(pageInfo, dtos);
    }

    /**
     * 列表查询
     *
     * @param queryParam 查询参数
     * @return
     */
    public List<V> list(QueryParameters queryParam) {
        IEntityMapper<E, PK> entityMapper = getEntityMapper();
        List<E> entities = entityMapper.page(queryParam);
        Collection<V> dtos = entityAssembler.toDTOs(entities);
        return (List<V>) dtos;
    }

    /**
     * 获取实体Dto
     *
     * @param id 实体主键
     * @return
     */
    public V get(PK id) {
        IEntityMapper<E, PK> entityMapper = getEntityMapper();
        E entity = entityMapper.get(id);
        if (entity == null) {
            return null;
        }
        return entityAssembler.toDTO(entity);
    }


    /**
     * 保存实体
     *
     * @param dto 实体Dto
     */
    public void save(V dto) {
        IEntityMapper<E, PK> entityMapper = getEntityMapper();
        E entity = entityAssembler.toEntity(dto);
        if (entity == null) {
            return;
        }
        entityMapper.save(entity);
    }


    /**
     * 删除实体
     *
     * @param id 实体主键
     * @return
     */
    public int remove(PK id) {
        IEntityMapper<E, PK> entityMapper = getEntityMapper();
        return entityMapper.delete(id);
    }

    /**
     * 通过参数信息获取实体
     */
    public V getByParam(E param) {
        List<V> list = this.list(QueryParametersUtil.addParam(param));
        if (CollectionUtils.isEmpty(list)) return null;
        return list.get(0);
    }

}
