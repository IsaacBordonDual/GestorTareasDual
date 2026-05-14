const API_URL = 'http://localhost:8080/tasks';

export interface Tarea {
  id: number;
  titulo: string;
  descripcion: string;
  estado: string;
  fechaCreacion: string;
}

export const getTareas = async (): Promise<Tarea[]> => {
  try {
    const response = await fetch(API_URL);
    if (!response.ok) {
      throw new Error('Error al obtener las tareas');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error:', error);
    return [];
  }
};

export const getTareasById = async (id: number): Promise<Tarea> => {
  try {
    const response = await fetch(`${API_URL}/${id}`);
    if (!response.ok) {
      throw new Error('Error al obtener la tarea');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
};

export const ActualizarTarea = async (id: number, tarea: Tarea): Promise<Tarea> => {
  try {
    const response = await fetch(`${API_URL}/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(tarea),
    });
    if (!response.ok) {
      throw new Error('Error al actualizar la tarea');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
};

export const eliminarTarea = async (id: number): Promise<void> => {
  try {
    const response = await fetch(`${API_URL}/${id}`, {
      method: 'DELETE',
    });
    if (!response.ok) {
      throw new Error('Error al eliminar la tarea');
    }
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
};