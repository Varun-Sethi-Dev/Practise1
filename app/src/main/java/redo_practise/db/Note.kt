package redo_practise.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_Table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Int =0,
    @ColumnInfo(name = "message")
    val message:String="",
    @ColumnInfo(name = "heading")
    val heading:String =""
)