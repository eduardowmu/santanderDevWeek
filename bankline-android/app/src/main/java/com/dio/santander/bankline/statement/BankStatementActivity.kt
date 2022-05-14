package com.dio.santander.bankline.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dio.santander.bankline.adapter.BankStatementAdapter
import com.dio.santander.bankline.data.State
import com.dio.santander.bankline.databinding.ActivityBankStatementBinding
import com.dio.santander.bankline.domain.Correntista
import com.dio.santander.bankline.domain.Movimentacao
import com.dio.santander.bankline.domain.TipoMovimentacao
import com.google.android.material.snackbar.Snackbar

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

    private val viewModel by viewModels<BankStatementViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()
    }

    private fun findBankStatement() {
        viewModel.findBankStatement(accountHolder.id).observe(this) {
            state -> when(state) {
                is State.Success -> {
                    binding.rvBankStatement.adapter = state.data?.let {
                        BankStatementAdapter(it)
                    }
                    binding.srlBankStatement.isRefreshing = false
                }
                is State.Error -> {
                    state.message?.let {
                        Snackbar.make(binding.rvBankStatement, it,
                            Snackbar.LENGTH_LONG).show()
                    }
                    binding.srlBankStatement.isRefreshing = true
                }
                State.Wait -> binding.srlBankStatement.isRefreshing = true
            }
        }
    }
}