// UserContext.js
import React, { createContext, useState, useContext } from 'react';
import axios from 'axios'; // Importa Axios si aún no lo has hecho

const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null);

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

  //RECETAS
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
    <UserContext.Provider value={{ user, setUser, traerUsuarioPorId , obtenerUsuarioPorId, obtenerRecetasPorFiltro, traerRecetasPorFiltro}}>
      {children}
    </UserContext.Provider>
  );
};

export default UserContext;
