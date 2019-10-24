package it.lexpon.mongodbatlasdemo.transferobject

import it.lexpon.mongodbatlasdemo.domainobject.Student

data class CreateStudentResponse(
        val id: String,
        val lastName: String
) {
    companion object {
        fun fromStudent(student: Student): CreateStudentResponse = CreateStudentResponse(
                id = student.id,
                lastName = student.lastName
        )
    }
}
