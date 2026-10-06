const controlClass =
  'w-full rounded-lg border border-border bg-card px-4 py-3 text-sm outline-none transition-colors placeholder:text-muted-foreground/70 focus:border-accent aria-[invalid=true]:border-destructive'

type BaseProps = {
  name: string
  label: string
  error?: string
  required?: boolean
  className?: string
}

function FieldShell({ name, label, error, required, className, children }: BaseProps & { children: React.ReactNode }) {
  return (
    <div className={`flex flex-col gap-1.5 ${className ?? ''}`}>
      <label htmlFor={name} className="text-sm font-medium">
        {label}
        {required && <span className="text-accent"> *</span>}
      </label>
      {children}
      {error && (
        <p id={`${name}-error`} className="text-xs text-destructive">
          {error}
        </p>
      )}
    </div>
  )
}

export function TextField({
  type = 'text',
  defaultValue,
  placeholder,
  autoComplete,
  ...props
}: BaseProps & { type?: string; defaultValue?: string; placeholder?: string; autoComplete?: string }) {
  return (
    <FieldShell {...props}>
      <input
        id={props.name}
        name={props.name}
        type={type}
        required={props.required}
        defaultValue={defaultValue}
        placeholder={placeholder}
        autoComplete={autoComplete}
        aria-invalid={props.error ? true : undefined}
        aria-describedby={props.error ? `${props.name}-error` : undefined}
        className={controlClass}
      />
    </FieldShell>
  )
}

export function TextAreaField({ placeholder, defaultValue, ...props }: BaseProps & { placeholder?: string; defaultValue?: string }) {
  return (
    <FieldShell {...props}>
      <textarea
        id={props.name}
        name={props.name}
        required={props.required}
        rows={5}
        defaultValue={defaultValue}
        placeholder={placeholder}
        aria-invalid={props.error ? true : undefined}
        aria-describedby={props.error ? `${props.name}-error` : undefined}
        className={controlClass}
      />
    </FieldShell>
  )
}

export function SelectField({
  options,
  defaultValue,
  placeholder,
  ...props
}: BaseProps & { options: { value: string; label: string }[]; defaultValue?: string; placeholder?: string }) {
  return (
    <FieldShell {...props}>
      <select
        id={props.name}
        name={props.name}
        required={props.required}
        defaultValue={defaultValue ?? ''}
        aria-invalid={props.error ? true : undefined}
        aria-describedby={props.error ? `${props.name}-error` : undefined}
        className={controlClass}
      >
        <option value="">{placeholder ?? 'Select an option'}</option>
        {options.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </select>
    </FieldShell>
  )
}

export function SubmitButton({ pending, children }: { pending: boolean; children: React.ReactNode }) {
  return (
    <button
      type="submit"
      disabled={pending}
      className="inline-flex items-center justify-center rounded-full bg-primary px-7 py-3 text-sm font-medium text-primary-foreground transition-opacity hover:opacity-90 disabled:opacity-60"
    >
      {pending ? 'Sending…' : children}
    </button>
  )
}
