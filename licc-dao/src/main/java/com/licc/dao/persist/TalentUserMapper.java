package com.licc.dao.persist;

import com.licc.common.util.QueryParameters;
import com.licc.dao.po.TalentUser;
import java.util.List;

public interface TalentUserMapper {
    List<TalentUser> page(QueryParameters queryParam);

    int count(QueryParameters queryParam);

    int delete(Long id);

    int insert(TalentUser record);

    int insertSelective(TalentUser record);

    TalentUser get(Long id);

    int updateSelective(TalentUser record);

    int update(TalentUser record);
}