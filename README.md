code-your-model-example
===

This is an example project for the [code-your-model](https://github.com/innoq/code-your-model) library.

The meta model is located under `src/main/groovy`

The model files are located under `src/model/groovy`

## usage

To build this project run

    gradlew build
    
To start a local neo4j database run

    ./scripts/run-local-neo4j.sh

The `ImportModel.groovy` script (located in `src/main/groovy/` in package `com.innoq.codeyourmodel.example`) imports all 
model files into the neo4j database. It can be executed via gradle task 

    gradlew importModel
        
To view the model in neo4j open the [neo4j browser](http://localhost:7474) and execute the following cypher query
    
    MATCH (n) RETURN n

You can use the model directly within the neo4j DB (by executing cypher queries)

e.g. to select (and return) all `DomainEvent` nodes execute

    MATCH (n:DomainEvent) RETURN n 
    
or to select all `Service` nodes that emit or consume a particular `DomainEvent`

    MATCH (s:Service) -- (e:DomainEvent{name:"Order accepted"}) RETURN s, e    

Alternatively, you can write a groovy script that uses the `ModelRepository` to
retrieve the required data and for example render it to the console. 
The `UseModel.groovy` script (located in `src/main/groovy/` in package `com.innoq.codeyourmodel.example`) gives a simple 
example. It can be executed via gradle task

    gradlew useModel

To stop the local neo4j docker container lookup its container id and execute

    docker stop <container id>

If you run the `import-model.sh|.groovy` script, all existing nodes and relationships within the neo4j DB
are deleted before the model is imported. If you want to clean up the existing data indipendent from the import 
execute the following cypher query

    MATCH (n) DETACH DELETE n
