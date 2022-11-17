import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from './pages/Home/Home'
import Header from './components/Header/Header'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />

        <Routes>
          <Route
            path='/'
            element={<Home />}
          />
        </Routes>
        
      </BrowserRouter>
    </div>
  );
}

export default App;
