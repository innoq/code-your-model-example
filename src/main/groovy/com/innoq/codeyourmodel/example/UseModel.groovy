package com.innoq.codeyourmodel.example

import com.innoq.codeyourmodel.example.model.meta.DomainEvent
import com.innoq.codeyourmodel.neo4j.Neo4JModelRepository


new Neo4JModelRepository("bolt://localhost:7687", "neo4j", "test").withCloseable { modelRepository ->

    println "All Domain Events with their emitting and consuming Services"
    println "-----"

    modelRepository.findAll(DomainEvent)
            .sort { a, b -> a.name <=> b.name }
            .each {
                println "* ${it.class.simpleName} '${it.name}'"
                def emittedBy = modelRepository.findAllRelated(it, "emittedBy").collect {
                    "${it.class.simpleName} '${it.name}'"
                }.join(", ")
                println "    emitted by: $emittedBy"

                def consumedBy = modelRepository.findAllRelated(it, "consumedBy").collect {
                    "${it.class.simpleName} '${it.name}'"
                }.join(", ")
                println "    consumed by: $consumedBy"
            }

}