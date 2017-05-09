package info.chengjie.service

import info.chengjie.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class UserService {

    @Autowired
    private UserRepository userRepository;

    def echoDemo() {
        println("echoDemo")
    }

    def printDemo() {
        echoDemo()


    }
}