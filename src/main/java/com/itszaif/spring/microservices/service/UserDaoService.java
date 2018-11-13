package com.itszaif.spring.microservices.service;

import com.itszaif.spring.microservices.models.User;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:zafrullahmehdi@gmail.com">Zafrullah Syed</a>
 * @since 12.11.2018
 */
@Component
public class UserDaoService
{
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static
    {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Test", new Date()));
    }

    public List<User> findAll()
    {
        return users;
    }

    public User findOne(int id)
    {
        for(User user : users)
        {
            if(user.getId() == id)
            {
                return user;
            }
        }
        return null;
    }

    public User saveUser(User user)
    {
        if(user.getId() == null)
        {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

}
