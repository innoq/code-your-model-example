package com.innoq.codeyourmodel.example.model.meta

import com.innoq.codeyourmodel.core.meta2.Element


class Subdomain extends Element {

    Type type

    enum Type {
        Core, Supporting, Generic
    }

}
