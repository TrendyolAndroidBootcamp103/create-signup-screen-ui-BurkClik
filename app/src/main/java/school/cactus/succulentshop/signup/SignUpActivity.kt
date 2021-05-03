package school.cactus.succulentshop.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.IdentifierValidator
import school.cactus.succulentshop.LoginActivity
import school.cactus.succulentshop.databinding.ActivitySignUpBinding
import java.lang.IllegalArgumentException

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    private val emailValidator = SignUpEmailValidator()
    private val usernameValidator = UsernameValidator()
    private val passwordValidator = SignUpPasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Sign Up"
        binding.apply {
            buttonToLoginScreen.setOnClickListener { navigateToLoginActivity() }
            buttonSignUp.setOnClickListener {
                textInputLayoutEmail.validate()
                textInputLayoutUsername.validate()
                textInputLayoutPassword.validate()
            }
        }
    }

    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.textInputLayoutEmail -> emailValidator
        binding.textInputLayoutUsername -> usernameValidator
        binding.textInputLayoutPassword -> passwordValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }
}