import React, { useReducer } from 'react';
import { Layout } from "./Layout";
import { Route, Routes, BrowserRouter } from 'react-router-dom';
import { Home } from "./Pages/Home";
import { Menu } from "./Pages/Menu";
import { Cart } from "./Pages/Cart";
import { Product } from './Pages/Product';
import { Checkout } from './Pages/Checkout';
import { Ctx } from "./Context";

// utils
import { initialState, reducer } from "./globalState";

// css
import './App.scss';
import { StateInterface } from './globalTypes';
import axios from "axios";


function App(): JSX.Element {
  const [state, dispatch] = useReducer(reducer, initialState())

  React.useEffect(() => {
    try{
      fetch('http://localhost:8080/books')
      .then(res => res.json())
      .then(data => dispatch({ type: "ADD_INITIAL_ITEMS", payload: data }))
    }catch(err){
      dispatch({ type: "ERROR" })
    }
  }, [])
 /* async function getBooks() {
    try {
      const response = await axios.get('/books');
      console.log(response);
    } catch (error) {
      console.error(error);
    }
  }*/

  return (
    <Ctx.Provider value={state}>
      <section className="App">
        <BrowserRouter>
          <Layout dispatch={dispatch}>
            <Routes>
              <Route path="/" element={
                <Home
                  state={state as StateInterface}
                  dispatch={dispatch}
                  ctx={Ctx}
                />
              }/>
              <Route path="/menu" element={
                <Menu 
                  state={state as StateInterface}
                  dispatch={dispatch}
                />
              }/>
              <Route path='/shopping-cart' element={
                <Cart 
                  state={state as StateInterface}
                  dispatch={dispatch}
                />
              }/>
              <Route path='/products/:title' element={
                <Product
                  state={state as StateInterface}
                  dispatch={dispatch}
                />
              }/>
              <Route path='/checkout' element={
                <Checkout
                  state={state as StateInterface}
                  dispatch={dispatch}
                />
              }
              />
            </Routes>
          </Layout>
        </BrowserRouter>
      </section>
    </Ctx.Provider>
  );
}

export default App;