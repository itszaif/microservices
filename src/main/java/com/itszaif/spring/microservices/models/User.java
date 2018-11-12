package com.itszaif.spring.microservices.models;

import java.util.Date;

/**
 * User class
 *
 * @author <a href="mailto:zafrullahmehdi@gmail.com">Zafrullah Syed</a>
 * @since 12.11.2018
 */
public class User
{
    private Integer id;
    private String name;
    private Date birthDate;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public User(Integer id, String name, Date birthDate)
    {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
