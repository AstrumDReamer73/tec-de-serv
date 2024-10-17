package com.example.cursoSBP.dataSource.mock

import com.example.cursoSBP.dataSource.BancoDataSource
import com.example.cursoSBP.model.Banco
import org.springframework.stereotype.Repository

@Repository class MockDataSourceBanco: BancoDataSource {
    val bancos = mutableListOf(Banco("", 0.0, 1));

    override fun getBancos(): Collection<Banco> = bancos

    override fun getBanco(accountNumber: String): Banco=bancos.first{it.accountNumber==accountNumber}

    override fun insertarBancos(banco: Banco): Banco {
        if (bancos.any { it.accountNumber == banco.accountNumber }) { throw IllegalArgumentException("el banco con el numero de cuenta ${banco.accountNumber} ya existe") }
        bancos.add(banco)
        return banco
    }

    override fun modificarBanco(banco: Banco): Banco {
        val bancoActual = bancos.firstOrNull { it.accountNumber == banco.accountNumber }
            ?: throw NoSuchElementException("no existe un banco con el numero de cuenta ${banco.accountNumber}")
        bancos.remove(bancoActual)
        bancos.add(banco)
        return banco
    }

    override fun eliminarBanco(accountNumber: String) {
        val bancoActual = bancos.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("no existe un banco con el numero de cuenta ${accountNumber}")
        bancos.remove(bancoActual)
    }
}