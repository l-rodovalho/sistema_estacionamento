package com.example.sistema_estacionamento.models

class ParkModel {

    var name: String = ""
        get() = field
        set(value){
            field = value
        }

    var owned: Boolean = false
        get() = field
        set(value) {
            field = value;
        }

    var id: String = ""
        get() = field
        set(value) {
            field = value
        }

    constructor(id: String, name: String, owned: Boolean){
        this.id = id;
        this.name = name;
        this.owned = owned;
    }
}