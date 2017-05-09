package info.chengjie.repository

import groovy.json.JsonOutput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

/**
 * Created by macos on 2017/5/9.
 */

@Service
class JdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    def findUserByJdbcTemplate(){
        Map mm = jdbcTemplate.queryForMap("SELECT count(*) as count from user ")
        println JsonOutput.toJson(mm)
        return mm
    }
}
