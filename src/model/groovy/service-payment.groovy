Service("Payment") {
    belongsTo BoundedContext("Payment"), {
        description = """handles the payment transactions 
                         (authorization/capture/refund)"""
    }

    consumes DomainEvent("Order accepted")
    consumes DomainEvent("Order cancelled")
    consumes DomainEvent("Debit calculated")
    consumes DomainEvent("Credit calculated")

    emits DomainEvent("Order authorized")
    emits DomainEvent("Debit captured")
    emits DomainEvent("Credit refunded")
}