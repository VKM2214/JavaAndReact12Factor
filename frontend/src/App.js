import React from 'react';
    
import './App.css';

    import {
    Routes,
    Route
    } from "react-router-dom";
    import ModalComponent from './ModalComponent';
    import CardComponents from './CardComponents';
    
    
    function App() {
    return (
      <div className="App">
        <h1>USER DATA</h1>
        <Routes>
          <Route path="/" element={<CardComponents />} />
          <Route path="ModalComponent" element={<ModalComponent />} />
        </Routes>
      </div>
    )
    };    

export default App;
