import React from "react";

export interface ChangeQuantityInterface{
  id: number;
  quantity: number
}

export interface RoutesInterface{
  current: string;
  history: string;
}

export interface ItemInterface{
  id: number;
  genre: string;
  author: string;
  image: string;
  price: number;
  title: string;
  quantity?: number;
  added?: boolean

/*{
  "id": 0, number
  "title": "string",
  "author": "string",
  "genre": "string",
  "releaseDate": "2022-05-22T19:37:50.206Z",
  "price": 0,
  "pageNumber": 0,
  "publisher": "string",
  "isbn": "string"
}*/
}

export interface StateInterface{
  items: Array<ItemInterface>,
  filteredItems: Array<ItemInterface>,
  shoppingCart: Array<ItemInterface>,
  searching: string,
  genres: Array<string>,
  current: string,
  history: string,
  isSearching: boolean,
  filterAt: string,
  totalAmount: number,
  error: boolean,
  loading: boolean
}

export type ActionType = {
  type: string,
  payload?: 
    | ItemInterface[] 
    | string 
    | number 
    | ChangeQuantityInterface
    | RoutesInterface
}

export interface PageProps {
  state: StateInterface;
  dispatch?: React.Dispatch<ActionType>;
  ctx?: React.Context<StateInterface>
}