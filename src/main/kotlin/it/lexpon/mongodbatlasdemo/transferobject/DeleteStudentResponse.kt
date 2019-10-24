package it.lexpon.mongodbatlasdemo.transferobject

data class DeleteStudentResponse(
        val deleted: Boolean
) {
    companion object {
        fun fromBoolean(boolean: Boolean): DeleteStudentResponse = DeleteStudentResponse(boolean)
    }
}
