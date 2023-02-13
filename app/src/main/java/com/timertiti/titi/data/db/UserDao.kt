package com.timertiti.titi.data.db

import androidx.room.*
import java.util.*

@Dao
interface UserDao {

    @TypeConverters
    @Update
    suspend fun updateTime(user:User)

    @TypeConverters
    @Query("SELECT * FROM User WHERE date = :date")
    suspend fun selectUser(date: String): User?

    @TypeConverters
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: User)

    @TypeConverters
    @Query("DELETE FROM User WHERE date = :date")
    suspend fun deleteUser(date: String)
}