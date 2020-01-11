code-your-model-example
===

This is an example project for the [code-your-model](https://github.com/innoq/code-your-model) library.

The sample meta model is located under `src/main/groovy`

The sample model files are located under `src/model/groovy`

## usage

To start a local neo4j database run

    ./scripts/run-local-neo4j.sh

The `./scripts/import-model.groovy` scripts imports all model files into the neo4j database. 
It can be executed via 

    ./scripts/import-model.sh
        
To view the model in neo4j open the [neo4j browser](http://localhost:7474) and execute the following cipher query
    
    MATCH (n) RETURN n

You can use the model directly within the neo4j DB (by executing cipher queries)

e.g. to select (and return) all DomainEvent nodes execute

    MATCH (n:DomainEvent) RETURN n 
    
or to select all Services that emit or consume a particular DomainEvent

    MATCH (s:Service) -- (e:DomainEvent{name:"Order accepted"}) RETURN s, e    

Alternatively, you can write a groovy script that uses the `ModelRepository` to
retrieve the required data and for example render it to the console. 
The `./scripts/use-model.groovy` script gives a simple example.  
It can be executed via 

    ./scripts/use-model.sh
  
To stop the local neo4j docker container lookup its container id and execute

    docker stop <container id>

If you run the `import-model.sh|.groovy` script, all existing nodes and relationships within the neo4j DB
are deleted before the model is imported. If you want to clean up the existing data indipendent from the import 
execute the following cipher query

    MATCH (n) DETACH DELETE n
