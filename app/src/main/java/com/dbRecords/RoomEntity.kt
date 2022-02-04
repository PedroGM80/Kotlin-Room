package com.dbRecords

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTbl")
data class User(
    @PrimaryKey
    var id: Long?,

    @ColumnInfo(name = "userId")
    var name: String
)