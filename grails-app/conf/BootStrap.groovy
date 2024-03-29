import com.testapp.*
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils 

class BootStrap {

    def init = { servletContext ->

      println 'Init BootStrap...'

      def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

      def testUser = new User(username: 'me', enabled: true, password: 'password')
      testUser.save(flush: true)

      UserRole.create testUser, adminRole, true

      assert User.count() == 1
      assert Role.count() == 2
      assert UserRole.count() == 1

      println '...End BootStrap'
      println SpringSecurityUtils.securityConfig.apf.allowSessionCreation
      println SpringSecurityUtils.securityConfig.requestCache.createSession

    }
    def destroy = {
    }
}
