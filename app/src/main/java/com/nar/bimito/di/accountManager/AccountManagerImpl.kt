package com.nar.bimito.di.accountManager

import android.accounts.Account
import android.app.Activity
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AccountManagerImpl @Inject constructor(@ApplicationContext private val context: Context) :
    AccountManager {
    private val KEY_ACCOUNT_DATA = "com.nar.bimito.di.accountManager.AccountManager_key_data"

    init {
        getAccount(context)
    }

    private var account: AccountData? = null

    override fun saveAccount(accountData: AccountData, context: Context) {
        if (isLogin(context)) {
            removeAccount(context)
        }
        val accountManager: android.accounts.AccountManager =
            android.accounts.AccountManager.get(context)
        //     removeAccount(context)
        val gson = Gson()
        val data = Bundle()
        data.putString(
            KEY_ACCOUNT_DATA,
            gson.toJson(accountData)
        )
        var accountType = ""
        val applicationInfo = context.packageManager.getApplicationInfo(
            context.packageName,
            PackageManager.GET_META_DATA
        )
        accountType = applicationInfo.metaData.getString("account_type").toString()
        accountManager.addAccountExplicitly(
            Account(getApplicationName(context), accountType),
            "bimito",
            data
        )
        account = accountData
    }

    override fun getAccount(context: Context): AccountData {
        if (account == null) {
            val accountManager: android.accounts.AccountManager =
                android.accounts.AccountManager.get(context)
            var accountType = ""
            try {
                val applicationInfo = context.packageManager.getApplicationInfo(
                    context.packageName,
                    PackageManager.GET_META_DATA
                )
                accountType = applicationInfo.metaData.getString("account_type").toString()
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            account = try {
                val account =
                    accountManager.getAccountsByType(accountType)[0]
                val g = accountManager.getUserData(
                    account,
                    KEY_ACCOUNT_DATA
                )
                Gson().fromJson(g, AccountData::class.java)
            } catch (e: Exception) {
                AccountData("")
            }
        }
        return account!!
    }

    override fun removeAccount(context: Context) {
        try {
            val accountManager: android.accounts.AccountManager =
                android.accounts.AccountManager.get(context)
            val accounts = getDeviceAccounts(context)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                for (account in accounts) {
                    accountManager.removeAccount(account, context as Activity, null, null)
                }
            } else for (account in accounts) {
                accountManager.removeAccount(account, null, null)
            }
            account = null
        } catch (e: Exception) {

        }
    }

    private fun getApplicationName(context: Context): String {
        val packageManager = context.packageManager
        var applicationInfo: ApplicationInfo? = null
        try {
            applicationInfo =
                packageManager.getApplicationInfo(context.applicationInfo.packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
        }
        return (if (applicationInfo != null) packageManager.getApplicationLabel(applicationInfo) else "Unknown") as String
    }

    override fun isLogin(context: Context): Boolean {
        val acc = getAccount(context)
        return acc.token.isNotEmpty()
    }

    private fun getDeviceAccounts(context: Context): Array<Account> {
        var accountType = ""
        try {
            val applicationInfo = context.packageManager.getApplicationInfo(
                context.packageName,
                PackageManager.GET_META_DATA
            )
            accountType = applicationInfo.metaData.getString("account_type").toString()
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        val accountManager: android.accounts.AccountManager =
            android.accounts.AccountManager.get(context)
        return accountManager.getAccountsByType(accountType)
    }
}