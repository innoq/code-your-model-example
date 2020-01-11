Service("Order Audit") {
    belongsTo BoundedContext("Risk Assessment"), {
        description = """verifies all incoming orders, tries to approve them 
                         automatically, provides the order details for manual
                         approval/rejection"""
    }

    consumes DomainEvent("Order created")

    emits DomainEvent("Order rejected")
    emits DomainEvent("Order accepted")
}