// UserContext.js
import React, { createContext, useState, useEffect} from 'react';
import axios from 'axios'; // Importa Axios si aún no lo has hecho

const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    console.log('User context updated:', user);
  }, [user]);

//USUARIO
const obtenerUsuarioPorId = async (userId) => {
  try {
    const response = await axios.get(`http://127.0.0.1:5000/traerUsuarioPorId/${userId}`);
    return response.data;
  } catch (error) {
    console.error('Error al obtener el usuario:', error);
    throw error;
  }
};
  async function traerUsuarioPorId(userId) {
    try {
      const usuario = await obtenerUsuarioPorId(userId);
      console.log('Usuario obtenido:', usuario);
      return usuario;
    } catch (error) {
      // Manejo de errores
      console.error('Error al obtener y mostrar el usuario:', error);
    }
  }
  async function obtenerUsuario(user) {
    try {
      const response = await axios.get(`http://127.0.0.1:5000/obtenerUsuario?usuario=${user.usuario}&password=${user.password}`);
      return response.data.usuarioObject;
    } catch (error) {
      console.error('Error al obtener el usuario:', error);
      throw error;
    }
  };
  
  const obtenerUsuariosSeguidos = async (userId) => {
    try {
      const response = await axios.get(`http://127.0.0.1:5000/traerUsuariosSeguidos/${userId}`);
      return response.data;
    } catch (error) {
      console.error('Error al obtener el usuarioSeguidos:', error);
      throw error;
    }
  };
    async function traerUsuariosSeguidos(userId) {
      try {
        const seguidos = await obtenerUsuariosSeguidos(userId);
        console.log('Usuarios Segudos:', seguidos);
        return seguidos;
      } catch (error) {
        // Manejo de errores
        console.error('Error al obtener y mostrar el usuario:', error);
      }
    }

  //RECETAS
  async function traerRecetas() {
    try {
      const response = await axios.get(`http://127.0.0.1:5000/traerRecetas`);
      return response.data;
    } catch (error) {
      console.error('Error al obtener las recetas:', error);
      throw error;
    }
  }
  const obtenerRecetaPorId = async (recetaId) => {
    try {
      const response = await axios.get(`http://127.0.0.1:5000/traerReceta/${recetaId}`);
      return response.data;
    } catch (error) {
      console.error('Error al obtener la receta:', error);
      throw error;
    }
  };
    async function traerRecetaPorId(recetaId) {
      try {
        const receta = await obtenerRecetaPorId(recetaId);
        console.log('Receta obtenida:', receta);
        return receta;
      } catch (error) {
        // Manejo de errores
        console.error('Error al obtener y mostrar el usuario:', error);
      }
    }

  const obtenerRecetasPorFiltro= async(categoria, titulo, ingredientes, tiempoDesde, tiempoHasta, autorId, favoritoUsuarioId) =>{
    try {
      const params = new URLSearchParams({
        categoria: categoria || '',
        titulo: titulo || '',
        ingredientes: ingredientes || '',
        tiempo_desde: tiempoDesde !== null ? tiempoDesde.toString() : '',
        tiempo_hasta: tiempoHasta !== null ? tiempoHasta.toString() : '',
        autorId: autorId !== null ? autorId.toString() : '',
        favoritoUsuarioId: favoritoUsuarioId !== null ? favoritoUsuarioId.toString() : ''
      });
  
      const url = `http://127.0.0.1:5000/traerPorFiltro?${params.toString()}`;
      
      
      //const url = `http://127.0.0.1:5000/traerPorFiltro?categoria=${categoria}&titulo=${titulo}&ingredientes=${ingredientes}&tiempo_desde=${tiempoDesde}&tiempo_hasta=${tiempoHasta}&autorId=${autorId}&favoritoUsuarioId=${favoritoUsuarioId}`;
      const response = await axios.get(url);
      return response.data;
    } catch (error) {
      console.error('Error al obtener las recetas por filtro:', error);
      throw error;
    }
  };
  async function traerRecetasPorFiltro(categoria, titulo, ingredientes, tiempoDesde, tiempoHasta, autorId, favoritoUsuarioId){
    try {
      const recetas = await obtenerRecetasPorFiltro(categoria, titulo, ingredientes, tiempoDesde, tiempoHasta, autorId, favoritoUsuarioId);
      console.log('traerRecetasPorFiltro obtenido:', recetas);
      return recetas;
    } catch (error) {
      // Manejo de errores
      console.error('Error al traer las recetas por filtro:', error);
    }
  }

  return (
    <UserContext.Provider value={{ user, setUser, traerUsuarioPorId ,obtenerUsuario, traerUsuariosSeguidos, traerRecetas,traerRecetaPorId, traerRecetasPorFiltro}}>
      {children}
    </UserContext.Provider>
  );
};

export default UserContext;
