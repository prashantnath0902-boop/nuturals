package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.RestartAlt
import androidx.compose.material.icons.outlined.Sort
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AppLanguage
import com.example.data.ProductFilterCriteria
import com.example.data.ProductRepository
import com.example.data.SortOption
import com.example.data.TranslationRepository
import com.example.model.Product
import com.example.model.ProductCategory
import com.example.ui.Screen
import com.example.ui.components.NuturalsFooter
import com.example.ui.components.ProductCard
import com.example.ui.components.SectionHeader
import com.example.ui.theme.BeigeBorder
import com.example.ui.theme.CardSurfaceLight
import com.example.ui.theme.Cream
import com.example.ui.theme.DarkCharcoal
import com.example.ui.theme.DarkCharcoalBody
import com.example.ui.theme.EditorialSerif
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldDark
import com.example.ui.theme.NaturalBeige
import com.example.ui.theme.WarmIvory
import com.example.ui.theme.WarmIvoryLight

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductsScreen(
  initialCategoryId: String = "all",
  initialOrigin: String? = null,
  currentLanguage: AppLanguage = AppLanguage.EN,
  onLanguageChange: (AppLanguage) -> Unit = {},
  onProductClick: (Product) -> Unit,
  onRequestQuote: (Product) -> Unit,
  onNavigate: (Screen) -> Unit,
  onWhatsAppClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  val initialCat = remember(initialCategoryId) {
    ProductCategory.values().find { it.id == initialCategoryId } ?: ProductCategory.ALL
  }

  var filterCriteria by remember {
    mutableStateOf(
      ProductFilterCriteria(
        category = initialCat,
        origin = initialOrigin
      )
    )
  }

  var isAdvancedFilterPanelOpen by remember { mutableStateOf(false) }
  var isSortMenuOpen by remember { mutableStateOf(false) }

  val filteredProducts = remember(filterCriteria) {
    ProductRepository.filterProducts(filterCriteria)
  }

  val originsList = remember { ProductRepository.getDistinctOrigins() }
  val availabilitiesList = remember { ProductRepository.getDistinctAvailabilities() }
  val formsList = remember { ProductRepository.getDistinctForms() }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("products_screen_list")
  ) {
    // Header & Search Bar
    item(key = "products_header") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(horizontal = 20.dp, vertical = 22.dp)
      ) {
        SectionHeader(
          eyebrow = "Product Catalog",
          title = "The NUTURALS Collection",
          subtitle = "Whole kernels, calibrated tree nuts, sun-dried fruits, and premium roasted superfoods prepared for commercial and export demand."
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Advanced Search Bar
        OutlinedTextField(
          value = filterCriteria.query ?: "",
          onValueChange = { filterCriteria = filterCriteria.copy(query = it) },
          placeholder = { Text(t("search_placeholder"), fontSize = 13.sp) },
          leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null, tint = ForestGreenPrimary)
          },
          trailingIcon = {
            if (!filterCriteria.query.isNullOrBlank()) {
              IconButton(onClick = { filterCriteria = filterCriteria.copy(query = "") }) {
                Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.Gray)
              }
            }
          },
          modifier = Modifier
            .fillMaxWidth()
            .testTag("product_search_input"),
          singleLine = true,
          shape = RoundedCornerShape(2.dp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = ForestGreenPrimary,
            unfocusedBorderColor = BeigeBorder,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
          )
        )
      }
    }

    // Category Tabs Bar
    item(key = "category_tabs") {
      val scrollState = rememberScrollState()
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .background(WarmIvory)
          .horizontalScroll(scrollState)
          .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        ProductCategory.values().forEach { category ->
          val isSelected = category == filterCriteria.category
          Box(
            modifier = Modifier
              .clip(RoundedCornerShape(2.dp))
              .background(if (isSelected) ForestGreenDark else Color.White)
              .border(
                width = 0.8.dp,
                color = if (isSelected) ForestGreenDark else BeigeBorder,
                shape = RoundedCornerShape(2.dp)
              )
              .clickable { filterCriteria = filterCriteria.copy(category = category) }
              .padding(horizontal = 14.dp, vertical = 7.dp)
              .testTag("filter_category_${category.id}")
          ) {
            Text(
              text = category.displayName.uppercase(),
              style = MaterialTheme.typography.labelSmall.copy(
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                letterSpacing = 1.sp,
                color = if (isSelected) WarmIvory else DarkCharcoal
              )
            )
          }
        }
      }
    }

    // Facet Filter Action Bar (Origin, Sort, Filter Toggle & Clear)
    item(key = "filter_actions_bar") {
      Surface(
        modifier = Modifier.fillMaxWidth(),
        color = WarmIvoryLight,
        shadowElevation = 0.5.dp
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          // Toggle Advanced Filters Button
          Row(
            modifier = Modifier
              .clip(RoundedCornerShape(2.dp))
              .background(if (isAdvancedFilterPanelOpen) ForestGreenPrimary else Cream)
              .border(0.8.dp, if (isAdvancedFilterPanelOpen) ForestGreenPrimary else BeigeBorder, RoundedCornerShape(2.dp))
              .clickable { isAdvancedFilterPanelOpen = !isAdvancedFilterPanelOpen }
              .padding(horizontal = 12.dp, vertical = 7.dp)
              .testTag("toggle_filters_button"),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Outlined.Tune,
              contentDescription = null,
              tint = if (isAdvancedFilterPanelOpen) Color.White else ForestGreenDark,
              modifier = Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Filters",
              style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Bold,
                color = if (isAdvancedFilterPanelOpen) Color.White else ForestGreenDark
              )
            )
            if (filterCriteria.activeFilterCount > 0) {
              Spacer(modifier = Modifier.width(6.dp))
              Box(
                modifier = Modifier
                  .size(18.dp)
                  .clip(CircleShape)
                  .background(if (isAdvancedFilterPanelOpen) MutedGold else ForestGreenDark),
                contentAlignment = Alignment.Center
              ) {
                Text(
                  text = "${filterCriteria.activeFilterCount}",
                  style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isAdvancedFilterPanelOpen) ForestGreenDark else Color.White
                  )
                )
              }
            }
          }

          // Sort Dropdown
          Box {
            Row(
              modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .background(Cream)
                .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp))
                .clickable { isSortMenuOpen = true }
                .padding(horizontal = 10.dp, vertical = 7.dp)
                .testTag("sort_dropdown_button"),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(Icons.Outlined.Sort, contentDescription = null, tint = ForestGreenDark, modifier = Modifier.size(15.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = filterCriteria.sortBy.label,
                style = MaterialTheme.typography.labelSmall.copy(color = ForestGreenDark, fontWeight = FontWeight.Medium)
              )
              Icon(Icons.Default.ArrowDropDown, contentDescription = null, tint = ForestGreenDark, modifier = Modifier.size(16.dp))
            }

            DropdownMenu(
              expanded = isSortMenuOpen,
              onDismissRequest = { isSortMenuOpen = false }
            ) {
              SortOption.values().forEach { sort ->
                DropdownMenuItem(
                  text = {
                    Text(
                      text = sort.label,
                      fontWeight = if (sort == filterCriteria.sortBy) FontWeight.Bold else FontWeight.Normal,
                      color = if (sort == filterCriteria.sortBy) ForestGreenPrimary else DarkCharcoal
                    )
                  },
                  onClick = {
                    filterCriteria = filterCriteria.copy(sortBy = sort)
                    isSortMenuOpen = false
                  }
                )
              }
            }
          }

          // Clear Filters (if active)
          if (filterCriteria.activeFilterCount > 0) {
            Row(
              modifier = Modifier
                .clickable { filterCriteria = ProductFilterCriteria() }
                .padding(horizontal = 6.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(Icons.Outlined.RestartAlt, contentDescription = null, tint = MutedGoldDark, modifier = Modifier.size(14.dp))
              Spacer(modifier = Modifier.width(3.dp))
              Text(
                text = t("clear_filters"),
                style = MaterialTheme.typography.labelSmall.copy(color = MutedGoldDark, fontWeight = FontWeight.Bold)
              )
            }
          }
        }
      }
    }

    // Expandable Multi-Facet Filter Drawer
    item(key = "advanced_filter_drawer") {
      AnimatedVisibility(
        visible = isAdvancedFilterPanelOpen,
        enter = expandVertically() + fadeIn(),
        exit = shrinkVertically() + fadeOut()
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(NaturalBeige.copy(alpha = 0.4f))
            .border(0.5.dp, BeigeBorder)
            .padding(16.dp)
        ) {
          // 1. Origin Filter Chips
          Text(
            text = "FILTER BY ORIGIN",
            style = MaterialTheme.typography.labelSmall.copy(
              color = ForestGreenDark,
              fontWeight = FontWeight.Bold,
              letterSpacing = 1.2.sp
            )
          )
          Spacer(modifier = Modifier.height(6.dp))
          FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            originsList.forEach { orig ->
              val isSelected = (orig == "All Origins" && (filterCriteria.origin.isNullOrBlank() || filterCriteria.origin == "All Origins")) ||
                  filterCriteria.origin == orig
              FilterChipItem(
                label = orig,
                isSelected = isSelected,
                onClick = {
                  filterCriteria = filterCriteria.copy(origin = if (orig == "All Origins") null else orig)
                }
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // 2. Availability Filter Chips
          Text(
            text = "AVAILABILITY STATUS",
            style = MaterialTheme.typography.labelSmall.copy(
              color = ForestGreenDark,
              fontWeight = FontWeight.Bold,
              letterSpacing = 1.2.sp
            )
          )
          Spacer(modifier = Modifier.height(6.dp))
          FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            availabilitiesList.forEach { avail ->
              val isSelected = (avail == "All Statuses" && (filterCriteria.availability.isNullOrBlank() || filterCriteria.availability == "All Statuses")) ||
                  filterCriteria.availability == avail
              FilterChipItem(
                label = avail,
                isSelected = isSelected,
                onClick = {
                  filterCriteria = filterCriteria.copy(availability = if (avail == "All Statuses") null else avail)
                }
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // 3. Form / Processing Cuts
          Text(
            text = "FORM & PROCESSING SPECIFICATION",
            style = MaterialTheme.typography.labelSmall.copy(
              color = ForestGreenDark,
              fontWeight = FontWeight.Bold,
              letterSpacing = 1.2.sp
            )
          )
          Spacer(modifier = Modifier.height(6.dp))
          FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            formsList.forEach { form ->
              val isSelected = (form == "All Forms" && (filterCriteria.form.isNullOrBlank() || filterCriteria.form == "All Forms")) ||
                  filterCriteria.form == form
              FilterChipItem(
                label = form,
                isSelected = isSelected,
                onClick = {
                  filterCriteria = filterCriteria.copy(form = if (form == "All Forms") null else form)
                }
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))
          Button(
            onClick = { isAdvancedFilterPanelOpen = false },
            colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
            shape = RoundedCornerShape(2.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text("Apply Filters & Close", color = Color.White)
          }
        }
      }
    }

    // Results Counter Strip
    item(key = "results_counter") {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "${filteredProducts.size} OF ${ProductRepository.products.size} SPECIFICATIONS FOUND",
          style = MaterialTheme.typography.labelSmall.copy(
            color = MutedGoldDark,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp
          )
        )
        Text(
          text = t("price_on_request"),
          style = MaterialTheme.typography.bodySmall.copy(
            color = DarkCharcoalBody.copy(alpha = 0.7f),
            fontSize = 11.5.sp
          )
        )
      }
    }

    // Product Items or Empty State
    if (filteredProducts.isEmpty()) {
      item(key = "empty_state") {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "No matching products found",
            style = MaterialTheme.typography.titleMedium.copy(fontFamily = EditorialSerif, color = ForestGreenDark)
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "Try adjusting your search keywords, origin selection, or availability filters.",
            style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody)
          )
          Spacer(modifier = Modifier.height(16.dp))
          Button(
            onClick = { filterCriteria = ProductFilterCriteria() },
            colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
            shape = RoundedCornerShape(2.dp)
          ) {
            Text(t("clear_filters"), color = Color.White)
          }
        }
      }
    } else {
      items(filteredProducts, key = { it.id }) { product ->
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
          ProductCard(
            product = product,
            onCardClick = { onProductClick(product) },
            onRequestQuote = { onRequestQuote(product) }
          )
        }
      }
    }

    // Footer
    item(key = "products_footer") {
      Spacer(modifier = Modifier.height(24.dp))
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = { onNavigate(Screen.Contact) },
        onWhatsAppClick = onWhatsAppClick,
        currentLanguage = currentLanguage,
        onLanguageChange = onLanguageChange
      )
    }
  }
}

@Composable
private fun FilterChipItem(
  label: String,
  isSelected: Boolean,
  onClick: () -> Unit
) {
  Box(
    modifier = Modifier
      .clip(RoundedCornerShape(2.dp))
      .background(if (isSelected) ForestGreenDark else Color.White)
      .border(
        width = 0.8.dp,
        color = if (isSelected) ForestGreenDark else BeigeBorder,
        shape = RoundedCornerShape(2.dp)
      )
      .clickable { onClick() }
      .padding(horizontal = 10.dp, vertical = 5.dp)
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      if (isSelected) {
        Icon(Icons.Outlined.Check, contentDescription = null, tint = MutedGold, modifier = Modifier.size(11.dp))
        Spacer(modifier = Modifier.width(4.dp))
      }
      Text(
        text = label,
        style = MaterialTheme.typography.labelSmall.copy(
          fontSize = 11.sp,
          fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
          color = if (isSelected) WarmIvory else DarkCharcoal
        )
      )
    }
  }
}
