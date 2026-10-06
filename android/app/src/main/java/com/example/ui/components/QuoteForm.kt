package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BrandConfig
import com.example.ui.QuoteFormState
import com.example.ui.theme.BeigeBorder
import com.example.ui.theme.Cream
import com.example.ui.theme.DarkCharcoal
import com.example.ui.theme.DarkCharcoalBody
import com.example.ui.theme.EditorialSerif
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldDark
import com.example.ui.theme.WarmIvoryLight

@Composable
fun QuoteForm(
  formState: QuoteFormState,
  onFormChange: (
    fullName: String?,
    companyName: String?,
    businessEmail: String?,
    phoneWhatsApp: String?,
    country: String?,
    businessType: String?,
    productsInterestedIn: String?,
    approximateQuantity: String?,
    packagingRequirement: String?,
    message: String?
  ) -> Unit,
  onSubmit: () -> Unit,
  onReset: () -> Unit,
  modifier: Modifier = Modifier
) {
  var isBusinessTypeMenuOpen by remember { mutableStateOf(false) }

  Surface(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(4.dp))
      .border(1.dp, BeigeBorder, RoundedCornerShape(4.dp))
      .testTag("quote_enquiry_form"),
    color = WarmIvoryLight,
    shadowElevation = 1.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
    ) {
      if (formState.isSubmittedSuccess) {
        // Confirmation Success State
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Box(
            modifier = Modifier
              .size(64.dp)
              .clip(CircleShape)
              .background(ForestGreenDark),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Default.CheckCircle,
              contentDescription = "Success",
              tint = MutedGold,
              modifier = Modifier.size(36.dp)
            )
          }

          Spacer(modifier = Modifier.height(18.dp))

          Text(
            text = "Thank you.",
            style = MaterialTheme.typography.headlineMedium.copy(
              fontFamily = EditorialSerif,
              color = ForestGreenDark,
              fontSize = 26.sp
            )
          )

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = "Your enquiry has been received. Our team will get back to you shortly.",
            style = MaterialTheme.typography.bodyLarge.copy(
              color = DarkCharcoalBody,
              textAlign = TextAlign.Center,
              fontSize = 15.sp,
              lineHeight = 22.sp
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
          )

          Spacer(modifier = Modifier.height(24.dp))

          Button(
            onClick = onReset,
            colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
            shape = RoundedCornerShape(2.dp)
          ) {
            Text("Submit Another Inquiry", color = Color.White)
          }
        }
      } else {
        // Form Title
        Text(
          text = "LET'S BUILD SOMETHING GOOD TOGETHER.",
          style = MaterialTheme.typography.headlineMedium.copy(
            fontFamily = EditorialSerif,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            color = ForestGreenDark
          )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
          text = "Direct RFQ submission to the NUTURALS commercial trade desk for wholesale, export, or private-label solutions.",
          style = MaterialTheme.typography.bodyMedium.copy(
            color = DarkCharcoalBody.copy(alpha = 0.8f),
            fontSize = 13.5.sp
          )
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (formState.errorMessage != null) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFFDE8E8), RoundedCornerShape(2.dp))
              .border(0.8.dp, Color(0xFFF09B9B), RoundedCornerShape(2.dp))
              .padding(10.dp)
          ) {
            Text(
              text = formState.errorMessage,
              style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF9E1C1C))
            )
          }
          Spacer(modifier = Modifier.height(14.dp))
        }

        // Full Name
        FormTextField(
          label = "Full Name *",
          value = formState.fullName,
          onValueChange = { onFormChange(it, null, null, null, null, null, null, null, null, null) },
          testTag = "quote_input_fullname"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Company Name
        FormTextField(
          label = "Company Name",
          value = formState.companyName,
          placeholder = "e.g., Global Foods Ltd.",
          onValueChange = { onFormChange(null, it, null, null, null, null, null, null, null, null) },
          testTag = "quote_input_company"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Business Email & Phone/WhatsApp (side-by-side or stacked)
        FormTextField(
          label = "Business Email *",
          value = formState.businessEmail,
          placeholder = "procurement@company.com",
          onValueChange = { onFormChange(null, null, it, null, null, null, null, null, null, null) },
          testTag = "quote_input_email"
        )

        Spacer(modifier = Modifier.height(12.dp))

        FormTextField(
          label = "Phone / WhatsApp *",
          value = formState.phoneWhatsApp,
          placeholder = "+91 91512 90000 / +1 ...",
          onValueChange = { onFormChange(null, null, null, it, null, null, null, null, null, null) },
          testTag = "quote_input_phone"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Country
        FormTextField(
          label = "Country / Destination Port",
          value = formState.country,
          placeholder = "e.g., India, UAE, UK, Singapore",
          onValueChange = { onFormChange(null, null, null, null, it, null, null, null, null, null) },
          testTag = "quote_input_country"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Business Type Dropdown
        Column(modifier = Modifier.fillMaxWidth()) {
          Text(
            text = "Business Type",
            style = MaterialTheme.typography.labelSmall.copy(
              color = ForestGreenDark,
              fontWeight = FontWeight.Bold,
              fontSize = 11.sp
            )
          )
          Spacer(modifier = Modifier.height(4.dp))
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(Cream.copy(alpha = 0.4f), RoundedCornerShape(2.dp))
              .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp))
              .clickable { isBusinessTypeMenuOpen = true }
              .padding(horizontal = 12.dp, vertical = 13.dp)
              .testTag("quote_dropdown_business_type")
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = formState.businessType,
                style = MaterialTheme.typography.bodyMedium.copy(color = DarkCharcoal)
              )
              Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Select Business Type",
                tint = ForestGreenDark
              )
            }

            DropdownMenu(
              expanded = isBusinessTypeMenuOpen,
              onDismissRequest = { isBusinessTypeMenuOpen = false }
            ) {
              BrandConfig.BUSINESS_TYPES.forEach { bType ->
                DropdownMenuItem(
                  text = { Text(bType) },
                  onClick = {
                    onFormChange(null, null, null, null, null, bType, null, null, null, null)
                    isBusinessTypeMenuOpen = false
                  }
                )
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Products Interested In
        FormTextField(
          label = "Products Interested In",
          value = formState.productsInterestedIn,
          placeholder = "e.g., California Almonds, Jumbo Cashews W240, Golden Raisins",
          onValueChange = { onFormChange(null, null, null, null, null, null, it, null, null, null) },
          testTag = "quote_input_products"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Approximate Quantity
        FormTextField(
          label = "Approximate Quantity",
          value = formState.approximateQuantity,
          placeholder = "e.g., 500 kg, 2 Metric Tons, 1 x 20ft FCL",
          onValueChange = { onFormChange(null, null, null, null, null, null, null, it, null, null) },
          testTag = "quote_input_quantity"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Packaging Requirement
        FormTextField(
          label = "Packaging Requirement",
          value = formState.packagingRequirement,
          placeholder = "e.g., 25kg bulk cartons, 500g nitrogen-flushed retail pouches",
          onValueChange = { onFormChange(null, null, null, null, null, null, null, null, it, null) },
          testTag = "quote_input_packaging"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Message
        FormTextField(
          label = "Message / Specific Requirements",
          value = formState.message,
          placeholder = "Please include any target grades, delivery timelines, or test parameters...",
          singleLine = false,
          maxLines = 4,
          onValueChange = { onFormChange(null, null, null, null, null, null, null, null, null, it) },
          testTag = "quote_input_message"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
          onClick = onSubmit,
          enabled = !formState.isSubmitting,
          colors = ButtonDefaults.buttonColors(
            containerColor = ForestGreenPrimary,
            contentColor = Color.White
          ),
          shape = RoundedCornerShape(2.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("quote_submit_button")
        ) {
          if (formState.isSubmitting) {
            CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
          } else {
            Text(
              text = "REQUEST A QUOTE",
              style = MaterialTheme.typography.labelLarge.copy(
                letterSpacing = 1.5.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
              )
            )
          }
        }
      }
    }
  }
}

@Composable
private fun FormTextField(
  label: String,
  value: String,
  onValueChange: (String) -> Unit,
  placeholder: String = "",
  singleLine: Boolean = true,
  maxLines: Int = 1,
  testTag: String
) {
  Column(modifier = Modifier.fillMaxWidth()) {
    Text(
      text = label,
      style = MaterialTheme.typography.labelSmall.copy(
        color = ForestGreenDark,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp
      )
    )
    Spacer(modifier = Modifier.height(4.dp))
    OutlinedTextField(
      value = value,
      onValueChange = onValueChange,
      placeholder = {
        if (placeholder.isNotBlank()) {
          Text(text = placeholder, style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray))
        }
      },
      singleLine = singleLine,
      maxLines = maxLines,
      modifier = Modifier
        .fillMaxWidth()
        .testTag(testTag),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = ForestGreenPrimary,
        unfocusedBorderColor = BeigeBorder,
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Cream.copy(alpha = 0.25f)
      ),
      shape = RoundedCornerShape(2.dp)
    )
  }
}
