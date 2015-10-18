package testingpractice

class Usuario {

    String nombre
    String apellido
    int edad
    String genero
    long cedula


    static constraints = {
        nombre size: 3..50, blank: false, nullable: false
        apellido size: 3..50, blank: false, nullable: false
        edad min: 18, blank: false
        genero maxSize: 1, validator: { it == "M" || it == "F" }, blank: false, nullable: false
        cedula unique: true, blank: false
    }

    String toString() {
        return nombre + " " + apellido
    }
}
