export type CategoryId = 'nuts' | 'dried-fruits' | 'seeds-superfoods' | 'specialty'

export const categories: { id: CategoryId; name: string; subtitle: string }[] = [
  { id: 'nuts', name: 'Nuts', subtitle: 'Hand-selected from imperial Persian reserves and volcanic groves' },
  { id: 'dried-fruits', name: 'Dried Fruits', subtitle: 'Sun-ripened, naturally dried fruits from pristine oases' },
  { id: 'seeds-superfoods', name: 'Seeds & Superfoods', subtitle: 'Nutrient-dense botanicals and rare infused blends' },
  { id: 'specialty', name: 'Specialty Products', subtitle: 'Masterfully roasted spiced nuts and single-origin chocolates' },
]

export const chapters = [
  'Chapter I: Royal Nuts & Dry Fruits',
  'Chapter II: Rare Connoisseur Seeds',
  'Chapter III: Artisan Flavored Nuts',
  'Chapter IV: Haute Confectionery & Bars',
] as const

export type Product = {
  id: string
  name: string
  category: CategoryId
  description: string
  origin: string
  grade: string
  forms: string[]
  packaging: string[]
  moq: string
  priceDisplay: string
  sovereignPrice: string
  netWeight: string
  chapter: (typeof chapters)[number]
  notes: string
  applications: string[]
  specifications: { label: string; value: string }[]
  availability: string
  featured: boolean
  image: string
}

const img = (name: string) => `/images/products/${name}.png`

