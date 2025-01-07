package com.example.sistema_estacionamento

class Vaga {
    var id: String = ""
        get() = field
        set(value) {
            field = value
        }

    var nome: String = ""
        get() = field
        set(value) {
            field = value
        }

    constructor(id: String, nome: String) {
        this.id = id
        this.nome = nome
    }
}