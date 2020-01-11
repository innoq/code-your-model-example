BoundedContext("Invoicing") {
    belongsTo Subdomain("Payment")
}

BoundedContext("Payment") {
    belongsTo Subdomain("Payment")
}

BoundedContext("Risk Assessment") {
    belongsTo Subdomain("Risk Management")
}

BoundedContext("Fulfillment") {
    belongsTo Subdomain("Fulfillment")
}
