import { Fragment, useRef, useState } from "react";
import { useNavigate, NavigateFunction } from "react-router-dom"
import { CheckoutInput } from "../../Components/CheckoutInput";
import { ButtonCTA } from "../../Components/ButtonCTA";
import { ILocalState, initialLocalState } from "./types";
import { PageProps } from "../../globalTypes";

export const Checkout: React.FC<PageProps> = ({ state, dispatch}): JSX.Element => {
  const { totalAmount } = state
  const navigate: NavigateFunction = useNavigate()
  const [localState, setLocalState] = useState<ILocalState>(initialLocalState)
  const [isModalOpen, setIsModalOpen] = useState<boolean>(false)
  const errorRef = useRef<HTMLSpanElement>(null)
  const handleConfirmation = () => {
    setIsModalOpen(false)
    if(dispatch){
      dispatch({ type: "MUFAJOK", payload: "Összes" })
      dispatch({ type: "RESET" })
    }
    setTimeout(() => {
      window.scrollTo(0, 0)
    }, 0)
    navigate("/")
  }

  const handleChange = (evt: React.ChangeEvent<HTMLSelectElement | HTMLInputElement>) => {
    setLocalState(prev => ({
      ...prev,
      [evt.target.id]: evt.target.value
    }))
  }

  const handleSubmit = () => {
    let flag: boolean = true

    Object.values(localState).forEach(value => {
      if(!value) flag = false
    })

    if(flag){
      errorRef.current?.classList.remove("error")
      setIsModalOpen(true)
    }else{
      errorRef.current?.classList.add("error")
      window.scroll({
        top: 10000,
        behavior: 'smooth'
      });
    }
  }

  return(
    <Fragment>

      <section className="Checkout">
        <form className="Checkout__form">
          <CheckoutInput
            name="Teljes név"
            id="fullName"
            type="text"
            placeholder="Víz Elek"
            onchange={handleChange}
          />
          <CheckoutInput
            name="Email cím"
            id="email"
            type="email"
            placeholder="vizelek@gmail.com"
            onchange={handleChange}
          />
          <CheckoutInput
            name="Ország"
            id="country"
            type="select"
            onchange={handleChange}
          />
          <CheckoutInput
            name="Cím"
            id="address"
            type="text"
            placeholder="Utca és Házszam"
            onchange={handleChange}
          />
          <CheckoutInput
            name="Kártya száma"
            id="cardNumber"
            type="number"
            placeholder="1234 1234 1234 1234"
            onchange={handleChange}
          />
          <CheckoutInput
            name="Lejárati Dátum"
            id="expirationDate"
            type="number"
            placeholder="MM / YY"
            onchange={handleChange}
          />
          <CheckoutInput
            name="Irányítószám"
            id="zipCode"
            type="number"
            placeholder="4400"
            onchange={handleChange}
          />
          <span className="Checkout__error" ref={errorRef}>
            Töltsd ki kérlek az összes mezőt!
          </span>
        </form>

        <button className="Checkout__cta" onClick={handleSubmit}>
          <h2>Végösszeg: {totalAmount} Ft.</h2>
        </button>
      </section>

      {isModalOpen && (
        <section className="Modal">
          <div className="Modal__card">
            <h2>
              Köszönjük a rendelésed és a pénzed!
            </h2>
            <div className="Modal__card--footer">
              <ButtonCTA content="Értem" onclick={handleConfirmation} />
            </div>
          </div>
        </section>
      )}
    </Fragment>
  )
}