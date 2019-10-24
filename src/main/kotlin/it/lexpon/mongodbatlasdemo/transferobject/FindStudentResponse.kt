package it.lexpon.mongodbatlasdemo.transferobject

import it.lexpon.mongodbatlasdemo.domainobject.Student

data class FindStudentResponse(
        val id: String,
        val lastName: String
) {

    companion object {
        fun fromStudent(student: Student?): FindStudentResponse? =
                student?.let {
                    FindStudentResponse(
                            id = it.id,
                            lastName = it.lastName
                    )
                }
    }

}
