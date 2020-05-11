package com.chiraranw.gitviewcommandservice.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "views")
data class View(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null, var login: String? = null, var firstRepo: String? = null)
data class Repo(@JsonProperty("name") var name:String?=null)