package testingpractice

class Profesor extends Usuario{

    int oficina
    static hasMany = [cursos:Curso]

    Profesor() {
        cursos = new ArrayList();
    }

    static constraints = {
        oficina min: 0, max: 50,unique: true
    }
}
