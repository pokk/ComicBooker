package com.no1.taiwan.comicbooker.data.local.services

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.no1.taiwan.comicbooker.data.datas.BookerData
import com.no1.taiwan.comicbooker.data.local.v1.BookerDao

/**
 * The access operations to a database.
 */
@Database(entities = [BookerData::class], version = 1)
abstract class BookerDatabase : RoomDatabase() {
    companion object {
        @Volatile private var INSTANCE: BookerDatabase? = null
        private const val DATABASE_NAME = "booker.db"

        fun getDatabase(context: Context): BookerDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookerDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance

                return instance
            }
        }
    }

    abstract fun contactsDao(): BookerDao
}
