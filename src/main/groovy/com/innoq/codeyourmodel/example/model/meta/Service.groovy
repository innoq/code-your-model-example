package com.innoq.codeyourmodel.example.model.meta

import com.innoq.codeyourmodel.core.meta2.Element


class Service extends Element {

    static relationshipDefinitions = {
        consumes(DomainEvent) {
            reverse("consumedBy")
            attributes(description: String)
        }

        emits(DomainEvent) {
            reverse("emittedBy")
            attributes(description: String)
        }

        belongsTo(BoundedContext) { attributes(description: String) }
    }

}
