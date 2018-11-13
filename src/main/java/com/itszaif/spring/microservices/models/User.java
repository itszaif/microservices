package com.itszaif.spring.microservices.models;

import java.util.Date;

/**
 * User class
 *
 * @author  <a href="mailto:zafrullahmehdi@gmail.com">Zafrullah Syed</a>
 * @since 12.11.2018
 */
public class User
{
    private Integer id;
    private String name;
    private Date birthDate;

    /**
     * Instantiates a new User.
     */
    public User()
    {
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public Date getBirthDate()
    {
        return birthDate;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    /**
     * Instantiates a new User.
     *
     * @param id the id
     * @param name the name
     * @param birthDate the birth date
     */
    public User(Integer id, String name, Date birthDate)
    {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
