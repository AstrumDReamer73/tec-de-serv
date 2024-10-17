package com.example.cursoSBP.dataSource

import com.example.cursoSBP.model.Banco

interface BancoDataSource {
    fun getBancos():Collection<Banco>

    fun getBanco(accountNumber:String):Banco

    fun insertarBancos(banco: Banco): Banco

    fun modificarBanco(banco: Banco): Banco

    fun eliminarBanco(accountNumber: String)
}