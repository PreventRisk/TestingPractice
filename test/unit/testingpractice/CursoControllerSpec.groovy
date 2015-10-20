package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(CursoController)
@Mock(Curso)
class CursoControllerSpec extends Specification {
    def "Prueba de numero de iteraciones"(){
        when:
        def curso = new Curso(codigo: 2345, nombre: "Ingeniería de Software II", creditos: 3, descripcion: "Materia interesante", profesor: new Profesor())
        curso.save(flush:true, failOnError:true)

        then:
        controller.numeroDeInstancias() == 1
    }
}
