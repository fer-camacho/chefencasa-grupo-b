import bkgImg from "../../img/wallpaper.jpg";
import bkgImg1 from "../../img/portada.webp";
import React, { useState, useContext } from "react";
import UserContext from "../../context/UserContext";

function Login() {
  const { setUser } = useContext(UserContext);
  const [formData, setFormData] = useState({
    userName: "",
    password: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch("http://127.0.0.1:5000/loginUsuario", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        const user = await response.json();
        setUser(user);
      } else {
        console.error("Inicio de sesión fallido");
      }
    } catch (error) {
      console.error("Error al iniciar sesión", error);
    }
  };
  //const img = required(`url()`)
  return (
    <section
      className="vh-100"
      style={{ backgroundImage: "url(" + bkgImg + ")" }}
    >
      <div className="container py-5 h-100">
        <div className="row d-flex justify-content-center align-items-center h-100">
          <div className="col col-xl-10">
            <div className="card" style={{ borderRadius: "1rem" }}>
              <div className="row g-0">
                <div className="col-md-6 col-lg-5 d-none d-md-block">
                  <img
                    src={bkgImg1}
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: "1rem 0 0 1rem" }}
                  />
                </div>
                <div className="col-md-6 col-lg-7 d-flex align-items-center">
                  <div className="card-body p-4 p-lg-5 text-black">
                    <form onSubmit={handleSubmit}>
                      <div className="d-flex align-items-center mb-3 pb-1">
                        <i
                          className="fas fa-cubes fa-2x me-3"
                          style={{ color: "#ff6219" }}
                        ></i>
                        <span className="h1 fw-bold mb-0">Chef En Casa</span>
                      </div>

                      <h5
                        className="fw-normal mb-3 pb-3"
                        style={{ letterSpacing: "1px" }}
                      >
                        Inicia Sesion
                      </h5>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="form2Example17"
                          name="userName"
                          className="form-control form-control-lg"
                          placeholder="Usuario"
                          value={formData.userName}
                          onChange={handleChange}
                          required
                        />
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="password"
                          id="form2Example27"
                          name="password"
                          className="form-control form-control-lg"
                          placeholder="Contraseña"
                          value={formData.password}
                          onChange={handleChange}
                          required
                        />
                      </div>

                      <div className="pt-1 mb-4">
                        <button
                          className="btn btn-dark btn-lg btn-block"
                          type="submit"
                        >
                          Iniciar Sesión
                        </button>
                      </div>

                      <p className="mb-5 pb-lg-2" style={{ color: "#393f81" }}>
                        ¿No tienes cuenta?{" "}
                        <a href="/crearusuario" style={{ color: " #393f81" }}>
                          Registrate aqui
                        </a>
                      </p>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
export default Login;
