package `in`.allbing.stafflocator

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.staff_login.*


class MainActivity : AppCompatActivity() {
    private val TAG = "MyActivity"
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staff_login)

        auth = FirebaseAuth.getInstance()
    }
    public override fun onStart(){
        super.onStart()
        val currentUser = auth.currentUser
      if (currentUser != null){

        }
    }
    private fun signIn(email: String, password: String)
    {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    intent = Intent(this, ContentActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
    }


    fun onSignInClicked(view: View){
        signIn(fieldEmail.getText().toString(), fieldPassword.getText().toString())


    }

    private fun validateForm(): Boolean {
        var valid = true
        val email: String = fieldEmail.getText().toString()
        if (TextUtils.isEmpty(email)) {
            fieldEmail.setError("Required.")
            valid = false
        } else {
            fieldEmail.setError(null)
        }
        val password: String = fieldPassword.getText().toString()
        if (TextUtils.isEmpty(password)) {
            fieldPassword.setError("Required.")
            valid = false
        } else {
            fieldPassword.setError(null)
        }
        return valid
    }
}
