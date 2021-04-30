package school.cactus.succulentshop.signup

import org.junit.Assert.*

import junit.framework.TestCase
import org.junit.Test
import school.cactus.succulentshop.R

class SignUpPasswordValidatorTest() {
    private val passwordValidator = SignUpPasswordValidator()

    @Test
    fun `should return password is requires given password is empty`() {
        // Given
        val password = ""

        // When
        val actualResult = passwordValidator.validate(password)

        // Then
        assertEquals(R.string.password_required, actualResult)
    }

    @Test
    fun `should return password is too short given password not longer than 7 characters`() {
        // Given
        val password = "seven"

        // When
        val actualResult = passwordValidator.validate(password)

        // Then
        assertEquals(R.string.password_is_too_short, actualResult)
    }

    @Test
    fun `should return password is too long given password not shorter than 40 characters`() {
        // Given
        val password = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

        // When
        val actualResult = passwordValidator.validate(password)

        // Then
        assertEquals(R.string.password_is_too_long, actualResult)
    }

    @Test
    fun `should return password contain check given password is not contain digit`() {
        // Given
        val password = "Trendyol@"

        // When
        val actualResult = passwordValidator.validate(password)

        // Then
        assertEquals(R.string.password_contain_check, actualResult)
    }

    @Test
    fun `should return password contain check given password is not contain lowercase letter`() {
        // Given
        val password = "TRENDYOL@2"

        // When
        val actualResult = passwordValidator.validate(password)

        // Then
        assertEquals(R.string.password_contain_check, actualResult)
    }

    @Test
    fun `should return password contain check given password is not contain uppercase letter`() {
        // Given
        val password = "trendyol@2"

        // When
        val actualResult = passwordValidator.validate(password)

        // Then
        assertEquals(R.string.password_contain_check, actualResult)
    }

    @Test
    fun `should return password contain check given password is not contain special character`() {
        // Given
        val password = "Trendyol2"

        // When
        val actualResult = passwordValidator.validate(password)

        // Then
        assertEquals(R.string.password_contain_check, actualResult)
    }

    @Test
    fun `should return null given password is valid`() {
        // Given
        val password = "Trendyol@2"

        // When
        val actualResult = passwordValidator.validate(password)

        // Then
        assertNull(null, actualResult)
    }
}