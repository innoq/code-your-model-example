package com.innoq.codeyourmodel.example

import com.innoq.codeyourmodel.core.ModelReader
import com.innoq.codeyourmodel.example.model.meta.*
import com.innoq.codeyourmodel.neo4j.Neo4JModelRepository

def modelFiles = new File("./src/model/groovy").listFiles()

new Neo4JModelRepository("bolt://localhost:7687", "neo4j", "test").withCloseable {
    it.clear()
    new ModelReader(it)
            .registerElementType(Subdomain)
            .registerElementType(BoundedContext)
            .registerElementType(Service)
            .registerElementType(DomainEvent)
            .read(modelFiles)
}
