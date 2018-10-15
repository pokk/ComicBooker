package com.no1.taiwan.comicbooker.data.datas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_LONG
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_STR
import com.no1.taiwan.comicbooker.ext.const.UniqueId

@Entity(tableName = "table_booker")
data class BookerData(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: UniqueId = DEFAULT_LONG,
    @ColumnInfo(name = "name")
    val name: String = DEFAULT_STR
) : Data
