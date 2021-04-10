package com.nar.bimito.di.accountManager

import android.content.Context

interface AccountManager {
    fun saveAccount(accountData: AccountData, context: Context)
    fun getAccount(context: Context): AccountData
    fun removeAccount(context: Context)
    fun isLogin(context: Context): Boolean
}