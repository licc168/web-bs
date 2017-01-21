package module;

import base.BaseServiceTest;
import com.licc.service.user.IUserService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by liccw on 2017/1/15.
 */
public class UserServiceTest extends BaseServiceTest {
    @Resource
    IUserService userService;
    @Test
    public  void testGetByNameAndPassword(){
        try {
            userService.getByNameAndPassword("123","123");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
