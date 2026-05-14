import { useEffect, useState } from "react";

function TareasList() {
  const [tareas, setTareas] = useState([]);

  useEffect(() => {
    obtenerTareas();
  }, []);

  const obtenerTareas = async () => {
    const response = await fetch("http://localhost:8080/tasks");
    const data = await response.json();
    setTareas(data);
  };

  return (
    <div>
      <h1>Lista de tareas</h1>
      {tareas.map((tarea) => (
        <div key={tarea.id}>
          <h3>{tarea.titulo}</h3>
          <p>{tarea.descripcion}</p>
          <p>{tarea.estado}</p>
        </div>
      ))}
    </div>
  );
}

export default TareasList;