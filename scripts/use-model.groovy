@Grab("com.innoq:code-your-model:0.1")
@Grab("org.neo4j.driver:neo4j-java-driver:1.7.5")

import com.innoq.codeyourmodel.example.model.meta.*
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