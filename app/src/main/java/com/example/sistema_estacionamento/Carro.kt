package com.example.sistema_estacionamento

class Carro {
    var modelo: String = ""
        get() = field
        set(value) {
            field = value
        }

    var placa: String = ""
        get() = field
        set(value) {
            field = value
        }

    var status: String = ""
        get() = field
        set(value) {
            field = value
        }

    constructor(modelo: String, placa: String, status: String) {
        this.modelo = modelo
        this.placa = placa
        this.status = status
    }
}