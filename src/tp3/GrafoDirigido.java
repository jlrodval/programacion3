package ProgramacionIII.tp3;

import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {

	private List<Integer> vertices;
    private List<Arco<T>> arcos;

	@Override
	public void agregarVertice(int verticeId) {
        if (!contieneVertice(verticeId)) {
            vertices.add(verticeId);
        }
    }

	@Override
	public void borrarVertice(int verticeId) {
        //Primero borramos las aristas que tienen al vértice que queremos eliminar
    	for (int i = 0; i < aristas.size(); i++) {
        	Arco<T> arco = aristas.get(i);
			if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
				aristas.remove(i);
				i--;
			}
		}
    	// Luego borramos el vértice de la lista de vértices
    	vertices.remove((Integer) verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> arco = this.obtenerArco(verticeId1, verticeId2);
		if (arco != null) {
			arcos.remove(arco);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.contains(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		for (Arco<T> arco: arcos){			
			if ((arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) ||
            	(arco.getVerticeOrigen() == verticeId2 && arco.getVerticeDestino() == verticeId1)) {
            	return true;
        	}
    	}
    	return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		for (Arco<T> arco: arcos){			
			if (this.existeArco(verticeId1, verticeId2)) {
            	return arco;
        	}
    	}
    	return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		return arcos.size();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		List<Integer> verticesTmp = new ArrayList<>();
    	for (Integer vertice : vertices) {
			verticesTmp.add(vertice);
    	}
    	return verticesTmp.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		List<Arco<T>> adyacentes = new ArrayList<>();
    	for (Arco<T> arco : arcos) {
        	if (arco.getVerticeOrigen() == verticeId) {
            	adyacentes.add(arco.getVerticeDestino());
        	}
    	}
    	return arcosTmp.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> arcosTmp = new ArrayList<>();
    	for (Arco<T> arco : arcos) {
			arcosTmp.add(arco);
    	}
    	return arcosTmp.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		List<Arco<T>> arcosTmp = new ArrayList<>();
    	for (Arco<T> arco : arcos) {
        	if ((arco.getVerticeOrigen() == verticeId) || (arco.getVerticeDestino() == verticeId)) {
            	arcosTmp.add(arco);
        	}
    	}
    	return arcosTmp.iterator();
	}

}
