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

    void "test codigo"() {
        when:
        def curso1 = new Curso()
        curso1.codigo = codigo1
        def curso2 = Mock(Curso)
        curso2.codigo = codigo2
        boolean rta = rta1

        then:
        (codigo1 != codigo2) == rta1

        where:
        codigo1 | codigo2 | rta1
        1 | 2 | true
        1 | 1 | false

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
        "1"*51 | false // No puede exceder los 50 caracteres
        //"Nombre Curso" | true //No aclara si puede contener espacios o no
        //"Course" | true
        //"tri" | true
        //"1"*50 | true // Maximo son 50 caracteres
        null | false
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

    def "test descripcion"(){
        when:
        def curso = new Curso()
        curso.descripcion = descripcion
        curso.validate()

        then:
        curso.hasErrors() == !valido

        where:
        descripcion | valido
        //'a'*10 | true
        'a'*9 | false // Menos de 10 no permitido
    }

}
