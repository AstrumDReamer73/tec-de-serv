package com.example.cursoSBP.servicios

import com.example.cursoSBP.dataSource.BancoDataSource
import com.example.cursoSBP.model.Banco
import org.springframework.stereotype.Service

@Service class ServicioBanco(private val dataSource: BancoDataSource) {
    fun getBancos():Collection<Banco> = dataSource.getBancos()

    fun getBanco(accountNumber:String):Banco=dataSource.getBanco(accountNumber)

    fun insertarBanco(banco: Banco):Banco=dataSource.insertarBancos(banco)

    fun modificarBanco(banco: Banco): Banco = dataSource.modificarBanco(banco)

    fun eliminarBanco(accountNumber: String):Unit=dataSource.eliminarBanco(accountNumber)
}