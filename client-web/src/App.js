import { BrowserRouter, Routes, Route } from 'react-router-dom'
import List from './pages/List/List'
import Home from './pages/Home/Home'
import Details from './pages/Details/Details'
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
          <Route
            path='/list'
            element={<List />}
          />
          <Route
            path='/details/:id'
            element={<Details />}
          />
        </Routes>

      </BrowserRouter>
    </div>
  );
}

export default App;