export const products: Product[] = [
  {
    id: 'california-almonds', name: 'Imperial Mamra Almonds', category: 'nuts',
    description: 'Wild-harvested ancient Persian almonds from high-altitude groves, naturally sun-dried with peerless natural lipid content, supreme density, and buttery crunch.',
    origin: 'USA', grade: 'Sovereign Grade A+ Organic',
    forms: ['Whole Natural', 'Blanched', 'Hand-Sorted Kernels'],
    packaging: ['250g Velvet-lined Tin', '1000g Wooden Cask', '25 lb Carton', 'Custom Retail Pouches'],
    moq: 'On Request (Standard: 1 Pallet / 50 Tins)', priceDisplay: 'Price: On Request', sovereignPrice: '$250 / 250g', netWeight: '250g',
    chapter: chapters[0], notes: 'Origin: Hindu Kush • Sovereign Grade',
    applications: ['Connoisseur Retail', 'Private Concierge', 'Luxury Hospitality', 'Gourmet Confectionery'],
    specifications: [
      { label: 'Natural Lipid Content', value: '54.2% Extra Rich' },
      { label: 'Moisture Content', value: 'Max 4.8%' },
      { label: 'Sun Drying', value: '100% High-Altitude Solar Dried' },
      { label: 'Storage Condition', value: 'Cool & dry cellar (10°C - 14°C)' },
    ],
    availability: 'Allocated Sovereign Harvest', featured: true, image: img('almond'),
  },
  {
    id: 'bronte-pistachios', name: 'Bronte Emerald Pistachios', category: 'nuts',
    description: 'Deep emerald kernels naturally opened and harvested exclusively under moonlight from volcanic foothills. Renowned for exceptional sweetness and striking visual appeal.',
    origin: 'Mt. Etna, Sicily / Piedmont', grade: 'Ultra-Rare Reserve Edition',
    forms: ['Peeled Emerald Kernels', 'Naturally Opened In-Shell'],
    packaging: ['250g Gold Embossed Tin', '500g Glass Decanter', '10 kg Master Vacuum Cask'],
    moq: 'On Request (VIP Allocation)', priceDisplay: '$48 / 250g', sovereignPrice: '$290 / 250g', netWeight: '250g',
    chapter: chapters[0], notes: 'Origin: Mt. Etna • Ultra-Rare Reserve',
    applications: ['Fine Dining Pastry', 'Luxury Retail', 'Gelato Art', 'Collector Cellars'],
    specifications: [
      { label: 'Soil Profile', value: 'Volcanic Basalt Mineral Soils' },
      { label: 'Harvest Method', value: 'Nocturnal Moonlit Hand-Pick' },
      { label: 'Pigment', value: 'Natural Deep Chlorophyll Emerald' },
      { label: 'Zero Oil Roast', value: 'Dry roasted with ancient sea crystals' },
    ],
    availability: 'Strictly Allocated Reserve', featured: true, image: img('pistachio'),
  },
  {
    id: 'vintage-macadamias', name: 'Vintage Imperial Macadamias', category: 'nuts',
    description: 'Extra-large buttery Australian kernels harvested at absolute peak maturity from volcanic soils, aged in humidity-controlled cedar vaults for buttery silkiness.',
    origin: 'Byron Bay, Australia', grade: 'Collector Grade Style 0 Super Jumbo',
    forms: ['Whole Raw Style 0', 'Slow Dry-Roasted', 'Cold-Pressed Macadamia Butter'],
    packaging: ['250g Brass Tin', '500g Presentation Box', '10 kg Nitrogen Cask'],
    moq: 'On Request', priceDisplay: '$52 / 250g', sovereignPrice: '$220 / 250g', netWeight: '250g',
    chapter: chapters[0], notes: 'Origin: Byron Bay • Cedar Cured',
    applications: ['Artisanal Snacking', 'Haute Pâtisserie', 'VIP Hospitality'],
    specifications: [
      { label: 'Kernel Sizing', value: 'Style 0 (Exceeds 20mm diameter)' },
      { label: 'Curing', value: '6-week humidity-controlled cedar vault cure' },
      { label: 'Texture', value: 'Buttery melt-in-mouth finish' },
    ],
    availability: 'In Stock / Regular Supply', featured: true, image: img('macadamia'),
  },
  {
    id: 'royal-porcelain-walnuts', name: 'Royal Porcelain Walnuts', category: 'nuts',
    description: 'Immaculate extra-light jumbo butterfly halves with zero astringency, clean mellow finish, and exceptionally high omega fatty acids. Hand-cracked with artisanal care.',
    origin: 'Kashmir / Andes Foothills', grade: 'Extra Light Halves (80%+ Halves)',
    forms: ['Extra Light Jumbo Halves', 'Quarter Pieces for Pâtisserie'],
    packaging: ['250g Presentation Box', '1 kg Vacuum Tin', '10 kg Master Carton'],
    moq: 'On Request', priceDisplay: '$38 / 250g', sovereignPrice: '$190 / 250g', netWeight: '250g',
    chapter: chapters[0], notes: 'Origin: Kashmir • Hand Cracked',
    applications: ['Brain Health Formulations', 'Luxury Table Service', 'Bespoke Gift Boxes'],
    specifications: [
      { label: 'Halves Percentage', value: 'Min 85% Whole Halves' },
      { label: 'Pellicle Color', value: 'Porcelain Ivory / Light Amber' },
      { label: 'Astringency', value: 'Zero bitter tannin profile' },
    ],
    availability: 'Fresh Season Harvest', featured: false, image: img('walnut'),
  },
  {
    id: 'premium-cashews', name: 'Whole King Cashews (W-180)', category: 'nuts',
    description: 'Magnificent King-size cashew kernels hand-sorted for uniform size, brilliant ivory color, and natural sweet creaminess.',
    origin: 'India / Goa & Mangalore', grade: 'W-180 (King Size, 180 kernels/lb)',
    forms: ['Whole White (W-180)', 'Tumbled & Seasoned', 'Slow Roasted'],
    packaging: ['250g Luxury Tin', '10 kg Vacuum Tin', '50 lb Master Carton'],
    moq: 'On Request (Standard: 1 Pallet)', priceDisplay: 'Price: On Request', sovereignPrice: '$240 / 250g', netWeight: '250g',
    chapter: chapters[0], notes: 'Origin: Malabar Coast • Hand Sorted',
    applications: ['Luxury Retail', 'Gift Hampers', 'HORECA Royal Suite'],
    specifications: [
      { label: 'Count / lb', value: '160 - 180 kernels' },
      { label: 'Moisture', value: 'Max 4.5%' },
      { label: 'Grading', value: 'Zero scorched kernels' },
    ],
    availability: 'In Stock / Regular Supply', featured: true, image: img('cashew'),
  },
  {
    id: '24k-gold-medjool-dates', name: '24k Gold Medjool Dates', category: 'dried-fruits',
    description: 'King-grade succulent dates stuffed with candied orange peel and hand-dusted with 24k edible gold leaf. Caramel-like texture, naturally syrupy, from pristine desert oases.',
    origin: 'Pristine Desert Oases', grade: 'Palatial Edition • Crown Grade Succulent',
    forms: ['Gold-Dusted Whole', 'Citrus-Stuffed', 'Almond-Stuffed'],
    packaging: ['500g Gold-Embossed Presentation Box', '1 kg Velvet Casket'],
    moq: 'On Request (Palatial Collection)', priceDisplay: '$34 / 500g', sovereignPrice: '$180 / 500g', netWeight: '500g',
    chapter: chapters[0], notes: 'Palatial Edition • 24K Gold Leaf',
    applications: ['Royal Ceremonies', 'Bespoke Concierge Gifting', 'Luxury Suites'],
    specifications: [
      { label: 'Size Calibration', value: 'Super Jumbo (24g+ per date)' },
      { label: 'Skin Separation', value: 'Below 3%' },
      { label: 'Gilding', value: 'Certified 24k Edible Gold Leaf' },
    ],
    availability: 'Limited Seasonal Batch', featured: true, image: img('date'),
  },
  {
    id: 'muscat-aged-figs', name: 'Golden Smyrna & Muscat-Aged Figs', category: 'dried-fruits',
    description: 'Sun-dried Aegean white figs plumped in rare dessert muscat wine and wild clover honey. Plump, tender texture with a delicate crunch and honeyed finish.',
    origin: 'Aegean Coast, Turkey', grade: 'Collector Grade • Garland Crown',
    forms: ['Garland Whole Figs', 'Muscat Macerated', 'Pressed Cake'],
    packaging: ['400g Wax-Sealed Wooden Cask', '800g Presentation Box'],
    moq: 'On Request', priceDisplay: '$32 / 400g', sovereignPrice: '$165 / 400g', netWeight: '400g',
    chapter: chapters[0], notes: 'Aged in Muscat • Collector Grade',
    applications: ['Artisan Charcuterie', 'Fine Wine Pairings', 'Dessert Accents'],
    specifications: [
      { label: 'Moisture', value: '22% - 24% Natural Plumpness' },
      { label: 'Sulfur Free', value: '100% Naturally Sun-Cured' },
      { label: 'Aroma Profile', value: 'Wildflower honey and sweet muscat' },
    ],
    availability: 'In Stock / Regular Supply', featured: true, image: img('fig'),
  },
  {
    id: 'monukkha-green-raisins', name: 'Monukkha Emerald Green Raisins', category: 'dried-fruits',
    description: 'Elongated, emerald-hued seedless grapes shade-dried in ancient cold stone cellars to preserve vibrant natural pigments and delicate, floral sweetness.',
    origin: 'Kashmir & Central Asia', grade: 'Select Jumbo AAA (Length 22mm+)',
    forms: ['Whole Green Shade-Dried', 'Golden Amber Raisins'],
    packaging: ['350g Glass Jar', '5 kg Master Carton', '10 kg Trade Bulk'],
    moq: 'On Request', priceDisplay: '$26 / 350g', sovereignPrice: '$110 / 350g', netWeight: '350g',
    chapter: chapters[0], notes: 'Stone Cellar Dried • Zero Additives',
    applications: ['Gourmet Breakfast', 'Pastry Chefs', 'Luxury Snack Mixes'],
    specifications: [
      { label: 'Length', value: '20mm - 25mm' },
      { label: 'Processing', value: 'Non-treated natural shade dry' },
      { label: 'Texture', value: 'Chewy and succulent' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('raisin'),
  },
  {
    id: 'white-truffle-pumpkin-seeds', name: 'White Truffle Styrian Pumpkin Seeds', category: 'seeds-superfoods',
    description: 'Heirloom hull-less dark emerald seeds roasted in rare white Alba truffle oil and Anglesey crystal salt. Rich in magnesium and zinc with exquisite umami depth.',
    origin: 'Styria, Austria', grade: 'Micro-Batch Heirloom Selection',
    forms: ['Truffle Roasted', 'Raw Cold-Pressed Seeds'],
    packaging: ['300g Dark Violet Glass Jar', '1 kg Foil Bag'],
    moq: 'On Request', priceDisplay: '$28 / 300g', sovereignPrice: '$140 / 300g', netWeight: '300g',
    chapter: chapters[1], notes: 'Origin: Austria • Truffle Infused',
    applications: ['Salad Accents', 'Private Cellar Snacking', 'Nutrition Toppings'],
    specifications: [
      { label: 'Variety', value: 'Cucurbita pepo var. styriaca' },
      { label: 'Chlorophyll Purity', value: '100% Dark Forest Green' },
      { label: 'Infusion', value: 'Genuine White Alba Truffle Extra Virgin Oil' },
    ],
    availability: 'Micro-Batch Allocation', featured: true, image: img('pumpkin-seed'),
  },
  {
    id: 'imperial-jet-black-chia', name: 'Imperial Jet-Black Chia Seeds', category: 'seeds-superfoods',
    description: 'Deep black certified organic chia seeds selected for maximum mucilaginous purity, hydration power, and unmatched antioxidant vitality.',
    origin: 'Patagonia, South America', grade: 'Master Reserve Raw Organic (99.9% Purity)',
    forms: ['Whole Black Chia', 'Cold-Milled Bio-Available Powder'],
    packaging: ['300g UV-Shield Pouch', '1 kg Nitrogen Tin', '25 kg Bulk Sack'],
    moq: 'On Request', priceDisplay: '$24 / 300g', sovereignPrice: '$120 / 300g', netWeight: '300g',
    chapter: chapters[1], notes: 'Origin: Patagonia • Master Reserve',
    applications: ['Superfood Blends', 'Clinical Nutrition', 'Luxury Breakfast Bars'],
    specifications: [
      { label: 'Purity', value: 'Min 99.9% Optical Sort' },
      { label: 'Omega-3 (ALA)', value: 'Exceeds 19g / 100g' },
      { label: 'Hydration Gel Factor', value: '12x Weight Water Absorption' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('chia'),
  },
  {
    id: 'golden-flax-reserve', name: 'Golden Flax Reserve & Rosehip', category: 'seeds-superfoods',
    description: 'Cold-milled golden flax seeds infused with wild rosehip botanical oil and Bourbon vanilla pods. Exceptionally high ALA omega-3 concentration and delicate nutty aroma.',
    origin: 'Living Botanicals, North America', grade: 'Botanical Grade Living Cold Pressed',
    forms: ['Whole Golden Seed', 'Fresh-Milled Powder'],
    packaging: ['350g Ceramic Airtight Jar', '1 kg Foil Vacuum Bag'],
    moq: 'On Request', priceDisplay: '$22 / 350g', sovereignPrice: '$110 / 350g', netWeight: '350g',
    chapter: chapters[1], notes: 'Cold Pressed • Botanical Grade',
    applications: ['Nutraceuticals', 'Smoothie Blends', 'Wellness Confections'],
    specifications: [
      { label: 'ALA Content', value: '57% of total lipid profile' },
      { label: 'Rosehip Bioflavonoids', value: 'Naturally Active Vitamin C & E' },
      { label: 'Processing', value: 'Low-temperature vortex cold mill' },
    ],
    availability: 'Regular Freshly Milled Supply', featured: false, image: img('chia'),
  },
  {
    id: 'ivory-hemp-hearts', name: 'Ivory Hulled Hemp Hearts', category: 'seeds-superfoods',
    description: 'Pristine raw ivory hemp kernels offering complete plant protein with all 9 essential amino acids. Silken nutty texture with zero bitter hulls.',
    origin: 'Canadian Rockies', grade: 'Pristine Raw Harvest 99.9%',
    forms: ['Hulled Hearts', 'Cold-Pressed Hemp Seed Oil'],
    packaging: ['250g Nitrogen-Flushed Tin', '1 kg Vacuum Bag'],
    moq: 'On Request', priceDisplay: '$30 / 250g', sovereignPrice: '$150 / 250g', netWeight: '250g',
    chapter: chapters[1], notes: 'Origin: Canadian Rockies • Raw',
    applications: ['High-Protein Culinary', 'Vegan Cheese', 'Functional Shakes'],
    specifications: [
      { label: 'Protein Content', value: '33g / 100g Complete Protein' },
      { label: 'Omega-6 to Omega-3', value: 'Optimal 3:1 Ratio' },
      { label: 'Hull Remnants', value: 'Under 0.05%' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('hemp'),
  },
  {
    id: 'sargol-saffron-sunflower', name: 'Sargol Saffron Sunflower Seeds', category: 'seeds-superfoods',
    description: 'Gently roasted organic sunflower hearts glazed with grade-one Persian Sargol saffron threads and raw acacia honey.',
    origin: 'Persia & Mediterranean', grade: 'Royal Saffron Glaze • Elite Batch',
    forms: ['Whole Glazed Hearts'],
    packaging: ['250g Collector Tin', '500g Glass Decanter'],
    moq: 'On Request', priceDisplay: '$32 / 250g', sovereignPrice: '$175 / 250g', netWeight: '250g',
    chapter: chapters[1], notes: 'Royal Saffron Glaze • Elite Batch',
    applications: ['Cocktail Garnish', 'Private Tasting Bars', 'VIP Amenities'],
    specifications: [
      { label: 'Saffron Grade', value: 'Grade 1 Super Sargol (ISO 3632-1)' },
      { label: 'Glaze Base', value: 'Raw Monofloral Acacia Honey' },
      { label: 'Roast Profile', value: 'Slow artisan drum roast at 120°C' },
    ],
    availability: 'Limited Batch Production', featured: true, image: img('hemp'),
  },
  {
    id: 'malabar-cardamom-seeds', name: 'Malabar Cardamom Wildflower Seeds', category: 'seeds-superfoods',
    description: 'Tossed in rare Malabar green cardamom pods, pure Madagascar vanilla bean, and raw organic forest wildflower honey.',
    origin: 'Malabar Coast, India', grade: 'Artisanal Glaze • Natural Sweet',
    forms: ['Whole Roasted Spiced Seeds'],
    packaging: ['300g Luxury Tin', '1 kg Master Pack'],
    moq: 'On Request', priceDisplay: '$26 / 300g', sovereignPrice: '$130 / 300g', netWeight: '300g',
    chapter: chapters[1], notes: 'Malabar Spice • Artisanal Roast',
    applications: ['Gourmet Snacking', 'Digestive Presentation', 'Confectionery'],
    specifications: [
      { label: 'Cardamom Caliber', value: '8mm Jumbo Deep Green Pods' },
      { label: 'Vanilla Origin', value: 'Madagascar Bourbon Beans' },
      { label: 'Honey Source', value: 'Wild Western Ghats Forest Honey' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('pumpkin-seed'),
  },
  {
    id: 'truffle-salt-cashews', name: 'Black Truffle & Sea Salt Cashews', category: 'specialty',
    description: 'W-180 jumbo cashews bathed in rare Piedmont black truffle shavings and flake Maldon sea salt. Dusted with edible gold flakes for the Sovereign Reserve edition.',
    origin: 'Piedmont, Italy / Malabar', grade: 'Gourmet Reserve • Tumbled Batch',
    forms: ['Tumbled Jumbo Cashews'],
    packaging: ['250g Gold Stamped Tin', '500g Decanter'],
    moq: 'On Request', priceDisplay: '$42 / 250g', sovereignPrice: '$240 / 250g', netWeight: '250g',
    chapter: chapters[2], notes: 'Piedmont Truffle • Flake Maldon Salt',
    applications: ['Michelin Star Lounges', 'Corporate Gift Hampers', 'Private Aviation'],
    specifications: [
      { label: 'Truffle Species', value: 'Tuber melanosporum & Tuber magnatum' },
      { label: 'Cashew Base', value: 'King W-180 Jumbo Kernels' },
      { label: 'Salt Type', value: 'Maldon Pyramid Sea Flakes' },
    ],
    availability: 'Small-Batch Hand Tumbled', featured: true, image: img('cashew'),
  },
  {
    id: 'pink-salt-bergamot-pistachios', name: 'Himalayan Pink Salt & Bergamot Pistachios', category: 'specialty',
    description: 'Dry-roasted jumbo pistachios seasoned delicately with ancient Himalayan pink crystal salt and organic Calabrian bergamot essential oil. Zero oil roasted.',
    origin: 'Calabria, Italy & Himalayas', grade: 'Zero Oil • Bergamot Infused',
    forms: ['In-Shell Dry Roasted', 'Shelled Kernels'],
    packaging: ['250g Hermetic Canister', '500g Brass Tin'],
    moq: 'On Request', priceDisplay: '$46 / 250g', sovereignPrice: '$260 / 250g', netWeight: '250g',
    chapter: chapters[2], notes: 'Zero Oil • Bergamot Infused',
    applications: ['Digestive Lounges', 'Fine Cocktail Pairings', 'Wellness Suites'],
    specifications: [
      { label: 'Roast Method', value: '100% Hot Air Fluidized Bed (No Oil)' },
      { label: 'Bergamot Extract', value: 'Cold-expressed Calabrian Rind Oil' },
      { label: 'Salt Minerals', value: '84 Natural Trace Minerals' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('pistachio'),
  },
  {
    id: 'cinnamon-pecans', name: 'Ceylon Cinnamon & Tonka Bean Pecans', category: 'specialty',
    description: 'Mammoth halves coated in organic Quebec maple syrup, genuine Sri Lankan Ceylon cinnamon, and toasted Madagascar tonka bean.',
    origin: 'Madagascar & Sri Lanka', grade: 'Artisan Glazed • Small Batch',
    forms: ['Glazed Mammoth Halves'],
    packaging: ['250g Cedar Gift Box', '500g Gold Canister'],
    moq: 'On Request', priceDisplay: '$40 / 250g', sovereignPrice: '$220 / 250g', netWeight: '250g',
    chapter: chapters[2], notes: 'Tonka Bean Glaze • Small Batch',
    applications: ['Autumn & Winter Banquets', 'Gourmet Dessert Toppings', 'Bespoke Hampers'],
    specifications: [
      { label: 'Cinnamon Species', value: 'Cinnamomum verum (Ceylon True Cinnamon)' },
      { label: 'Syrup Grade', value: 'Grade A Very Dark Maple Syrup' },
      { label: 'Pecan Size', value: 'Mammoth Halves (250-300 ct/lb)' },
    ],
    availability: 'Seasonal Artisan Batch', featured: true, image: img('walnut'),
  },
  {
    id: 'smoked-rosemary-almonds', name: 'Smoked Rosemary & Cognac Oak Almonds', category: 'specialty',
    description: 'Spanish Marcona almonds slow-smoked over reclaimed French cognac oak barrels with fresh garden rosemary and fleur de sel.',
    origin: 'Spain / France', grade: 'Cognac Oak Smoked • Spanish Gold',
    forms: ['Whole Smoked Marcona'],
    packaging: ['250g Wax-Sealed Pouch', '500g Oak Canister'],
    moq: 'On Request', priceDisplay: '$38 / 250g', sovereignPrice: '$230 / 250g', netWeight: '250g',
    chapter: chapters[2], notes: 'Cognac Oak Smoked • Spanish Gold',
    applications: ['Cigar Lounges', 'Sommelier Pairings', 'Craft Charcuterie'],
    specifications: [
      { label: 'Almond Variety', value: 'Authentic Spanish Marcona' },
      { label: 'Smoking Wood', value: '50-Year French Limousin Cognac Casks' },
      { label: 'Herb', value: 'Fresh Mediterranean Rosemary Needles' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('almond'),
  },
  {
    id: 'saffron-macadamias', name: 'Persian Sargol Saffron Macadamias', category: 'specialty',
    description: 'Buttery Australian macadamias infused with grade-one Sargol Persian saffron threads and cultured French Isigny butter.',
    origin: 'Byron Bay & Khorasan', grade: 'Ultra-Luxury Royal Edition',
    forms: ['Whole Butter-Infused Macadamias'],
    packaging: ['200g Hand-blown Glass Jar with Gold Lid', '400g Velvet Box'],
    moq: 'On Request (Collector Reserve)', priceDisplay: '$58 / 200g', sovereignPrice: '$320 / 200g', netWeight: '200g',
    chapter: chapters[2], notes: 'Sargol Saffron • Ultimate Luxury',
    applications: ['Royal Gifting', 'Private Concierge', 'VIP Presentation'],
    specifications: [
      { label: 'Saffron Infusion', value: '0.5g pure Sargol saffron per 100g' },
      { label: 'Butter Source', value: "AOP Beurre d'Isigny (Normandy)" },
      { label: 'Macadamia Grade', value: 'Style 0 Super Jumbo' },
    ],
    availability: 'Allocated Master Harvest', featured: true, image: img('macadamia'),
  },
  {
    id: 'aleppo-chili-cashews', name: 'Aleppo Chili & Persian Lime Cashews', category: 'specialty',
    description: 'Zesty Persian lime zest combined with smoked Syrian Aleppo chili flakes and wild flower nectar for an intoxicating spicy-tart crunch.',
    origin: 'Middle East / Levant', grade: 'Zesty & Bold • Hand Crafted',
    forms: ['Spiced Jumbo Cashews'],
    packaging: ['250g Seasoning Shaker Tin', '500g Vacuum Pouch'],
    moq: 'On Request', priceDisplay: '$36 / 250g', sovereignPrice: '$210 / 250g', netWeight: '250g',
    chapter: chapters[2], notes: 'Aleppo Chili • Artisanal Roast',
    applications: ['Tapas Lounges', 'Private Aircraft Menus', 'Gourmet Snacking'],
    specifications: [
      { label: 'Chili Heat', value: 'Mild, fruity, smoked Aleppo flakes' },
      { label: 'Citrus Note', value: 'Cold-grated sun-dried Persian lime' },
      { label: 'Base Nut', value: 'Jumbo W-240 Cashews' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('cashew'),
  },
  {
    id: 'criollo-gold-bark', name: 'Criollo 24k Gold Dark Chocolate Bark', category: 'specialty',
    description: '85%-90% single-origin Venezuelan Criollo dark chocolate embedded with crushed roasted hazelnuts and hand-dusted with 24k edible gold leaf flakes.',
    origin: 'Venezuela (Sur del Lago)', grade: 'Single-Origin Criollo • 24K Gold Leaf',
    forms: ['Artisanal Hand-Snapped Bark Slabs'],
    packaging: ['200g Velvet-Lined Presentation Box', '400g Gift Casket'],
    moq: 'On Request (Haute Confectionery)', priceDisplay: '$35 / 200g', sovereignPrice: '$275 / 200g', netWeight: '200g',
    chapter: chapters[3], notes: 'Venezuela Cacao • 24K Gold Flakes',
    applications: ['VIP Amenities', 'Luxury Chocolatiers', 'Anniversary Collections'],
    specifications: [
      { label: 'Cacao Genetics', value: 'Pure Venezuelan Criollo Heirloom' },
      { label: 'Cocoa Solids', value: '88% Dark Bean-to-Bar' },
      { label: 'Nut Inclusions', value: 'Slow-roasted Piedmont IGP Hazelnuts' },
    ],
    availability: 'Chocolatier Allocation', featured: true, image: img('chocolate'),
  },
  {
    id: 'macadamia-praline-truffles', name: 'Macadamia Praline Truffles (Box of 12)', category: 'specialty',
    description: 'Hand-crafted dark chocolate shells filled with silken roasted macadamia praline butter and Sicilian sea salt crystals.',
    origin: 'Master Chocolatier Atelier, Switzerland', grade: 'Master Chocolatier • Box of 12 Pieces',
    forms: ['Box of 12 Truffles', 'Casket of 24 Truffles'],
    packaging: ['220g Hand-Numbered Presentation Box', 'Solid Brass Casket'],
    moq: 'On Request', priceDisplay: '$42 / 220g', sovereignPrice: '$290 / 220g', netWeight: '220g',
    chapter: chapters[3], notes: 'Master Chocolatier • Box of 12',
    applications: ['Five-Star Turn-Down Service', 'Private Concierge Gifting'],
    specifications: [
      { label: 'Praline Core', value: '100% Roasted Byron Bay Macadamia Puree' },
      { label: 'Shell Couverture', value: 'Grand Cru 72% Dark Chocolate' },
      { label: 'Shelf Life', value: '8 weeks from fresh artisan tempering' },
    ],
    availability: 'Fresh Batch Made-to-Order', featured: true, image: img('chocolate'),
  },
  {
    id: 'mamra-almond-protein-slab', name: 'Royal Mamra Almond Protein Slab', category: 'specialty',
    description: 'Clean organic plant protein infused with raw Mamra almond butter, chia seeds, and pure coconut nectar. 22g-28g protein. 100% vegan with zero artificial isolates.',
    origin: 'Certified Organic Facility', grade: '28g Protein • 100% Organic & Vegan',
    forms: ['6-Pack Luxury Box', '12-Pack Collector Case'],
    packaging: ['6-Pack Matte Gold Box', 'Master 24-Pack Case'],
    moq: 'On Request', priceDisplay: '$28 / 6-pack', sovereignPrice: '$175 / 6-pack', netWeight: '6 x 60g Slabs',
    chapter: chapters[3], notes: '28g Protein • 100% Organic',
    applications: ['Athletic Connoisseurs', 'Private Gym Suites', 'Executive Nutrition'],
    specifications: [
      { label: 'Bio-Available Protein', value: '28g from Sprouted Raw Plants' },
      { label: 'Sugar Source', value: 'Low-GI Wild Coconut Nectar' },
      { label: 'Gluten & Dairy', value: 'Certified Gluten-Free & Vegan' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('almond'),
  },
  {
    id: 'bronte-pistachio-protein-slab', name: 'Bronte Pistachio Protein Slab', category: 'specialty',
    description: 'Rich Bronte pistachio paste layered with crunchy dark cacao nibs, organic grass-fed whey isolate, and bourbon vanilla pods. 24g-30g protein with zero added sugar.',
    origin: 'Sicily & Alpine Valleys', grade: '30g Protein • Zero Refined Sugar',
    forms: ['6-Pack Luxury Box', '12-Pack Case'],
    packaging: ['6-Pack Emerald Gold Box', 'Master 24-Pack Case'],
    moq: 'On Request', priceDisplay: '$30 / 6-pack', sovereignPrice: '$190 / 6-pack', netWeight: '6 x 60g Slabs',
    chapter: chapters[3], notes: '30g Protein • Zero Refined Sugar',
    applications: ['Recovery Lounges', 'Alpine Ski Lodges', 'Elite Health Spas'],
    specifications: [
      { label: 'Whey Source', value: '100% Grass-Fed Alpine Whey Isolate' },
      { label: 'Pistachio Paste', value: 'Pure Mt. Etna Bronte Kernels' },
      { label: 'Sweetener', value: 'Organic Monk Fruit & Vanilla Pod Extract' },
    ],
    availability: 'In Stock / Regular Supply', featured: false, image: img('pistachio'),
  },
  {
    id: 'sovereign-wooden-chest', name: 'The Sovereign Wooden Chest', category: 'specialty',
    description: 'Hand-crafted dark walnut wooden chest containing a curated selection of six reserve nuts and rare honey-infused seeds. Velvet lined with custom brass lock and key.',
    origin: 'Global Heritage Groves', grade: 'Solid Dark Walnut • Velvet Lined',
    forms: ['Complete 6-Decanter Presentation Chest'],
    packaging: ['Solid Walnut Velvet-Lined Chest (Weight 3.2 kg)'],
    moq: '1 Chest', priceDisplay: '$185 (Complete Presentation)', sovereignPrice: '$450 (Imperial Edition)', netWeight: '6 x 150g Decanters',
    chapter: chapters[3], notes: 'Solid Walnut • Velvet Lined',
    applications: ['Presidential Gifting', 'Bespoke Corporate Curation', 'Heirloom Decor'],
    specifications: [
      { label: 'Woodwork', value: 'Solid Appalachian Black Walnut' },
      { label: 'Lining', value: 'Imperial Burgundy Silk Velvet' },
      { label: 'Inclusions', value: 'Mamra Almonds, Bronte Pistachios, Macadamias, Truffle Seeds, Saffron Seeds, Gold Dates' },
    ],
    availability: 'Made by Commission / Ready Stock', featured: true, image: img('chest'),
  },
  {
    id: 'annual-reserve-pass', name: 'The Annual Reserve Pass (VIP Membership)', category: 'specialty',
    description: 'A quarterly delivery of seasonal micro-batch harvests, shipped directly in customized temperature-sealed brass canisters with private concierge allocation.',
    origin: 'Direct Farmgate Global Reserve', grade: 'VIP Allocation • Free Global Shipping',
    forms: ['Annual 4-Quarter Delivery Subscription'],
    packaging: ['Quarterly Temperature-Sealed Brass Canisters'],
    moq: '1 Annual Membership', priceDisplay: '$650 / year', sovereignPrice: '$1,800 / year (Sovereign Tier)', netWeight: '4 Deliveries x 1.5 kg Reserve',
    chapter: chapters[3], notes: 'VIP Allocation • Free Shipping',
    applications: ['Connoisseur Memberships', 'Executive Retainers', 'Private Collectors'],
    specifications: [
      { label: 'Frequency', value: '4 Deliveries (Spring, Summer, Autumn, Winter)' },
      { label: 'Concierge Service', value: 'Dedicated WhatsApp & Email Sommelier' },
      { label: 'Privilege', value: 'First right of refusal on all Sovereign allocations' },
    ],
    availability: 'Limited to 250 Members Globally', featured: true, image: img('chest'),
  },
]

export function getProduct(id: string) {
  return products.find((p) => p.id === id)
}

export function getCategory(id: CategoryId) {
  return categories.find((c) => c.id === id)
}
