package info.chengjie.controller

import info.chengjie.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by macos on 2017/5/8.
 */

@RestController
class UserKotlinController {

    @Autowired
    lateinit var userRepository:UserRepository

    @GetMapping(value = "/kotlin/user/{mobile}" , produces = arrayOf("application/json"))

    fun findByMobileString(@PathVariable mobile:String) = userRepository.findByMobile(mobile)
}
