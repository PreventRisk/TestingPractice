package testingpractice

class Curso {

    long codigo
    String nombre
    int creditos
    String descripcion


    static belongsTo = [profesor: Profesor]

    static constraints = {
        codigo unique: true
        nombre size: 3..50,  nullable: false
        creditos range: 1..5
        descripcion blank: false, nullable: false, minSize: 10
    }
}
