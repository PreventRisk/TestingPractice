package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(EstudianteController)
@Mock(Estudiante)
class EstudianteControllerSpec extends Specification {

    def "Prueba de numero de iteraciones"() {
        when:
        def estudiante1 = new Estudiante(nombre:"Nana", apellido: "Torres", edad: 20, genero: "F", cedula: 1023734323, semestre: 7, codigoInst: 345)
        def estudiante2 = new Estudiante(nombre:"Carlos", apellido: "Gomez", edad: 20, genero: "M", cedula: 1823834323, semestre: 7, codigoInst: 456)
        estudiante1.save(flush:true, failOnError:true)
        estudiante2.save(flush:true, failOnError:true)

        then:
        controller.numeroDeInstancias() == 2

    }
}
