package kr.ac.jejunu.userdao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoTests {

    private UserDao userDao;

    @Before
    public void setup(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
//        DaoFactory daoFactory = new DaoFactory();
//        userDao = daoFactory.getUserDao();
        userDao = applicationContext.getBean("getUserDao", UserDao.class);
            ///DaOFactory 에서 찾는 것이기 때문에 이름이 같아야 함
    }

    @Test
    public void testGet() throws SQLException, ClassNotFoundException {

        long id = 1l;
        String name = "허윤호";
        String password="1234";

//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.getUserDao();

        //UserDao userDao = new UserDao();
        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void testAdd() throws SQLException, ClassNotFoundException {
        String name = "허윤호";
        String password="1234";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

//
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.getUserDao();

        //UserDao userDao = new UserDao();
        Long id = userDao.add(user);
        User resultUser = userDao.get(id);


        assertThat(resultUser.getId(), is(id));
        assertThat(resultUser.getName(), is(name));
        assertThat(resultUser.getPassword(), is(password));
    }

    public void HallatestGet() throws SQLException, ClassNotFoundException {

        long id = 1l;
        String name = "헐크";
        String password="1234";

        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();

        //UserDao userDao = new HallaUserDao();
        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

}
