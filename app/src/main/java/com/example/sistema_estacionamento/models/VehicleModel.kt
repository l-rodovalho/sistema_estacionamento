package com.example.sistema_estacionamento.models

class VehicleModel {

    var plate: String = ""
        get() = field
        set(value){
            field = value
        }

    constructor(plate: String){
        this.plate = plate;
    }

}