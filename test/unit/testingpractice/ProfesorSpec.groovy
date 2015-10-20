package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Profesor)
class ProfesorSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test oficina"() {
        when:
        def profe1 = new Profesor()
        profe1.oficina = ofi1
        def profe2 = Mock(Profesor)
        profe2.oficina = ofi2
        boolean rta = rta1

        then:
        (ofi1 != ofi2) == rta1

        where:
        ofi1 | ofi2 | rta1
        1 | 2 | true
        1 | 1 | false

    }

    void "test lista"() {
        when:
        def profe = new Profesor()
        profe.cursos = cursos
        profe.validate()

        then:
        profe.hasErrors() == !valid

        where:
        cursos | valid
        null | false
    }
}
