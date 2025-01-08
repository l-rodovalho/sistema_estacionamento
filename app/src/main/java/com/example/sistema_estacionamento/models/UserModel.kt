package com.example.sistema_estacionamento.models

class UserModel {

    var id: String = ""
        get() = field
        set(value) {
            field = value;
        }

    var name: String = ""
        get() = field
        set(value) {
            field = value;
        }

    var email: String = ""
        get() = field
        set(value) {
            field = value;
        }

    var accessToken: String = ""
        get() = field
        set(value) {
            field = value;
        }

    constructor(id: String, name: String, email: String, accessToken: String) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accessToken = accessToken;
    }

}