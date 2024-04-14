package com.example.cafe.models

data class Order (
    var id: String,
    var id_producto: String,
    var nombre_platillo: String,
    var cantidad: String,
    var total: String,
    var cliente: String,
    var id_iest: String,
    var hora: String,
    var fecha: String,
    var estado: String,
    var area: String,
)