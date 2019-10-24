package it.lexpon.mongodbatlasdemo.service

import it.lexpon.mongodbatlasdemo.dataaccessobject.StudentRepository
import it.lexpon.mongodbatlasdemo.domainobject.Student
import it.lexpon.mongodbatlasdemo.transferobject.CreateStudentRequest
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class StudentService(
        private val studentRepository: StudentRepository
) {

    companion object : KLogging()

    @Transactional
    fun createStudent(createStudentRequest: CreateStudentRequest): Student =
            findStudentByLastName(createStudentRequest.lastName)
                    ?.let {
                        logger.info { "Student exists already: $it" }
                        return it
                    }
                    ?: let {
                        val id = UUID.randomUUID().toString()
                        val student = Student(id, createStudentRequest.lastName)
                        return studentRepository.insert(student)
                    }

    fun findStudentByLastName(lastName: String): Student? =
            studentRepository.findByLastName(lastName)

    fun deleteStudentByLastName(lastName: String): Boolean =
            findStudentByLastName(lastName)
                    ?.let {
                        studentRepository.delete(it)
                        return true
                    }
                    ?: let {
                        logger.info { "No student found to delete with lastName=$lastName" }
                        return false
                    }

}
