package com.timertiti.titi.data.db

import androidx.room.RoomDatabase

@androidx.room.Database(entities = arrayOf(User::class), version = 1)
abstract class Database: RoomDatabase() {
    abstract fun userDao(): UserDao
}