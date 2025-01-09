package com.example.sistema_estacionamento.models

class ParkModel {

    var name: String = ""
        get() = field
        set(value){
            field = value
        }

    constructor(name: String){
        this.name = name;
    }
}