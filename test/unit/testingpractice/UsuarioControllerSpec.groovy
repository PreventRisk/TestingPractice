package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(UsuarioController)
@Mock(Usuario)
class UsuarioControllerSpec extends Specification {

    def "Prueba de numero de iteraciones"(){
         when:
         def usuario = new Usuario(nombre:"Nana", apellido: "Torres", edad: 20, genero: "F", cedula: 1023734323)
         def usuario2 = new Usuario(nombre:"Carlos", apellido: "Gomez", edad: 20, genero: "M", cedula: 1823834323)
         def usuario3 = new Usuario(nombre:"Ivan", apellido: "Torres", edad: 20, genero: "M", cedula: 1023664323)
         usuario.save(flush:true, failOnError:true)
         usuario2.save(flush:true, failOnError:true)
         usuario3.save(flush:true, failOnError:true)

         then:
         controller.numeroDeInstancias() == 3
    }

}
