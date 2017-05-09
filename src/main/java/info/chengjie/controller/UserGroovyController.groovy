package info.chengjie.controller;

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import info.chengjie.repository.JdbcRepository
import info.chengjie.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UserGroovyController {

    @Autowired
    UserRepository userRepository

    @Autowired
    JdbcRepository jdbcGroovyRepository


    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/hello1", produces = "application/json")
    String hello1() {
        println("enter hello")
        def user = new JsonBuilder();
        def test ="AAAA1"
        user {
            name 'bingo'
            age  36
            credit  test
            address(
                    city: 'nanjing',
                    country: 'china',
                    zip: 210012
            )
            married true

            departments 'TAP','Design dept.','Project Manager dept.'
        }

        //user.pet name: 'dog'

        user.toPrettyString()
    }

    @GetMapping(value = "/hello2", produces = "application/json")
    String hello2() {
        def userMap = userRepository.findUserInfo("17705176726")
        println("username:" + userMap.toString())

//        def user2 = new User(username: "陈兵", id: 1, mobile: 18888888 )

        JsonOutput.toJson(userMap)

    }

    @GetMapping(value="/test-jdbc", produces = "application/json")
    String jdbcTest(){
            JsonOutput.toJson jdbcTemplate.queryForMap("Select count(*) as count from user")
    }
}