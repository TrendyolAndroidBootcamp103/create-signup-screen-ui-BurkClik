package school.cactus.succulentshop.signup

import org.junit.Assert.*

import junit.framework.TestCase
import org.junit.Test
import school.cactus.succulentshop.R

class SignUpEmailValidatorTest() {
    private val emailValidator = SignUpEmailValidator()

    @Test
    fun `should return email is required given email is blank`() {
        // Given
        val email = ""

        // When
        val actualResult = emailValidator.validate(email)

        // Then
        assertEquals(R.string.this_field_is_required, actualResult)
    }

    @Test
    fun `should return email is invalid given email is not contain @`() {
        // Given
        val email = "burk.clik.com"

        // When
        val actualResult = emailValidator.validate(email)

        // Then
        assertEquals(R.string.email_is_invalid, actualResult)
    }

    @Test
    fun `should return email is invalid given email is not contain dot`() {
        // Given
        val email = "burkclik@gmailcom"

        // When
        val actualResult = emailValidator.validate(email)

        // Then
        assertEquals(R.string.email_is_invalid, actualResult)
    }

    @Test
    fun `should return email is invalid given email is not longer than 5 characters`() {
        // Given
        val email = "@a.tr"

        // When
        val actualResult = emailValidator.validate(email)

        // Then
        assertEquals(R.string.email_is_invalid, actualResult)
    }

    @Test
    fun `should return email is invalid given email is not shorter than 50 characters`() {
        // Given
        val email = "burk.clik@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"

        // When
        val actualResult = emailValidator.validate(email)

        // Then
        assertEquals(R.string.email_is_invalid, actualResult)
    }

    @Test
    fun `should return null given email is valid`() {
        // Given
        val email = "burk.clik@gmail.com"

        // When
        val actualResult = emailValidator.validate(email)

        // Then
        assertNull(actualResult)
    }
}