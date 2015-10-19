package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Usuario)
class UsuarioSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Prueba de nombre"(){
        when:
        def usuario = new Usuario(apellido: "Gomez", edad: 20, genero: "M", cedula: 1022543545)
        usuario.nombre = nombre
        usuario.validate()

        then:
        usuario.hasErrors() == !valido

        where:
        nombre   | valido
        "LD" | false // Minimo son tres caracteres
        "123456789012345678901234567890123456789012345678901" | false // No puede exceder los 50 caracteres
        "Carlos Alfonso" | true //No aclara si puede contener espacios o no
        "Carlos" | true
        "Joe" | true
        "12345678901234567890123456789012345678901234567890" | true
        "" | false
    }

    def "Prueba apellido"(){
        when:
        def usuario = new Usuario(nombre: "Camila", edad: 20, genero: "F", cedula: 1022543545)
        usuario.apellido = apellido
        usuario.validate()

        then:
        usuario.hasErrors() == !valido

        where:
        apellido   | valido
        "LD" | false // Minimo son tres caracteres
        "Odin" | true
        "123456789012345678901234567890123456789012345678901" | false // No puede exceder los 50 caracteres
        "Gomez Hernandez" | true
        "Alonso" | true
        "Joe" | true
        "12345678901234567890123456789012345678901234567890" | true
        ""| false
    }

    def "Prueba de edad"(){
        when:
        def usuario = new Usuario(nombre: "Camila", apellido: "Lopez", genero: "F", cedula: 1023443432)
        usuario.edad = edad
        usuario.validate()

        then:
        usuario.hasErrors() == !valid

        where:
        edad | valid
        14   | false // Edad menor a 18
        18   | true // Edad m�nima permitida
        17   | false // Edad menor a 18, (es el limite -1)
    }


    def "Prueba genero"(){
        when:
        def usuario = new Usuario(nombre: "Fulanito", apellido: "Detal", edad: 20, cedula: 1023323323)
        usuario.genero = genero
        usuario.validate()

        then:
        usuario.hasErrors() == !valid

        where:
        genero | valid
        "M"    | true // M y F son las unicos valores que puede tomar
        "K"    | false
        "F"    | true
        "m"    | false
    }

    def "Prueba cedula"(){
        when:
        def usuario = new Usuario(nombre: "Nana", apellido: "Torres", edad: 20, genero: "F")
        usuario.cedula = cedula
        usuario.validate()

        then:
        usuario.hasErrors() == !valida

        where:
        cedula | valida
        0 | false
        234567123 | true
    }
}
