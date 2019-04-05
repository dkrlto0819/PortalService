package kr.ac.jejunu.userdo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTests {
    @Test
    public void testGet(){
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
}
