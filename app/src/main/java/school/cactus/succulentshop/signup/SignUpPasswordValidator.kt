package school.cactus.succulentshop.signup

import androidx.annotation.StringRes
import school.cactus.succulentshop.R
import school.cactus.succulentshop.Validator

class SignUpPasswordValidator : Validator {
    @StringRes
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_required
        field.length > 40 -> R.string.password_is_too_long
        field.length < 8 -> R.string.password_is_too_short
        field.all { it.isLetterOrDigit() }
                || !field.any { it.isDigit() }
                || !field.any { it.isUpperCase() }
                || !field.any { it.isLowerCase() } -> R.string.password_contain_check
        else -> null
    }
}