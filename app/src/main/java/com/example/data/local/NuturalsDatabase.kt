package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.model.QuoteEnquiry

@Database(entities = [QuoteEnquiry::class], version = 1, exportSchema = false)
abstract class NuturalsDatabase : RoomDatabase() {
  abstract fun quoteDao(): QuoteDao

  companion object {
    @Volatile
    private var INSTANCE: NuturalsDatabase? = null

    fun getDatabase(context: Context): NuturalsDatabase {
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          NuturalsDatabase::class.java,
          "nuturals_database"
        ).fallbackToDestructiveMigration().build()
        INSTANCE = instance
        instance
      }
    }
  }
}
