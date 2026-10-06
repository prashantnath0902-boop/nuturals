package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.model.QuoteEnquiry
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertEnquiry(enquiry: QuoteEnquiry): Long

  @Query("SELECT * FROM quote_enquiries ORDER BY timestamp DESC")
  fun getAllEnquiries(): Flow<List<QuoteEnquiry>>

  @Query("SELECT COUNT(*) FROM quote_enquiries")
  fun getEnquiriesCount(): Flow<Int>
}
