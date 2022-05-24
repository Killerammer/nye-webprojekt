import React from "react";
import { ActionType } from "../../globalTypes";

export interface ItemProps{
  id: number;
  name: string;
  genre: string;
  price: number;
//  image: string;
  dispatch: React.Dispatch<ActionType>
  added: boolean
}