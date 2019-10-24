package it.lexpon.mongodbatlasdemo.domainobject

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Student(

        @Id
        val id: String,

        @Indexed
        val lastName: String
)
