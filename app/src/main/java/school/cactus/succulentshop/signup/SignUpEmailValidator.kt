package school.cactus.succulentshop.signup

import androidx.annotation.StringRes
import school.cactus.succulentshop.R
import school.cactus.succulentshop.Validator

class SignUpEmailValidator : Validator {
    @StringRes
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        !field.contains('@') || !field.contains('.')
                || field.length !in 6..50 -> R.string.email_is_invalid
        else -> null
    }
}