package com.dio.santander.bankline.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.dio.santander.bankline.adapter.BankStatementAdapter
import com.dio.santander.bankline.databinding.ActivityBankStatementBinding
import com.dio.santander.bankline.domain.Correntista
import com.dio.santander.bankline.domain.Movimentacao
import com.dio.santander.bankline.domain.TipoMovimentacao

class BankStatementActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ACCOUNT_HOLDER =
            "com.dio.santander.bankline.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(
            EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()
    }

    private fun findBankStatement() {
        val dataSet = ArrayList<Movimentacao>()
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Salario",
            10000.0, TipoMovimentacao.RECEITA, 1))

        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Salario",
            10000.0, TipoMovimentacao.RECEITA, 1))

        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Salario",
            10000.0, TipoMovimentacao.RECEITA, 1))

        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Salario",
            10000.0, TipoMovimentacao.RECEITA, 1))

        binding.rvBankStatement.adapter = BankStatementAdapter(dataSet)
    }
}