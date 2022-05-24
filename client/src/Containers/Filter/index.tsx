import React, { useContext } from "react";
import { FilterProps } from "./types";
import { ButtonCategory } from "../../Components/ButtonCategory";
import { Ctx } from "../../Context";

export const Filter: React.FC<FilterProps> = ({ dispatch, isInHeader }): JSX.Element => {
  const state = useContext(Ctx)
  const { genres, filterAt, searching } = state
  const handleChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    dispatch({ type: "MUFAJOK", payload: e.target.value })
  }

  return(
    <section className="Filter">
      <select defaultValue={searching ? "Összes" : filterAt} className="Filter__dropdown" onChange={handleChange}>
        {genres.map(genre => (
          <option value={genre} key={genre}>
            {genre}
          </option>
        ))}
      </select>

      {genres.map(genre => (
        <ButtonCategory 
          key={genre}
          content={genre}
          dispatch={dispatch}
          to={isInHeader ? "/" : ""}
        />
      ))}
    </section>
  )
}