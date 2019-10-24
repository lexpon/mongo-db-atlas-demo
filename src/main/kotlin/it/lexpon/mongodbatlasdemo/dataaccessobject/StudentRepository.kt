package it.lexpon.mongodbatlasdemo.dataaccessobject

import it.lexpon.mongodbatlasdemo.domainobject.Student
import org.springframework.data.mongodb.repository.MongoRepository

interface StudentRepository : MongoRepository<Student, String> {

    fun findByLastName(lastName: String): Student?

}
