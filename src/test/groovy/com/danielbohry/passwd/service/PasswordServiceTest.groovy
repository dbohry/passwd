package com.danielbohry.passwd.service

import com.danielbohry.passwd.domain.Password
import com.danielbohry.passwd.repository.PasswordRepository
import spock.lang.Specification
import spock.lang.Subject

class PasswordServiceTest extends Specification {

    def userService = Mock(UserService)
    def factory = new PasswordFactory()
    def repository = Mock(PasswordRepository)

    @Subject
    def service = new PasswordService(userService, factory, repository)

    def "should get the list of user's passwords"() {
        given:
        def userId = "userId"
        repository.findByUserId(userId) >> List.of(new Password(
                UUID.randomUUID().toString(),
                userId,
                factory.createPassword(),
                ""))

        when:
        def result = service.getAll(userId)

        then:
        result.size() == 1
    }


}
