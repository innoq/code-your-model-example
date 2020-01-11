@Grab("com.innoq:code-your-model:0.1")
@Grab("org.neo4j.driver:neo4j-java-driver:1.7.5")

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
