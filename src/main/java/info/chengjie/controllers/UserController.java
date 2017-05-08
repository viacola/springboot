package info.chengjie.controllers;

import info.chengjie.model.User;
import info.chengjie.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by macos on 2017/5/2.
 */

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PersistenceContext
    private EntityManager em;

    @GetMapping("/get-by-mobile")
    public String getByMobile(String mobile){
        String userId ;
        User user = userRepository.findByMobile(mobile);
        if (user != null) {
            userId = String.valueOf(user.getId());
            return "The user id is : " + userId + " username: "+ user.getUsername();
        }
        return "user " + mobile + " is not exist!";
    }


    @GetMapping("/test1")
    public String test(){
        Query query = (Query) em.createNativeQuery("select t.username, t.mobile from user t limit 3 ");
        List objecArraytList = query.getResultList();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<objecArraytList.size();i++) {
            Object[] obj = (Object[]) objecArraytList.get(i);
            //使用obj[0],obj[1],obj[2]取出属性
            sb.append( (String) obj[0] + " | " + (String) obj[1] + "  ::: ");
        }
        em.close();

        return sb.toString();
    }


    

    @GetMapping("/user/findUserInfo")
    public String findUserInfoByMobile(String mobile) {
            String userInfo = userRepository.findUserNameAndMobileAndAvatar(mobile);
            Object[] user = userRepository.findUserInfo(mobile);
//        System.out.println("userInfo:" + userInfo.length);
        System.out.println(userInfo);
        System.out.println("q   qq  userName  333:" + user.toString() );
//        return "@ " + userInfo[0] + " | " + userInfo[1] + " | " + userInfo[2];
        System.out.println("---2222--");

        System.out.println("--3333---");
        System.out.println("---1111--");



        return "ok";
    }

}
