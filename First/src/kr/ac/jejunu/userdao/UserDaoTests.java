package kr.ac.jejunu.userdao;

import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoTests {
    @Test

    public void testGet() throws SQLException, ClassNotFoundException {

        long id = 1l;
        String name = "허윤호";
        String password="1234";
        UserDao userDao = new UserDao();
        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

}
