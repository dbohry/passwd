package com.danielbohry.passwd.service

import com.danielbohry.passwd.service.PasswordFactory
import spock.lang.Specification

class PasswordFactoryTest extends Specification {

    def factory = new PasswordFactory()

    def "should create a new password"() {
        when:
        def result = factory.createPassword()

        then:
        result.size() == 24
        result.matches("[a-zA-Z0-9]{8}-[a-zA-Z0-9]{7}-[a-zA-Z0-9]{7}")
    }

}
