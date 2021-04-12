package com.nar.bimito.common.util

enum class PatternStrings(val regex: Regex) {
    EMAIL_PATTERN("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$".toRegex()),
    USERNAME_PATTERN("[._a-zA-Z0-9]{4,25}".toRegex()),
    NATIONAL_CARD_PATTERN("([1]{10}|[2]{10}|[3]{10}|[4]{10}|[5]{10}|[6]{10}|[7]{10}|[8]{10}|[9]{10})$".toRegex()),
    PASSWORD_PATTERN("^(?=.*[0-9])(?=.*[a-zA-z]).{6,225}$".toRegex()),
    WEBSITE_PATTERN("(https?://)?([a-zA-Z]\\w*\\.)+[a-zA-Z]\\w*(\\:\\d+)?(/\\w+)*(\\.\\w+)?/?(\\?([a-zA-Z]\\w*=\\w*&)*([a-zA-Z]\\w*=\\w*))?".toRegex()),
    VERIFICATION_CODE_PATTERN("[0-9]{5,}".toRegex()),
    NAME_PATTERN(".{2,50}".toRegex())
}