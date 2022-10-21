package com.serapercel.todo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacakIs")
data class YapilacakIs(@PrimaryKey(autoGenerate = true)
                       @ColumnInfo(name = "yapilacak_is_id" ) @NotNull var yapilacak_is_id: Int,
                       @ColumnInfo(name = "yapilacak_is" ) @NotNull var yapilacak_is: String) : Serializable {
}