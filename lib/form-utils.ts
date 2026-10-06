export type FormState = {
  status: 'idle' | 'success' | 'error'
  message?: string
  errors?: Record<string, string>
  reference?: string
}

export const initialFormState: FormState = { status: 'idle' }

const EMAIL_PATTERN = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/

export function readField(formData: FormData, key: string, maxLength: number) {
  const value = formData.get(key)
  if (typeof value !== 'string') return ''
  return value.trim().slice(0, maxLength)
}

export function isValidEmail(email: string) {
  return EMAIL_PATTERN.test(email)
}
