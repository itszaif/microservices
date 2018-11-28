package com.itszaif.spring.microservices.exceptions;

import java.util.Date;

/**
 * The type Exception response.
 */
public class ExceptionResponse
{
    private Date timestamp;
    private String message;
    private String Details;

    public ExceptionResponse(Date timestamp, String message, String details)
    {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.Details = details;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp()
    {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails()
    {
        return Details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(String details)
    {
        Details = details;
    }
}
