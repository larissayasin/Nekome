package com.chesire.nekome.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chesire.nekome.core.flags.Service
import com.chesire.nekome.core.models.UserModel
import kotlinx.coroutines.flow.Flow

/**
 * Dao to interact with user data.
 */
@Dao
interface UserDao {
    /**
     * Deletes the user [user].
     */
    @Delete
    suspend fun delete(user: UserModel)

    /**
     * Deletes the user based on the [service].
     */
    @Query("DELETE FROM usermodel WHERE service == :service")
    suspend fun delete(service: Service)

    /**
     * Inserts the user [user], replacing it if it already exists.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserModel)

    /**
     * Retrieves the user based on the [service].
     */
    @Query("SELECT * FROM usermodel WHERE service == :service")
    suspend fun retrieve(service: Service): UserModel

    /**
     * Retrieves the userID based on the [service].
     */
    @Query("SELECT userId FROM usermodel WHERE service == :service")
    suspend fun retrieveUserId(service: Service): Int?

    /**
     * Provides an observable for the type of [service].
     */
    @Query("SELECT * FROM usermodel WHERE service == :service")
    fun getUser(service: Service): Flow<UserModel>
}
