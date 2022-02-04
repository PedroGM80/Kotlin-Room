package com.dbRecords

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class UserViewModel(application: Application) : ViewModel() {
    private val db: RoomSingleton = RoomSingleton.getInstance(application)
    internal val allUsers: LiveData<List<User>> = db.userDao().allUsers()
    fun insert(student: User) {
        db.userDao().insert(student)
    }
}
