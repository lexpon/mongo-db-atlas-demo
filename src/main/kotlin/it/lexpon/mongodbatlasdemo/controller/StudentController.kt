package it.lexpon.mongodbatlasdemo.controller

import it.lexpon.mongodbatlasdemo.service.StudentService
import it.lexpon.mongodbatlasdemo.transferobject.CreateStudentRequest
import it.lexpon.mongodbatlasdemo.transferobject.CreateStudentResponse
import it.lexpon.mongodbatlasdemo.transferobject.DeleteStudentResponse
import it.lexpon.mongodbatlasdemo.transferobject.FindStudentResponse
import mu.KLogging
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/student")
class StudentController(
        private val studentService: StudentService
) {

    companion object : KLogging()

    @PostMapping
    fun createStudent(@RequestBody createStudentRequest: CreateStudentRequest): CreateStudentResponse =
            createStudentRequest
                    .also { logger.info { "Create student for request=$createStudentRequest" } }
                    .let { studentService.createStudent(it) }
                    .let { CreateStudentResponse.fromStudent(it) }
                    .also { logger.info { "Created student: $it" } }

    @GetMapping("/{lastName}")
    fun findStudentByLastName(@PathVariable lastName: String): FindStudentResponse? =
            lastName
                    .also { logger.info { "Finding student with lastName=$it" } }
                    .let { studentService.findStudentByLastName(it) }
                    .let { FindStudentResponse.fromStudent(it) }
                    .also { logger.info { "Found student for lastName=$lastName: $it" } }

    @DeleteMapping("/{lastName}")
    fun deleteStudentByLastName(@PathVariable lastName: String): DeleteStudentResponse =
            lastName
                    .also { logger.info { "Deleting student with lastName=$it" } }
                    .let { studentService.deleteStudentByLastName(it) }
                    .also { logger.info { "Deleting student with lastName=$lastName was successful: $it" } }
                    .let { DeleteStudentResponse.fromBoolean(it) }
}
