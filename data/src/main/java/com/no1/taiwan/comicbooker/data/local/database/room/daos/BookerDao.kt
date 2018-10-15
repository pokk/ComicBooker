package com.no1.taiwan.comicbooker.data.local.database.room.daos

import androidx.room.Dao
import androidx.room.Query
import com.no1.taiwan.comicbooker.data.datas.BookerData

@Dao
interface BookerDao {
    @Query("SELECT * FROM table_booker")
    fun getAllData(): List<BookerData>
}
