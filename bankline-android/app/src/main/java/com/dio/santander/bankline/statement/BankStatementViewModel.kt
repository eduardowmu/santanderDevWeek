package com.dio.santander.bankline.statement

import androidx.lifecycle.ViewModel
import com.dio.santander.bankline.data.BanklineRepository

class BankStatementViewModel : ViewModel() {
    fun findBankStatement(accountHolderId: Int) =
        BanklineRepository.findBankStatement(accountHolderId)
}