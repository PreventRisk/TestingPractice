package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Curso)
class CursoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }
    def "test nombre"(){
        when:
        def curso = new Curso()
        curso.nombre = nombre
        curso.validate()

        then:
        curso.hasErrors() == !valido

        where:
        nombre   | valido
        "LD" | false // Minimo son tres caracteres
        "123456789012345678901234567890123456789012345678901" | false // No puede exceder los 50 caracteres
        //"Nombre Curso" | true //No aclara si puede contener espacios o no
        //"Course" | true
        //"tri" | true
        //"12345678901234567890123456789012345678901234567890" | true
        "" | false
    }
    def "test creditos"(){
        when:
        def curso = new Curso()
        curso.nombre = nombre
        curso.validate()

        then:
        curso.hasErrors() == !valido

        where:
        nombre   | valido
        0 | false //menos de 1 credito
        //5 | true
        //1 | true
        6 | false // mas de 5 creditos
    }
}
