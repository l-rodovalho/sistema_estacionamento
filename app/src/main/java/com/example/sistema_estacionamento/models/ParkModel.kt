package com.example.sistema_estacionamento.models

class ParkModel {

    var name: String = ""
        get() = field
        set(value){
            field = value
        }

    var id: String = ""
        get() = field
        set(value) {
            field = value
        }

    constructor(id: String, name: String){
        this.id = id;
        this.name = name;
    }
}