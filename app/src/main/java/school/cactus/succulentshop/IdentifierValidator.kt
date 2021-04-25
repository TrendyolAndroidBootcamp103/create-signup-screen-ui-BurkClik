package school.cactus.succulentshop


class IdentifierValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        field.length !in 4..51 -> R.string.identifier_is_too_short
        !field.contains('@') || !field.contains('.') -> R.string.email_is_invalid
        else -> null
    }
}