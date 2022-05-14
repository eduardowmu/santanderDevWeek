package com.dio.santander.bankline.data.remote

import com.dio.santander.bankline.domain.Movimentacao
import retrofit2.http.GET
import retrofit2.http.Path

interface BanklineApi {
    @GET("/movimentacoes/{idConta}")
    suspend fun findBankStatement(@Path("idConta") idConta:Int):List<Movimentacao>
}