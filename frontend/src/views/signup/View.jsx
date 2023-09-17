import axios from 'axios';
import React, { useState } from 'react';
import imgPortada from '../../img/registroPortada.avif';

function Signup() {
 
    let estilo ={background: "hsla(0, 0%, 100%, 0.55)",backdropFilter: "blur(30px)", marginRight: "-50px"};
    const [user, setUsuario] = useState({
      apellido: '',
      nombre:'',
      email: '',
      password: '',
      usuario: '',
    });
  
    const handleInputChange = (event) => {      
      const { id, value } = event.target;
      setUsuario({ ...user, [id]: value });     
    };
  
    const handleSubmit = async (event) => {
      event.preventDefault();
      const user1 = {       
        nombre: user.nombre+ ' '+ user.apellido,
        email: user.email,
        password: user.password,
        usuario: user.usuario,
      }
  
      try {        
        await axios.post('http://127.0.0.1:5000/crearUsuario', user1);
        console.log('creacion: '+user1);
        alert('Usuario creado exitosamente');
        window.location.href = '/login';
      } catch (error) {
        console.error('Error al crear el usuario', error);
        alert('Error al crear el usuario');
      }
    };
  return (
    <>  
      <section className="text-center text-lg-start">
        <div >
          <div className="container py-4">
            <div className="row g-0 align-items-center">
              <div className="col-lg-6 mb-5 mb-lg-0">
                <div
                  className="card cascadingright"
                  style={estilo}
                >
                  <div className="card-body p-5 shadow-5 text-center">
                    <h2 className="fw-bold mb-5">Registrate Ahora</h2>
                    <form onSubmit={handleSubmit}>
                      <div className="row">
                        <div className="col-md-6 mb-4">
                          <div className="form-outline">
                            <input
                              type="text"
                              id="nombre"
                              className="form-control"
                              value={user.nombre}
                              placeholder="Nombre"
                              onChange={handleInputChange}
                              required
                            />
                          </div>
                        </div>
                        <div className="col-md-6 mb-4">
                          <div className="form-outline">
                            <input
                              type="text"
                              id="apellido"
                              className="form-control"
                              value={user.apellido}
                              placeholder="Apellido"
                              onChange={handleInputChange}
                              required
                            />
                          </div>
                        </div>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="email"
                          id="email"
                          className="form-control"
                          value={user.email}
                          placeholder="Correo Electronico"
                          onChange={handleInputChange}
                          required
                        />
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="usuario"
                          className="form-control"
                          value={user.usuario}
                          placeholder="Usuario"
                          onChange={handleInputChange}
                          required
                        />
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="password"
                          id="password"
                          className="form-control"
                          value={user.password}
                          placeholder="Contraseña"
                          onChange={handleInputChange}
                          required
                        />
                      </div>

                      <button
                        type="submit"
                        className="btn btn-primary btn-block mb-4"
                      >
                        Registrate
                      </button>
                    </form>
                  </div>
                </div>
              </div>

              <div className="col-lg-6 mb-5 mb-lg-0">
                <img
                  src={imgPortada}
                  className="w-100 rounded-4 shadow-4"
                  alt=""
                />
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}

export default Signup;
