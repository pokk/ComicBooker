package com.no1.taiwan.comicbooker.data.local.v1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.no1.taiwan.comicbooker.data.datas.BookerData

@Dao
interface BookerDao {
    @Query("SELECT * FROM table_booker")
    fun getAllData(): List<BookerData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooker(booker: BookerData): Long
}
