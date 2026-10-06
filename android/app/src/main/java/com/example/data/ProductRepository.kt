package com.example.data

import com.example.model.Product
import com.example.model.ProductCategory
import com.example.model.ProductSpecification

object ProductRepository {

  val products: List<Product> = listOf(
    // -------------------------------------------------------------
    // CHAPTER I: THE ROYAL RESERVE NUTS & IMPERIAL TREE NUTS
    // -------------------------------------------------------------
    Product(
      id = "california-almonds",
      name = "Imperial Mamra Almonds",
      category = ProductCategory.NUTS,
      description = "Wild-harvested ancient Persian almonds from high-altitude groves, naturally sun-dried with peerless natural lipid content, supreme density, and buttery crunch.",
      origin = "USA",
      grade = "Sovereign Grade A+ Organic",
      availableForms = listOf("Whole Natural", "Blanched", "Hand-Sorted Kernels"),
      packagingOptions = listOf("250g Velvet-lined Tin", "1000g Wooden Cask", "25 lb Carton", "Custom Retail Pouches"),
      moq = "On Request (Standard: 1 Pallet / 50 Tins)",
      priceDisplay = "Price: On Request",
      sovereignPrice = "$250 / 250g",
      netWeight = "250g",
      chapter = "Chapter I: Royal Nuts & Dry Fruits",
      palatialNotes = "ORIGIN: HINDU KUSH • SOVEREIGN GRADE",
      applications = listOf("Connoisseur Retail", "Private Concierge", "Luxury Hospitality", "Gourmet Confectionery"),
      specifications = listOf(
        ProductSpecification("Natural Lipid Content", "54.2% Extra Rich"),
        ProductSpecification("Moisture Content", "Max 4.8%"),
        ProductSpecification("Sun Drying", "100% High-Altitude Solar Dried"),
        ProductSpecification("Storage Condition", "Cool & dry cellar (10°C - 14°C)")
      ),
      availability = "Allocated Sovereign Harvest",
      isFeatured = true,
      visualIconType = "almond"
    ),
    Product(
      id = "bronte-pistachios",
      name = "Bronte Emerald Pistachios",
      category = ProductCategory.NUTS,
      description = "Deep emerald kernels naturally opened and harvested exclusively under moonlight from volcanic foothills. Renowned for exceptional sweetness and striking visual appeal.",
      origin = "Mt. Etna, Sicily / Piedmont",
      grade = "Ultra-Rare Reserve Edition",
      availableForms = listOf("Peeled Emerald Kernels", "Naturally Opened In-Shell"),
      packagingOptions = listOf("250g Gold Embossed Tin", "500g Glass Decanter", "10 kg Master Vacuum Cask"),
      moq = "On Request (VIP Allocation)",
      priceDisplay = "$48 / 250g (Sovereign $290)",
      sovereignPrice = "$290 / 250g",
      netWeight = "250g",
      chapter = "Chapter I: Royal Nuts & Dry Fruits",
      palatialNotes = "ORIGIN: MT. ETNA • ULTRA-RARE RESERVE",
      applications = listOf("Fine Dining Pastry", "Luxury Retail", "Gelato Art", "Collector Cellars"),
      specifications = listOf(
        ProductSpecification("Soil Profile", "Volcanic Basalt Mineral Soils"),
        ProductSpecification("Harvest Method", "Nocturnal Moonlit Hand-Pick"),
        ProductSpecification("Pigment", "Natural Deep Chlorophyll Emerald"),
        ProductSpecification("Zero Oil Roast", "Dry roasted with ancient sea crystals")
      ),
      availability = "Strictly Allocated Reserve",
      isFeatured = true,
      visualIconType = "pistachio"
    ),
    Product(
      id = "vintage-macadamias",
      name = "Vintage Imperial Macadamias",
      category = ProductCategory.NUTS,
      description = "Extra-large buttery Australian kernels harvested at absolute peak maturity from volcanic soils, aged in humidity-controlled cedar vaults for buttery silkiness.",
      origin = "Byron Bay, Australia",
      grade = "Collector Grade Style 0 Super Jumbo",
      availableForms = listOf("Whole Raw Style 0", "Slow Dry-Roasted", "Cold-Pressed Macadamia Butter"),
      packagingOptions = listOf("250g Brass Tin", "500g Presentation Box", "10 kg Nitrogen Cask"),
      moq = "On Request",
      priceDisplay = "$52 / 250g (Sovereign $220)",
      sovereignPrice = "$220 / 250g",
      netWeight = "250g",
      chapter = "Chapter I: Royal Nuts & Dry Fruits",
      palatialNotes = "ORIGIN: BYRON BAY • CEDAR CURED",
      applications = listOf("Artisanal Snacking", "Haute Pâtisserie", "VIP Hospitality"),
      specifications = listOf(
        ProductSpecification("Kernel Sizing", "Style 0 (Exceeds 20mm diameter)"),
        ProductSpecification("Curing", "6-week humidity-controlled cedar vault cure"),
        ProductSpecification("Texture", "Buttery melt-in-mouth finish")
      ),
      availability = "In Stock / Regular Sovereign Supply",
      isFeatured = true,
      visualIconType = "hazelnut"
    ),
    Product(
      id = "royal-porcelain-walnuts",
      name = "Royal Porcelain Walnuts",
      category = ProductCategory.NUTS,
      description = "Immaculate extra-light jumbo butterfly halves with zero astringency, clean mellow finish, and exceptionally high omega fatty acids. Hand-cracked with artisanal care.",
      origin = "Kashmir / Andes Foothills",
      grade = "Extra Light Halves (80%+ Halves)",
      availableForms = listOf("Extra Light Jumbo Halves", "Quarter Pieces for Pâtisserie"),
      packagingOptions = listOf("250g Presentation Box", "1 kg Vacuum Tin", "10 kg Master Carton"),
      moq = "On Request",
      priceDisplay = "$38 / 250g (Sovereign $190)",
      sovereignPrice = "$190 / 250g",
      netWeight = "250g",
      chapter = "Chapter I: Royal Nuts & Dry Fruits",
      palatialNotes = "ORIGIN: KASHMIR • HAND CRACKED",
      applications = listOf("Brain Health Formulations", "Luxury Table Service", "Bespoke Gift Boxes"),
      specifications = listOf(
        ProductSpecification("Halves Percentage", "Min 85% Whole Halves"),
        ProductSpecification("Pellicle Color", "Porcelain Ivory / Light Amber"),
        ProductSpecification("Astringency", "Zero bitter tannin profile")
      ),
      availability = "Fresh Season Harvest",
      isFeatured = false,
      visualIconType = "walnut"
    ),
    Product(
      id = "premium-cashews",
      name = "Whole King Cashews (W-180)",
      category = ProductCategory.NUTS,
      description = "Magnificent King-size cashew kernels hand-sorted for uniform size, brilliant ivory color, and natural sweet creaminess.",
      origin = "India / Goa & Mangalore",
      grade = "W-180 (King Size, 180 kernels/lb)",
      availableForms = listOf("Whole White (W-180)", "Tumbled & Seasoned", "Slow Roasted"),
      packagingOptions = listOf("250g Luxury Tin", "10 kg Vacuum Tin", "50 lb Master Carton"),
      moq = "On Request (Standard: 1 Pallet)",
      priceDisplay = "Price: On Request",
      sovereignPrice = "$240 / 250g (Truffle & Gold)",
      netWeight = "250g",
      chapter = "Chapter I: Royal Nuts & Dry Fruits",
      palatialNotes = "ORIGIN: MALABAR COAST • HAND SORTED",
      applications = listOf("Luxury Retail", "Gift Hampers", "HORECA Royal Suite"),
      specifications = listOf(
        ProductSpecification("Count / lb", "160 - 180 kernels"),
        ProductSpecification("Moisture", "Max 4.5%"),
        ProductSpecification("Grading", "Zero scorched kernels")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = true,
      visualIconType = "cashew"
    ),

    // -------------------------------------------------------------
    // CHAPTER I (PART 2): EXOTIC DRY FRUITS & IMPERIAL DRY FRUIT COLLECTION
    // -------------------------------------------------------------
    Product(
      id = "24k-gold-medjool-dates",
      name = "24k Gold Medjool Dates",
      category = ProductCategory.DRIED_FRUITS,
      description = "King-grade succulent dates stuffed with candied orange peel and hand-dusted with 24k edible gold leaf. Caramel-like texture, naturally syrupy, from pristine desert oases.",
      origin = "Pristine Desert Oases",
      grade = "Palatial Edition • Crown Grade Succulent",
      availableForms = listOf("Gold-Dusted Whole", "Citrus-Stuffed", "Almond-Stuffed"),
      packagingOptions = listOf("500g Gold-Embossed Presentation Box", "1 kg Velvet Casket"),
      moq = "On Request (Palatial Collection)",
      priceDisplay = "$34 / 500g (Palatial $180)",
      sovereignPrice = "$180 / 500g",
      netWeight = "500g",
      chapter = "Chapter I: Royal Nuts & Dry Fruits",
      palatialNotes = "PALATIAL EDITION • 24K GOLD LEAF",
      applications = listOf("Royal Ceremonies", "Bespoke Concierge Gifting", "Luxury Suites"),
      specifications = listOf(
        ProductSpecification("Size Calibration", "Super Jumbo (24g+ per date)"),
        ProductSpecification("Skin Separation", "Below 3%"),
        ProductSpecification("Gilding", "Certified 24k Edible Gold Leaf")
      ),
      availability = "Limited Seasonal Batch",
      isFeatured = true,
      visualIconType = "date"
    ),
    Product(
      id = "muscat-aged-figs",
      name = "Golden Smyrna & Muscat-Aged Figs",
      category = ProductCategory.DRIED_FRUITS,
      description = "Sun-dried Aegean white figs plumped in rare dessert muscat wine and wild clover honey. Plump, tender texture with a delicate crunch and honeyed finish.",
      origin = "Aegean Coast, Turkey",
      grade = "Collector Grade • Garland Crown",
      availableForms = listOf("Garland Whole Figs", "Muscat Macerated", "Pressed Cake"),
      packagingOptions = listOf("400g Wax-Sealed Wooden Cask", "800g Presentation Box"),
      moq = "On Request",
      priceDisplay = "$32 / 400g (Aged $165)",
      sovereignPrice = "$165 / 400g",
      netWeight = "400g",
      chapter = "Chapter I: Royal Nuts & Dry Fruits",
      palatialNotes = "AGED IN MUSCAT • COLLECTOR GRADE",
      applications = listOf("Artisan Charcuterie", "Fine Wine Pairings", "Dessert Accents"),
      specifications = listOf(
        ProductSpecification("Moisture", "22% - 24% Natural Plumpness"),
        ProductSpecification("Sulfur Free", "100% Naturally Sun-Cured"),
        ProductSpecification("Aroma Profile", "Wild wildflower honey and sweet muscat")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = true,
      visualIconType = "fig"
    ),
    Product(
      id = "monukkha-green-raisins",
      name = "Monukkha Emerald Green Raisins",
      category = ProductCategory.DRIED_FRUITS,
      description = "Elongated, emerald-hued seedless grapes shade-dried in ancient cold stone cellars to preserve vibrant natural pigments and delicate, floral sweetness.",
      origin = "Kashmir & Central Asia",
      grade = "Select Jumbo AAA (Length 22mm+)",
      availableForms = listOf("Whole Green Shade-Dried", "Golden Amber Raisins"),
      packagingOptions = listOf("350g Glass Jar", "5 kg Master Carton", "10 kg Trade Bulk"),
      moq = "On Request",
      priceDisplay = "$26 / 350g",
      sovereignPrice = "$110 / 350g",
      netWeight = "350g",
      chapter = "Chapter I: Royal Nuts & Dry Fruits",
      palatialNotes = "STONE CELLAR DRIED • ZERO ADDITIVES",
      applications = listOf("Gourmet Breakfast", "Pastry Chefs", "Luxury Snack Mixes"),
      specifications = listOf(
        ProductSpecification("Length", "20mm - 25mm"),
        ProductSpecification("Processing", "Non-treated natural shade dry"),
        ProductSpecification("Texture", "Chewy and succulent")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "raisin"
    ),

    // -------------------------------------------------------------
    // CHAPTER II: RARE CONNOISSEUR SEEDS & THE IMPERIAL BOTANICAL SANCTUARY
    // -------------------------------------------------------------
    Product(
      id = "white-truffle-pumpkin-seeds",
      name = "White Truffle Styrian Pumpkin Seeds",
      category = ProductCategory.SEEDS_SUPERFOODS,
      description = "Heirloom hull-less dark emerald seeds roasted in rare white Alba truffle oil and Anglesey crystal salt. Rich in magnesium and zinc with exquisite umami depth.",
      origin = "Styria, Austria",
      grade = "Micro-Batch Heirloom Selection",
      availableForms = listOf("Truffle Roasted", "Raw Cold-Pressed Seeds"),
      packagingOptions = listOf("300g Dark Violet Glass Jar", "1 kg Foil Bag"),
      moq = "On Request",
      priceDisplay = "$28 / 300g (Sovereign $140)",
      sovereignPrice = "$140 / 300g",
      netWeight = "300g",
      chapter = "Chapter II: Rare Connoisseur Seeds",
      palatialNotes = "ORIGIN: AUSTRIA • TRUFFLE INFUSED",
      applications = listOf("Salad Accents", "Private Cellar Snacking", "Nutrition Toppings"),
      specifications = listOf(
        ProductSpecification("Variety", "Cucurbita pepo var. styriaca"),
        ProductSpecification("Chlorophyll Purity", "100% Dark Forest Green"),
        ProductSpecification("Infusion", "Genuine White Alba Truffle Extra Virgin Oil")
      ),
      availability = "Micro-Batch Allocation",
      isFeatured = true,
      visualIconType = "pumpkin_seed"
    ),
    Product(
      id = "imperial-jet-black-chia",
      name = "Imperial Jet-Black Chia Seeds",
      category = ProductCategory.SEEDS_SUPERFOODS,
      description = "Deep black certified organic chia seeds selected for maximum mucilaginous purity, hydration power, and unmatched antioxidant vitality.",
      origin = "Patagonia, South America",
      grade = "Master Reserve Raw Organic (99.9% Purity)",
      availableForms = listOf("Whole Black Chia", "Cold-Milled Bio-Available Powder"),
      packagingOptions = listOf("300g UV-Shield Pouch", "1 kg Nitrogen Tin", "25 kg Bulk Sack"),
      moq = "On Request",
      priceDisplay = "$24 / 300g (Reserve $120)",
      sovereignPrice = "$120 / 300g",
      netWeight = "300g",
      chapter = "Chapter II: Rare Connoisseur Seeds",
      palatialNotes = "ORIGIN: PATAGONIA • MASTER RESERVE",
      applications = listOf("Superfood Blends", "Clinical Nutrition", "Luxury Breakfast Bars"),
      specifications = listOf(
        ProductSpecification("Purity", "Min 99.9% Optical Sort"),
        ProductSpecification("Omega-3 (ALA)", "Exceeds 19g / 100g"),
        ProductSpecification("Hydration Gel Factor", "12x Weight Water Absorption")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "chia"
    ),
    Product(
      id = "golden-flax-reserve",
      name = "Golden Flax Reserve & Rosehip",
      category = ProductCategory.SEEDS_SUPERFOODS,
      description = "Cold-milled golden flax seeds infused with wild rosehip botanical oil and Bourbon vanilla pods. Exceptionally high ALA omega-3 concentration and delicate nutty aroma.",
      origin = "Living Botanicals, North America",
      grade = "Botanical Grade Living Cold Pressed",
      availableForms = listOf("Whole Golden Seed", "Fresh-Milled Powder"),
      packagingOptions = listOf("350g Ceramic Airtight Jar", "1 kg Foil Vacuum Bag"),
      moq = "On Request",
      priceDisplay = "$22 / 350g (Botanical $110)",
      sovereignPrice = "$110 / 350g",
      netWeight = "350g",
      chapter = "Chapter II: Rare Connoisseur Seeds",
      palatialNotes = "COLD PRESSED • BOTANICAL GRADE",
      applications = listOf("Nutraceuticals", "Smoothie Blends", "Wellness Confections"),
      specifications = listOf(
        ProductSpecification("ALA Content", "57% of total lipid profile"),
        ProductSpecification("Rosehip Bioflavonoids", "Naturally Active Vitamin C & E"),
        ProductSpecification("Processing", "Low-temperature vortex cold mill")
      ),
      availability = "Regular Freshly Milled Supply",
      isFeatured = false,
      visualIconType = "flax"
    ),
    Product(
      id = "ivory-hemp-hearts",
      name = "Ivory Hulled Hemp Hearts",
      category = ProductCategory.SEEDS_SUPERFOODS,
      description = "Pristine raw ivory hemp kernels offering complete plant protein with all 9 essential amino acids. Silken nutty texture with zero bitter hulls.",
      origin = "Canadian Rockies",
      grade = "Pristine Raw Harvest 99.9%",
      availableForms = listOf("Hulled Hearts", "Cold-Pressed Hemp Seed Oil"),
      packagingOptions = listOf("250g Nitrogen-Flushed Tin", "1 kg Vacuum Bag"),
      moq = "On Request",
      priceDisplay = "$30 / 250g (Sovereign $150)",
      sovereignPrice = "$150 / 250g",
      netWeight = "250g",
      chapter = "Chapter II: Rare Connoisseur Seeds",
      palatialNotes = "ORIGIN: CANADIAN ROCKIES • RAW",
      applications = listOf("High-Protein Culinary", "Vegan Cheese", "Functional Shakes"),
      specifications = listOf(
        ProductSpecification("Protein Content", "33g / 100g Complete Protein"),
        ProductSpecification("Omega-6 to Omega-3", "Optimal 3:1 Ratio"),
        ProductSpecification("Hull Remnants", "Under 0.05%")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "hemp"
    ),
    Product(
      id = "sargol-saffron-sunflower",
      name = "Sargol Saffron Sunflower Seeds",
      category = ProductCategory.SEEDS_SUPERFOODS,
      description = "Gently roasted organic sunflower hearts glazed with grade-one Persian Sargol saffron threads and raw acacia honey.",
      origin = "Persia & Mediterranean",
      grade = "Royal Saffron Glaze • Elite Batch",
      availableForms = listOf("Whole Glazed Hearts"),
      packagingOptions = listOf("250g Collector Tin", "500g Glass Decanter"),
      moq = "On Request",
      priceDisplay = "$32 / 250g (Elite $175)",
      sovereignPrice = "$175 / 250g",
      netWeight = "250g",
      chapter = "Chapter II: Rare Connoisseur Seeds",
      palatialNotes = "ROYAL SAFFRON GLAZE • ELITE BATCH",
      applications = listOf("Cocktail Garnish", "Private Tasting Bars", "VIP Amenities"),
      specifications = listOf(
        ProductSpecification("Saffron Grade", "Grade 1 Super Sargol (ISO 3632-1)"),
        ProductSpecification("Glaze Base", "Raw Monofloral Acacia Honey"),
        ProductSpecification("Roast Profile", "Slow artisan drum roast at 120°C")
      ),
      availability = "Limited Batch Production",
      isFeatured = true,
      visualIconType = "sunflower_seed"
    ),
    Product(
      id = "malabar-cardamom-seeds",
      name = "Malabar Cardamom Wildflower Seeds",
      category = ProductCategory.SEEDS_SUPERFOODS,
      description = "Tossed in rare Malabar green cardamom pods, pure Madagascar vanilla bean, and raw organic forest wildflower honey.",
      origin = "Malabar Coast, India",
      grade = "Artisanal Glaze • Natural Sweet",
      availableForms = listOf("Whole Roasted Spiced Seeds"),
      packagingOptions = listOf("300g Luxury Tin", "1 kg Master Pack"),
      moq = "On Request",
      priceDisplay = "$26 / 300g (Artisanal $130)",
      sovereignPrice = "$130 / 300g",
      netWeight = "300g",
      chapter = "Chapter II: Rare Connoisseur Seeds",
      palatialNotes = "MALABAR SPICE • ARTISANAL ROAST",
      applications = listOf("Gourmet Snacking", "Digestive Presentation", "Confectionery"),
      specifications = listOf(
        ProductSpecification("Cardamom Caliber", "8mm Jumbo Deep Green Pods"),
        ProductSpecification("Vanilla Origin", "Madagascar Bourbon Beans"),
        ProductSpecification("Honey Source", "Wild Western Ghats Forest Honey")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "sesame"
    ),

    // -------------------------------------------------------------
    // CHAPTER III: ARTISAN FLAVORED NUTS & THE IMPERIAL SPICE MASTERPIECES
    // -------------------------------------------------------------
    Product(
      id = "truffle-salt-cashews",
      name = "Black Truffle & Sea Salt Cashews",
      category = ProductCategory.SPECIALTY,
      description = "W-180 jumbo cashews bathed in rare Piedmont black truffle shavings and flake Maldon sea salt. Dusted with edible gold flakes for the Sovereign Reserve edition.",
      origin = "Piedmont, Italy / Malabar",
      grade = "Gourmet Reserve • Tumbled Batch",
      availableForms = listOf("Tumbled Jumbo Cashews"),
      packagingOptions = listOf("250g Gold Stamped Tin", "500g Decanter"),
      moq = "On Request",
      priceDisplay = "$42 / 250g (Sovereign $240)",
      sovereignPrice = "$240 / 250g",
      netWeight = "250g",
      chapter = "Chapter III: Artisan Flavored Nuts",
      palatialNotes = "PIEDMONT TRUFFLE • FLAKE MALDON SALT",
      applications = listOf("Michelin Star Lounges", "Corporate Gift Hampers", "Private Aviation"),
      specifications = listOf(
        ProductSpecification("Truffle Species", "Tuber melanosporum & Tuber magnatum"),
        ProductSpecification("Cashew Base", "King W-180 Jumbo Kernels"),
        ProductSpecification("Salt Type", "Maldon Pyramid Sea Flakes")
      ),
      availability = "Small-Batch Hand Tumbled",
      isFeatured = true,
      visualIconType = "cashew"
    ),
    Product(
      id = "pink-salt-bergamot-pistachios",
      name = "Himalayan Pink Salt & Bergamot Pistachios",
      category = ProductCategory.SPECIALTY,
      description = "Dry-roasted jumbo pistachios seasoned delicately with ancient Himalayan pink crystal salt and organic Calabrian bergamot essential oil. Zero oil roasted.",
      origin = "Calabria, Italy & Himalayas",
      grade = "Zero Oil • Bergamot Infused",
      availableForms = listOf("In-Shell Dry Roasted", "Shelled Kernels"),
      packagingOptions = listOf("250g Hermetic Canister", "500g Brass Tin"),
      moq = "On Request",
      priceDisplay = "$46 / 250g (Sovereign $260)",
      sovereignPrice = "$260 / 250g",
      netWeight = "250g",
      chapter = "Chapter III: Artisan Flavored Nuts",
      palatialNotes = "ZERO OIL • BERGAMOT INFUSED",
      applications = listOf("Digestive Lounges", "Fine Cocktail Pairings", "Wellness Suites"),
      specifications = listOf(
        ProductSpecification("Roast Method", "100% Hot Air Fluidized Bed (No Oil)"),
        ProductSpecification("Bergamot Extract", "Cold-expressed Calabrian Rind Oil"),
        ProductSpecification("Salt Minerals", "84 Natural Trace Minerals")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "pistachio"
    ),
    Product(
      id = "cinnamon-pecans",
      name = "Ceylon Cinnamon & Tonka Bean Pecans",
      category = ProductCategory.SPECIALTY,
      description = "Mammoth halves coated in organic Quebec maple syrup, genuine Sri Lankan Ceylon cinnamon, and toasted Madagascar tonka bean.",
      origin = "Madagascar & Sri Lanka",
      grade = "Artisan Glazed • Small Batch",
      availableForms = listOf("Glazed Mammoth Halves"),
      packagingOptions = listOf("250g Cedar Gift Box", "500g Gold Canister"),
      moq = "On Request",
      priceDisplay = "$40 / 250g (Sovereign $220)",
      sovereignPrice = "$220 / 250g",
      netWeight = "250g",
      chapter = "Chapter III: Artisan Flavored Nuts",
      palatialNotes = "TONKA BEAN GLAZE • SMALL BATCH",
      applications = listOf("Autumn & Winter Banquets", "Gourmet Dessert Toppings", "Bespoke Hampers"),
      specifications = listOf(
        ProductSpecification("Cinnamon Species", "Cinnamomum verum (Ceylon True Cinnamon)"),
        ProductSpecification("Syrup Grade", "Grade A Very Dark Maple Syrup"),
        ProductSpecification("Pecan Size", "Mammoth Halves (250-300 ct/lb)")
      ),
      availability = "Seasonal Artisan Batch",
      isFeatured = true,
      visualIconType = "walnut"
    ),
    Product(
      id = "smoked-rosemary-almonds",
      name = "Smoked Rosemary & Cognac Oak Almonds",
      category = ProductCategory.SPECIALTY,
      description = "Spanish Marcona almonds slow-smoked over reclaimed French cognac oak barrels with fresh garden rosemary and fleur de sel.",
      origin = "Spain / France",
      grade = "Cognac Oak Smoked • Spanish Gold",
      availableForms = listOf("Whole Smoked Marcona"),
      packagingOptions = listOf("250g Wax-Sealed Pouch", "500g Oak Canister"),
      moq = "On Request",
      priceDisplay = "$38 / 250g (Sovereign $230)",
      sovereignPrice = "$230 / 250g",
      netWeight = "250g",
      chapter = "Chapter III: Artisan Flavored Nuts",
      palatialNotes = "COGNAC OAK SMOKED • SPANISH GOLD",
      applications = listOf("Cigar Lounges", "Sommelier Pairings", "Craft Charcuterie"),
      specifications = listOf(
        ProductSpecification("Almond Variety", "Authentic Spanish Marcona"),
        ProductSpecification("Smoking Wood", "50-Year French Limousin Cognac Casks"),
        ProductSpecification("Herb", "Fresh Mediterranean Rosemary Needles")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "almond"
    ),
    Product(
      id = "saffron-macadamias",
      name = "Persian Sargol Saffron Macadamias",
      category = ProductCategory.SPECIALTY,
      description = "Buttery Australian macadamias infused with grade-one Sargol Persian saffron threads and cultured French Isigny butter.",
      origin = "Byron Bay & Khorasan",
      grade = "Ultra-Luxury Royal Edition",
      availableForms = listOf("Whole Butter-Infused Macadamias"),
      packagingOptions = listOf("200g Hand-blown Glass Jar with Gold Lid", "400g Velvet Box"),
      moq = "On Request (Collector Reserve)",
      priceDisplay = "$58 / 200g (Sovereign $320)",
      sovereignPrice = "$320 / 200g",
      netWeight = "200g",
      chapter = "Chapter III: Artisan Flavored Nuts",
      palatialNotes = "SARGOL SAFFRON • ULTIMATE LUXURY",
      applications = listOf("Royal Gifting", "Ultra-High-Net-Worth Concierge", "VIP Presentation"),
      specifications = listOf(
        ProductSpecification("Saffron Infusion", "0.5g pure Sargol saffron per 100g"),
        ProductSpecification("Butter Source", "AOP Beurre d'Isigny (Normandy)"),
        ProductSpecification("Macadamia Grade", "Style 0 Super Jumbo")
      ),
      availability = "Allocated Master Harvest",
      isFeatured = true,
      visualIconType = "hazelnut"
    ),
    Product(
      id = "aleppo-chili-cashews",
      name = "Aleppo Chili & Persian Lime Cashews",
      category = ProductCategory.SPECIALTY,
      description = "Zesty Persian lime zest combined with smoked Syrian Aleppo chili flakes and wild flower nectar for an intoxicating spicy-tart crunch.",
      origin = "Middle East / Levant",
      grade = "Zesty & Bold • Hand Crafted",
      availableForms = listOf("Spiced Jumbo Cashews"),
      packagingOptions = listOf("250g Seasoning Shaker Tin", "500g Vacuum Pouch"),
      moq = "On Request",
      priceDisplay = "$36 / 250g (Artisanal $210)",
      sovereignPrice = "$210 / 250g",
      netWeight = "250g",
      chapter = "Chapter III: Artisan Flavored Nuts",
      palatialNotes = "ALEPPO CHILI • ARTISANAL ROAST",
      applications = listOf("Tapas Lounges", "Private Aircraft Menus", "Gourmet Snacking"),
      specifications = listOf(
        ProductSpecification("Chili Heat", "Mild, fruity, smoked Aleppo flakes"),
        ProductSpecification("Citrus Note", "Cold-grated sun-dried Persian lime"),
        ProductSpecification("Base Nut", "Jumbo W-240 Cashews")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "cashew"
    ),

    // -------------------------------------------------------------
    // CHAPTER IV: HAUTE CONFECTIONERY, CHOCOLATES & PROTEIN SLABS
    // -------------------------------------------------------------
    Product(
      id = "criollo-gold-bark",
      name = "Criollo 24k Gold Dark Chocolate Bark",
      category = ProductCategory.SPECIALTY,
      description = "85%-90% single-origin Venezuelan Criollo dark chocolate embedded with crushed roasted hazelnuts and hand-dusted with 24k edible gold leaf flakes.",
      origin = "Venezuela (Sur del Lago)",
      grade = "Single-Origin Criollo • 24K Gold Leaf",
      availableForms = listOf("Artisanal Hand-Snapped Bark Slabs"),
      packagingOptions = listOf("200g Velvet-Lined Presentation Box", "400g Gift Casket"),
      moq = "On Request (Haute Confectionery)",
      priceDisplay = "$35 / 200g (Sovereign $275)",
      sovereignPrice = "$275 / 200g",
      netWeight = "200g",
      chapter = "Chapter IV: Haute Confectionery & Bars",
      palatialNotes = "VENEZUELA CACAO • 24K GOLD FLAKES",
      applications = listOf("VIP Amenities", "Luxury Chocolatiers", "Anniversary Collections"),
      specifications = listOf(
        ProductSpecification("Cacao Genetics", "Pure Venezuelan Criollo Heirloom"),
        ProductSpecification("Cocoa Solids", "88% Dark Bean-to-Bar"),
        ProductSpecification("Nut Inclusions", "Slow-roasted Piedmont IGP Hazelnuts")
      ),
      availability = "Chocolatier Allocation",
      isFeatured = true,
      visualIconType = "hazelnut"
    ),
    Product(
      id = "macadamia-praline-truffles",
      name = "Macadamia Praline Truffles (Box of 12)",
      category = ProductCategory.SPECIALTY,
      description = "Hand-crafted dark chocolate shells filled with silken roasted macadamia praline butter and Sicilian sea salt crystals.",
      origin = "Master Chocolatier Atelier, Switzerland",
      grade = "Master Chocolatier • Box of 12 Pieces",
      availableForms = listOf("Box of 12 Truffles", "Casket of 24 Truffles"),
      packagingOptions = listOf("220g Hand-Numbered Presentation Box", "Solid Brass Casket"),
      moq = "On Request",
      priceDisplay = "$42 / 220g (Master $290)",
      sovereignPrice = "$290 / 220g",
      netWeight = "220g",
      chapter = "Chapter IV: Haute Confectionery & Bars",
      palatialNotes = "MASTER CHOCOLATIER • BOX OF 12",
      applications = listOf("Five-Star Turn-Down Service", "Private Concierge Gifting"),
      specifications = listOf(
        ProductSpecification("Praline Core", "100% Roasted Byron Bay Macadamia Puree"),
        ProductSpecification("Shell Couverture", "Grand Cru 72% Dark Chocolate"),
        ProductSpecification("Shelf Life", "8 weeks from fresh artisan tempering")
      ),
      availability = "Fresh Batch Made-to-Order",
      isFeatured = true,
      visualIconType = "hazelnut"
    ),
    Product(
      id = "mamra-almond-protein-slab",
      name = "Royal Mamra Almond Protein Slab",
      category = ProductCategory.SPECIALTY,
      description = "Clean organic plant protein infused with raw Mamra almond butter, chia seeds, and pure coconut nectar. 22g-28g protein. 100% vegan with zero artificial isolates.",
      origin = "Certified Organic Facility",
      grade = "28g Protein • 100% Organic & Vegan",
      availableForms = listOf("6-Pack Luxury Box", "12-Pack Collector Case"),
      packagingOptions = listOf("6-Pack Matte Gold Box", "Master 24-Pack Case"),
      moq = "On Request",
      priceDisplay = "$28 / 6-pack (Sovereign $175)",
      sovereignPrice = "$175 / 6-pack",
      netWeight = "6 x 60g Slabs",
      chapter = "Chapter IV: Haute Confectionery & Bars",
      palatialNotes = "28G PROTEIN • 100% ORGANIC",
      applications = listOf("Athletic Connoisseurs", "Private Gym Suites", "Executive Nutrition"),
      specifications = listOf(
        ProductSpecification("Bio-Available Protein", "28g from Sprouted Raw Plants"),
        ProductSpecification("Sugar Source", "Low-GI Wild Coconut Nectar"),
        ProductSpecification("Gluten & Dairy", "Certified Gluten-Free & Vegan")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "almond"
    ),
    Product(
      id = "bronte-pistachio-protein-slab",
      name = "Bronte Pistachio Protein Slab",
      category = ProductCategory.SPECIALTY,
      description = "Rich Bronte pistachio paste layered with crunchy dark cacao nibs, organic grass-fed whey isolate, and bourbon vanilla pods. 24g-30g protein with zero added sugar.",
      origin = "Sicily & Alpine Valleys",
      grade = "30g Protein • Zero Refined Sugar",
      availableForms = listOf("6-Pack Luxury Box", "12-Pack Case"),
      packagingOptions = listOf("6-Pack Emerald Gold Box", "Master 24-Pack Case"),
      moq = "On Request",
      priceDisplay = "$30 / 6-pack (Sovereign $190)",
      sovereignPrice = "$190 / 6-pack",
      netWeight = "6 x 60g Slabs",
      chapter = "Chapter IV: Haute Confectionery & Bars",
      palatialNotes = "30G PROTEIN • ZERO REFINED SUGAR",
      applications = listOf("Recovery Lounges", "Alpine Ski Lodges", "Elite Health Spas"),
      specifications = listOf(
        ProductSpecification("Whey Source", "100% Grass-Fed Alpine Whey Isolate"),
        ProductSpecification("Pistachio Paste", "Pure Mt. Etna Bronte Kernels"),
        ProductSpecification("Sweetener", "Organic Monk Fruit & Vanilla Pod Extract")
      ),
      availability = "In Stock / Regular Supply",
      isFeatured = false,
      visualIconType = "pistachio"
    ),

    // -------------------------------------------------------------
    // SIGNATURE PRESENTATION CHESTS & MEMBERSHIP
    // -------------------------------------------------------------
    Product(
      id = "sovereign-wooden-chest",
      name = "The Sovereign Wooden Chest",
      category = ProductCategory.SPECIALTY,
      description = "Hand-crafted dark walnut wooden chest containing a curated selection of six reserve nuts and rare honey-infused seeds. Velvet lined with custom brass lock and key.",
      origin = "Global Heritage Groves",
      grade = "Solid Dark Walnut • Velvet Lined",
      availableForms = listOf("Complete 6-Decanter Presentation Chest"),
      packagingOptions = listOf("Solid Walnut Velvet-Lined Chest (Weight 3.2 kg)"),
      moq = "1 Chest",
      priceDisplay = "$185 (Complete Presentation)",
      sovereignPrice = "$450 (Imperial Sovereign Edition)",
      netWeight = "6 x 150g Decanters",
      chapter = "Chapter IV: Haute Confectionery & Bars",
      palatialNotes = "PACKAGING: SOLID WALNUT • VELVET LINED",
      applications = listOf("Presidential Gifting", "Bespoke Corporate Curation", "Heirloom Decor"),
      specifications = listOf(
        ProductSpecification("Woodwork", "Solid Appalachian Black Walnut"),
        ProductSpecification("Lining", "Imperial Burgundy Silk Velvet"),
        ProductSpecification("Inclusions", "Mamra Almonds, Bronte Pistachios, Macadamias, Truffle Seeds, Saffron Seeds, Gold Dates")
      ),
      availability = "Made by Commission / Ready Stock",
      isFeatured = true,
      visualIconType = "walnut"
    ),
    Product(
      id = "annual-reserve-pass",
      name = "The Annual Reserve Pass (VIP Membership)",
      category = ProductCategory.SPECIALTY,
      description = "A quarterly delivery of seasonal micro-batch harvests, shipped directly in customized temperature-sealed brass canisters with private concierge allocation.",
      origin = "Direct Farmgate Global Reserve",
      grade = "VIP Allocation • Free Global Shipping",
      availableForms = listOf("Annual 4-Quarter Delivery Subscription"),
      packagingOptions = listOf("Quarterly Temperature-Sealed Brass Canisters"),
      moq = "1 Annual Membership",
      priceDisplay = "$650 / year",
      sovereignPrice = "$1,800 / year (Sovereign Tier)",
      netWeight = "4 Deliveries x 1.5 kg Reserve",
      chapter = "Chapter IV: Haute Confectionery & Bars",
      palatialNotes = "PRIVILEGE: VIP ALLOCATION • FREE SHIPPING",
      applications = listOf("Connoisseur Memberships", "Executive Retainers", "Private Collectors"),
      specifications = listOf(
        ProductSpecification("Frequency", "4 Deliveries (Spring, Summer, Autumn, Winter)"),
        ProductSpecification("Concierge Service", "Dedicated WhatsApp & Email Sommelier"),
        ProductSpecification("Privilege", "First right of refusal on all Sovereign allocations")
      ),
      availability = "Limited to 250 Members Globally",
      isFeatured = true,
      visualIconType = "almond"
    )
  )

  fun getFeaturedProducts(): List<Product> {
    return products.filter { it.isFeatured }
  }

  fun getProductsByCategory(category: ProductCategory): List<Product> {
    if (category == ProductCategory.ALL) return products
    return products.filter { it.category == category }
  }

  fun getProductById(id: String): Product? {
    return products.find { it.id.equals(id, ignoreCase = true) }
  }

  fun filterProducts(criteria: ProductFilterCriteria): List<Product> {
    val filtered = products.filter { product ->
      val matchesCategory = criteria.category == null || 
          criteria.category == ProductCategory.ALL || 
          product.category == criteria.category

      val matchesQuery = criteria.query.isNullOrBlank() ||
          product.name.contains(criteria.query, ignoreCase = true) ||
          product.description.contains(criteria.query, ignoreCase = true) ||
          product.grade.contains(criteria.query, ignoreCase = true) ||
          product.origin.contains(criteria.query, ignoreCase = true)

      val matchesOrigin = criteria.origin.isNullOrBlank() ||
          product.origin.contains(criteria.origin, ignoreCase = true)

      val matchesApplication = criteria.application.isNullOrBlank() ||
          product.applications.any { it.contains(criteria.application, ignoreCase = true) }

      val matchesForm = criteria.form.isNullOrBlank() ||
          product.availableForms.any { it.contains(criteria.form, ignoreCase = true) }

      val matchesAvailability = criteria.availability.isNullOrBlank() ||
          product.availability.contains(criteria.availability, ignoreCase = true)

      matchesCategory && matchesQuery && matchesOrigin && matchesApplication && matchesForm && matchesAvailability
    }

    return when (criteria.sortBy) {
      SortOption.NAME_ASC -> filtered.sortedBy { it.name }
      SortOption.NAME_DESC -> filtered.sortedByDescending { it.name }
      SortOption.ORIGIN -> filtered.sortedBy { it.origin }
      SortOption.FEATURED -> filtered.sortedByDescending { it.isFeatured }
    }
  }

  fun getOriginsList(): List<String> {
    return listOf("All Origins", "USA", "Sicily", "Australia", "Kashmir", "Austria", "Patagonia", "Spain", "Venezuela")
  }

  fun getApplicationsList(): List<String> {
    return listOf("All Applications", "Private Concierge", "Luxury Retail", "Fine Dining Pastry", "Gift Hampers")
  }

  fun getDistinctOrigins(): List<String> {
    return products.map { it.origin }.distinct()
  }

  fun getDistinctAvailabilities(): List<String> {
    return products.map { it.availability }.distinct()
  }

  fun getDistinctForms(): List<String> {
    return products.flatMap { it.availableForms }.distinct()
  }
}

enum class SortOption(val label: String) {
  FEATURED("Featured Sovereign"),
  NAME_ASC("Name: A to Z"),
  NAME_DESC("Name: Z to A"),
  ORIGIN("By Sourcing Origin")
}

data class ProductFilterCriteria(
  val category: ProductCategory? = null,
  val query: String? = null,
  val origin: String? = null,
  val application: String? = null,
  val form: String? = null,
  val availability: String? = null,
  val sortBy: SortOption = SortOption.FEATURED
) {
  val activeFilterCount: Int
    get() {
      var count = 0
      if (category != null && category != ProductCategory.ALL) count++
      if (!query.isNullOrBlank()) count++
      if (!origin.isNullOrBlank()) count++
      if (!application.isNullOrBlank()) count++
      if (!form.isNullOrBlank()) count++
      if (!availability.isNullOrBlank()) count++
      return count
    }
}
