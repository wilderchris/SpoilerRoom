package com.revature.ProTwo.services;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.data.UserRepository;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;
import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(JMockit.class)
public class MockUserServiceTest {

    @Injectable
    private UserRepository userRepo;
    @Injectable
    private Movie movieRepo;

    @Autowired
    private UserService userServ;

    private static Set<User> mockUsers;

    static String name;

    @BeforeAll
    public static void mockUsersSetup() {
        mockUsers = new HashSet<>();

        for (int i=1; i<=5; i++) {
            User user = new User();
            user.setId(i);
            name = String.valueOf(i);//city
            if (i<3)
                user.setFirstName("alchemy" + name);
            mockUsers.add(user);
        }
    }
    @Test
    public void registerUserSuccessfully() throws UsernameAlreadyExistsException {
        User user = new User();
        user.setId(10);

//        when(userRepo.save(user)).thenReturn(user);
//new Expectations()
        User actualUser = userServ.register(user);
        assertEquals(10, actualUser.getId());
    }


}
