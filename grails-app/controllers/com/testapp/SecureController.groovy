package com.testapp

import grails.plugins.springsecurity.Secured

class SecureController {

	def springSecurityService

    def index() {
    	render 'Secure access only '
    }

    def show() {
        session['test']='test1'
    	render 'id: '+springSecurityService.principal.id+' ,,, '
    	render 'es: '+User.get(springSecurityService.principal.id) + ':P'
    	render 'normal access ' + session['user'] + session
    }
}
