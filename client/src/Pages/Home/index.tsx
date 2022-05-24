import React from "react";

import { Filter } from "../../Containers/Filter";
import { Item } from "../../Components/Item";
import { Skeleton } from "../../Containers/Skeleton";
import { ActionType, PageProps } from "../../globalTypes";

export const Home: React.FC<PageProps> = ({ state, dispatch, ctx }): JSX.Element => {

  const renderContent = (): JSX.Element => {
    if(state.filteredItems.length){
      return(
        <React.Fragment>
          <Filter
            dispatch={dispatch as React.Dispatch<ActionType>}
          />

          <section className="Home__items">
            {state.filteredItems.map(item => (
              <Item 
                key={item.id}
                id={item.id}
                name={item.title} 
                genre={item.genre}
                price={item.price}
                image={item.image}
                dispatch={dispatch as React.Dispatch<ActionType>}
                added={item.added as boolean}
              />
            ))}
          </section>
        </React.Fragment>
      )
    }else{
      if(state.searching){
        return(
          <React.Fragment>
            <Filter
              dispatch={dispatch as React.Dispatch<ActionType>}
            />
            <span className="Home__no-found">Még nincs ilyen könyv a tarsolyunkban.</span>
          </React.Fragment>
        )
      }else{
        return(<Skeleton />)
      }
    }
  }

  return(
    <section className="Home">
      {state.error ? (
        <h2>Valami hiba történt, próbáld meg később! </h2>
      ) : (
        renderContent()
      )}

    </section>
  )
}