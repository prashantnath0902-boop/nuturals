import { pgTable, serial, text, timestamp } from 'drizzle-orm/pg-core'

export const quoteRequests = pgTable('quote_requests', {
  id: serial('id').primaryKey(),
  reference: text('reference').notNull().unique(),
  visitorId: text('visitor_id').notNull(),
  name: text('name').notNull(),
  company: text('company').notNull(),
  email: text('email').notNull(),
  phone: text('phone'),
  country: text('country').notNull(),
  businessType: text('business_type').notNull(),
  productId: text('product_id'),
  productName: text('product_name'),
  quantity: text('quantity').notNull(),
  packaging: text('packaging'),
  message: text('message'),
  status: text('status').notNull().default('Received'),
  createdAt: timestamp('created_at', { withTimezone: true }).notNull().defaultNow(),
})

export const contactInquiries = pgTable('contact_inquiries', {
  id: serial('id').primaryKey(),
  name: text('name').notNull(),
  email: text('email').notNull(),
  company: text('company'),
  phone: text('phone'),
  subject: text('subject').notNull(),
  message: text('message').notNull(),
  createdAt: timestamp('created_at', { withTimezone: true }).notNull().defaultNow(),
})

export type QuoteRequest = typeof quoteRequests.$inferSelect
