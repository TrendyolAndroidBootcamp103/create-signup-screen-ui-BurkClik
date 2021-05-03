package school.cactus.succulentshop.signup

import org.junit.Assert.*

import junit.framework.TestCase
import org.junit.Test
import school.cactus.succulentshop.R

class UsernameValidatorTest() {
    private val usernameValidator = UsernameValidator()

    @Test
    fun `should return username is required given password is empty`() {
        // Given
        val username = ""

        // When
        val actualResult = usernameValidator.validate(username)

        // Then
        assertEquals(R.string.username_is_required, actualResult)
    }

    @Test
    fun `should return username is too short given username shorter than 3`() {
        // Given
        val username = "aa"

        // When
        val actualResult = usernameValidator.validate(username)

        // Then
        assertEquals(R.string.username_is_too_short, actualResult)
    }

    @Test
    fun `should return username is too long given username longer than 20`() {
        // Given
        val username = "longstringlongstrings"

        // When
        val actualResult = usernameValidator.validate(username)

        // Then
        assertEquals(R.string.username_is_too_long, actualResult)
    }

    @Test
    fun `should return username can only include a-z, 0-9 and _ characters given username not consist of them`() {
        // Given
        val username = "burak@"

        // When
        val actualResult = usernameValidator.validate(username)

        // Then
        assertEquals(R.string.username_not_consist, actualResult)
    }

    @Test
    fun `should return null given username is valid`() {
        // Given
        val username = "Burak_Burak"

        // When
        val actualResult = usernameValidator.validate(username)

        // Then
        assertNull(actualResult)
    }
}