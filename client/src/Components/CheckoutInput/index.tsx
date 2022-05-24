import { CheckoutInputProps } from "./types";

export const CheckoutInput: React.FC<CheckoutInputProps> = ({ 
  name,
  id,
  type,
  placeholder,
  onchange
}): JSX.Element => {
  const handleChange = (evt: React.ChangeEvent<HTMLSelectElement | HTMLInputElement>) => {
    onchange(evt)
  }

  return(
    <div className="CheckoutInput">
      <label htmlFor={id}>{name}</label>
      {type === "select" ? (
        <select id={id} onChange={handleChange}>
          <option>Válassz egy országot</option>
          <option value="hu">Magyarország</option>
          <option value="uk">Ukrajna</option>
          <option value="au">Ausztria</option>
          <option value="ro">Románia</option>
          <option value="sk">Szlovákia</option>
          <option value="sl">Szlovénia</option>
          <option value="sb">Szerbia</option>
          <option value="cro">Horvátország</option>
        </select>
      ) : (
        <input
          id={id}
          type={type}
          placeholder={placeholder}
          onChange={handleChange}
        />
      )}
    </div>
  )
}