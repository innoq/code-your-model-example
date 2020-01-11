package com.innoq.codeyourmodel.example.model.meta

import com.innoq.codeyourmodel.core.meta2.Element


class BoundedContext extends Element {

    static relationshipDefinitions = {
        belongsTo(Subdomain)
    }

}
