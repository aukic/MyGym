package ferit.project.mygym.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList


@Entity(tableName = "trainings")
class Training(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "date")
    var dateOfTraining: Date,
    @ColumnInfo(name = "group")
    var exerciseGroup:String?,
    @ColumnInfo(name = "exercises")
    var exerciseList: ArrayList<String>? ){}