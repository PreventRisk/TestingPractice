package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Estudiante)
class EstudianteSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test lista"() {
        when:
        def student = new Estudiante()
        student.cursos = cursos
        student.validate()

        then:
        student.hasErrors() == !valid

        where:
        cursos | valid
        null | false
    }

    def "test semestre"(){
        when:
        def student = new Estudiante(codigoInst: 12345)
        student.semestre = semestre
        student.validate()

        then:
        student.hasErrors() == !valid

        where:
        semestre | valid
        //1 | true// semestre entre 1 y 20
        //20 | true // semestre entre 1 y 20
        -1 | false // semestre fuera de 1 y 20
        0 | false // semestre fuera de 1 y 20
        100 | false // semestre fuera de 1 y 20

    }

    def "test codigo institucional"(){
        when:
        def student = new Estudiante()
        student.codigoInst = codigo
        student.validate()

        then:
        student.hasErrors() == !valid

        where:
        codigo | valid
        " "| false // codigo no blank
        // null | false // codigo no nulo
        0 | false //


    }

}
