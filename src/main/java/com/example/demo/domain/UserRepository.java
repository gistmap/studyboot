package com.example.demo.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User,Long>{

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);


    //void updateNameById(String name,Long id);

   /* @Query(value = "update User u set u.name=?1 where u.id=?2 ", nativeQuery = true)
    @Modifying
    void updateName(String name,int id);*/


}
