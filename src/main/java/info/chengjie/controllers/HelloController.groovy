package info.chengjie.controllers;

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import info.chengjie.services.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    UserRepository userRepository

    @GetMapping("/hello")
    String hello() {
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

    @GetMapping("/hello2")
    String hello2() {
        def user = userRepository.findByMobile("17705176726")

        JsonOutput.toJson(user)
    }
}