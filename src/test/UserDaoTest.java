import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.training.dao.UserDao;
import com.training.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by admin on 2018/7/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @org.junit.Test
    public void getUserByName() throws Exception {
        User u = userDao.getUserByName("a");
        System.out.println("u:" + u);
    }

    @Test
    public void getAuthentyByName() throws Exception{
        List list  = userDao.getAuthentyByName("b");
        System.out.println(list);
    }
}