import "./App.css";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import ReactDOM from "react-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import SignUp from "./views/signup/View.jsx";
import Login from "./views/login/View.jsx";
import Home from "./views/home/View.jsx";
import RecetaView from "./views/receta/View.jsx";
import Usuario from "./views/usuario/View.jsx";
import Scripts from "./Scripts";
import NavBar from "./components/NavBar";
import Footer from "./components/Footer";

//
//
//
function App() {
  return (
    <div className="App">
      <NavBar></NavBar>
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/crearusuario" element={<SignUp />} />
          <Route path="/" element={<Home />} />
          <Route path="/receta" element={<RecetaView key={Math.random()}/>} />
          <Route path="/usuario" element={<Usuario key={Math.random()} />} />
        </Routes>
      </BrowserRouter>
      <Footer></Footer>
      <Scripts></Scripts>
    </div>
  );
}

export default App;
