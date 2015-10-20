package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(ProfesorController)
@Mock(Profesor)
class ProfesorControllerSpec extends Specification {

    def "Prueba de numero de iteraciones"(){
        when:
        def profesor = new Profesor(nombre:"Gabriel", apellido: "Mañana", edad: 60, genero: "M", cedula: 1823534323,
                oficina: 10)
        def profesor2 = new Profesor(nombre:"Gabriel", apellido: "Mañana", edad: 60, genero: "M", cedula: 1823534323,
                oficina: 13)
        profesor.save(flush:true, failOnError:true)
        profesor2.save(flush:true, failOnError:true)

        then:
        controller.numeroDeInstancias() == 2
    }

}
