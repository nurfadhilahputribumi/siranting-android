package com.siranting.siranting.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.siranting.siranting.models.User
import kotlinx.coroutines.tasks.await

class AuthRepository {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun register(
        name: String,
        phone: String,
        email: String,
        password: String
    ): Result<String> {
        return try {

            // Membuat akun Firebase Authentication
            val result = auth
                .createUserWithEmailAndPassword(email, password)
                .await()

            val uid = result.user!!.uid

            // Menyimpan data user ke Firestore
            val user = User(
                uid = uid,
                name = name,
                phone = phone,
                email = email,
                role = "patient"
            )

            firestore.collection("users")
                .document(uid)
                .set(user)
                .await()

            Result.success(uid)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun login(
        email: String,
        password: String
    ): Result<String> {
        return try {

            val result = auth
                .signInWithEmailAndPassword(email, password)
                .await()

            Result.success(result.user!!.uid)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}