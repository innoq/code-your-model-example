Service("Invoicing") {
    belongsTo BoundedContext("Invoicing"), {
        description = """calculates the debit/credit amounts for shipments 
                         and returns, creates invoices for the customer"""
    }

    consumes DomainEvent("Positions shipped")
    consumes DomainEvent("Positions returned")

    emits DomainEvent("Debit calculated")
    emits DomainEvent("Credit calculated")
    emits DomainEvent("Invoice created")
}