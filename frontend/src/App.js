import "./App.css";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import ReactDOM from "react-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import SignUp from "./views/signup/View.jsx";
import Login from "./views/login/View.jsx";
import Home from "./views/home/View.jsx";
import Scripts from "./Scripts";
import Navbar from "./components/NavBar";
import Footer from "./components/Footer";

//
//
//
function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      <BrowserRouter>
        <Routes>
          <Route path="/crearusuario" element={<SignUp />} />
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </BrowserRouter>
      <Footer></Footer>
      <Scripts></Scripts>
    </div>
  );
}

export default App;
