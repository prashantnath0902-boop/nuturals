package com.example.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote_enquiries")
data class QuoteEnquiry(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0L,
  val fullName: String,
  val companyName: String,
  val businessEmail: String,
  val phoneWhatsApp: String,
  val country: String,
  val businessType: String,
  val productsInterestedIn: String,
  val approximateQuantity: String,
  val packagingRequirement: String,
  val message: String,
  val timestamp: Long = System.currentTimeMillis(),
  val status: String = "Received"
)
