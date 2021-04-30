package school.cactus.succulentshop.signup

import androidx.annotation.StringRes
import school.cactus.succulentshop.R
import school.cactus.succulentshop.Validator

class UsernameValidator : Validator {
    @StringRes
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.username_is_required
        field.length < 3 -> R.string.username_is_too_short
        field.length > 20 -> R.string.username_is_too_long
        // '_' leri 'a' ile değiştirerek string olarak davranmalarını sağlıyorum.
        // Bu şekilde sadece isLetterOrDigit ile özel karakter olup olmadığını
        // kontrol etme imkanım oluyor.
        !field.replace('_', 'a').all { it.isLetterOrDigit() } -> R.string.username_not_consist
        else -> null
    }
}