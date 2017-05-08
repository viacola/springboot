package info.chengjie.services;

import info.chengjie.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Map;

/**
 * Created by macos on 2017/5/2.
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    public User findByMobile(@Param("mobile") String mobile);


    @Query(value = "select u.username, u.mobile, u.avatar from user u where u.mobile = ?1 " ,
            countQuery = "select count(*) from user where mobile = ?1",
            nativeQuery = true)
    public String findUserNameAndMobileAndAvatar(String mobile) ;


    @Query(value = "select u.id , u.username, u.mobile from user u where u.mobile = ?1 " ,
            countQuery = "select count(*) from user where mobile = ?1",
            nativeQuery = true)
    public Object[] findUserInfo(String mobile);




}
