Service("Logistics Status") {
    belongsTo BoundedContext("Fulfillment"), {
        description = """receives, processes and provides status updates 
                         from the logistics like cancellations, shipments, 
                         and returns"""
    }

    consumes DomainEvent("Order created")
    consumes DomainEvent("Order accepted")
    consumes DomainEvent("Order rejected")

    emits DomainEvent("Order cancelled")
    emits DomainEvent("Positions shipped")
    emits DomainEvent("Positions returned")
}