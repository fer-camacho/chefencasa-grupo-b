import { redirect, useLocation } from "react-router-dom";

function Receta({receta}){
  console.log("RECETA:"+receta);
    return (
        <div className="container">
          <h1 className="text-center mt-5 mb-4">{receta.titulo}</h1>
    
          <div className="row">
            <div className="col-md-6">
              <div id="carouselWithControls" className="carousel slide" data-bs-ride="carousel">
                <div className="carousel-inner">
                  <div className="carousel-item active">
                    <img src="img/imagen-receta.jpg" className="img-fluid rounded d-block w-100" alt="Paella Valenciana" />
                  </div>
                  <div className="carousel-item">
                    <img src="img/imagen-receta.jpg" className="img-fluid rounded d-block w-100" alt="Paella Valenciana" />
                  </div>
                  <div className="carousel-item">
                    <img src="img/imagen-receta.jpg" className="img-fluid rounded d-block w-100" alt="Paella Valenciana" />
                  </div>
                </div>
                <a className="carousel-control-prev" href="#carouselWithControls" role="button" data-bs-slide="prev">
                  <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span className="visually-hidden">Previous</span>
                </a>
                <a className="carousel-control-next" href="#carouselWithControls" role="button" data-bs-slide="next">
                  <span className="carousel-control-next-icon" aria-hidden="true"></span>
                  <span className="visually-hidden">Next</span>
                </a>
              </div>
            </div>
    
            <div className="col-md-6">
              <p className="lead">
                <span className="fw-bold">Categoría:</span> {receta.categoria}
              </p>
              <p>
                {receta.descripcion}
              </p>
              <h2 className="mt-5 mb-4">Ingredientes</h2>
              <ul className="list-group">
                {receta.ingredientes.map((ingrediente, index)=>(
                  <li className="list-group-item">{ingrediente}</li>
                ))}
              </ul>
            </div>
          </div>
    
          <p className="lead mt-4"> <span className="fw-bold">Tiempo de preparación:{" "}</span>{receta.tiempoPreparacion}</p>
    
          <h2 className="mt-5 mb-4">Preparación</h2>
    
          <ol className="list-group  mb-5">
            {receta.pasos.map((paso, index)=>(
              <li className="list-group-item">{paso}</li>
            ))}
          </ol>
        </div>
      );
}
export default Receta;