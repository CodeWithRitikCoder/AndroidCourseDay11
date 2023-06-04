package com.ritikcoder.project11ofandroidcoursewithsaumyasingh_advanceuiuxwithdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ritikcoder.project11ofandroidcoursewithsaumyasingh_advanceuiuxwithdatabase.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonForSignUp.setOnClickListener(){
            val name= binding.textInputEditTextForName.text.toString()
            val userName= binding.textInputEditTextForUserName.text.toString()
            val password= binding.textInputEditTextForPassword.text.toString()
            val email= binding.textInputEditTextForEmail.text.toString()

            val userKotlinDataClass= User(name, userName, password, email)
            database= FirebaseDatabase.getInstance().getReference("Users")
            database.child(userName).setValue(userKotlinDataClass).addOnSuccessListener {
                binding.textInputEditTextForName.text?.clear()
                binding.textInputEditTextForUserName.text?.clear()
                binding.textInputEditTextForPassword.text?.clear()
                binding.textInputEditTextForEmail.text?.clear()

                Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()
            }.addOnCanceledListener {
                Toast.makeText(this, "User Failed", Toast.LENGTH_SHORT).show()
            }

        }

    }
}