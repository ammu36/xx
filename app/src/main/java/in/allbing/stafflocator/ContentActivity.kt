package `in`.allbing.stafflocator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ContentActivity : AppCompatActivity() {


    private val TAG = "PostDetailActivity"
    val dbRef = FirebaseDatabase.getInstance().getReference()
    val uid: String = "manoj"
    val userRef = dbRef.child("users").child(uid).child("current_place")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)


    }

    override fun onStart() {
        super.onStart()


        // Add value event listener to the post
        userRef.addValueEventListener(object :  ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                val value = p0.getValue(String::class.java)
                //Log.d(TAG, value)
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }
    fun changePlaceClicked(view: View){

    }
    fun changeTimeClicked(view: View){

    }
}