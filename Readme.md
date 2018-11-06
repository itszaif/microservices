# Spring Boot with Microservices

A basic social media application, using spring boot and microservices


# Rest end points
Following are the rest end points:
* Retrieve all users:
````
GET /users
````
* Create a user:
````
POST /users/newUser
````
* Retrieve a user:
````
GET /users/{userId}
````
* Delete a user:
````
DELETE /users/{userId}
````
* Retrieve all posts of a user:
````
GET /users/{userId}/posts
````
* Create a post for a user:
````
POST /users/{userId}/posts
````
* Retrieve details of a post of  a user:
````
GET /users/{userId}/posts{postId}
````
