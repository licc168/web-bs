package module;

import base.BaseDaoTest;
import com.licc.dao.persist.UserMapper;
import com.licc.dao.po.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 *用户测试类
 */
public class UserDaoTest extends BaseDaoTest {
   @Resource
   UserMapper userMapper;
    @Test
    public void testUser(){
    User user =     userMapper.get(1);
        System.out.println(user.getPswd());
    }
}
