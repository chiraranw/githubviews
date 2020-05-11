package com.chiraranw.gitviewcommandservice.coreapi

import org.axonframework.modelling.command.TargetAggregateIdentifier

//Commands
data class  ViewReposCommand(@TargetAggregateIdentifier var id:String?=null, var login:String?=null, var firstRepo:String?=null)

//Events
data class  ReposViewedEvent(val id:String, val login:String, val firstRepo:String)
