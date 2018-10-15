package com.no1.taiwan.comicbooker.data.local.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devrapid.kotlinshaver.isNotNull
import com.no1.taiwan.comicbooker.data.datas.BookerData
import com.no1.taiwan.comicbooker.data.local.database.room.daos.BookerDao

@Database(entities = [BookerData::class], version = 1)
abstract class BookerDatabase : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "booker.db"
        private var instance: BookerDatabase? = null
        fun getInstance(context: Context): BookerDatabase {
            if (instance.isNotNull()) {
                instance =
                    Room.databaseBuilder(context.applicationContext, BookerDatabase::class.java, DATABASE_NAME).build()
            }

            return requireNotNull(instance)
        }
    }

    abstract fun contactsDao(): BookerDao
}
