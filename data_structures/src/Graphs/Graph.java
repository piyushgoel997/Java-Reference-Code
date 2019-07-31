package Graphs;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Vertex> vertices;

	public Graph() {
		vertices = new ArrayList<>();
	}

	public void print(){
		for(Vertex v : vertices){
			v.print();
		}
	}

	// i.e. order
	public int numberOfVertces(){
		return vertices.size();
	}

	// i.e. size
	public int numberOfEdges(){
		int num = 0;
		for(Vertex v : vertices){
			num += v.numOfEdges();
		}		
		return num/2;
	}

	public void addVertex(String name){
		if(isVertexPresent(name)){
			return;
		}
		Vertex v = new Vertex(name);
		vertices.add(v);
	}

	private boolean isVertexPresent(String name) {
		for(Vertex v : vertices){
			if(v.getName().equals(name)){
				return true;
			}
		}
		return false;
	}

	public Vertex getVertex(String name){
		for(Vertex v : vertices){
			if(v.getName().equals(name)){
				return v;
			}
		}
		return null;
	}

	public void addEdge(String name1, String name2){
		if(!isVertexPresent(name1) || !isVertexPresent(name2)){
			return;
		}
		if(areAdjacent(name1,name2)){
			return;
		}
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		Edge e = new Edge(v1,v2);
		v1.addEdge(e);
		v2.addEdge(e);
	}

	private boolean areAdjacent(String name1, String name2) {
		Vertex v1 = getVertex(name1), v2 = getVertex(name2);
		if(v1 == null || v2 == null){
			return false;
		}
		return v1.isAdjacent(v2);
	}

	public void removeEdge(String name1, String name2){
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		if(v1 == null || v2 == null){
			return ;
		}
		if(!areAdjacent(name1, name2)){
			return;
		}
		v1.removeEdge(v2);
		v2.removeEdge(v1);
	}
	
	public void removeVertex(String name){
		Vertex v = getVertex(name);
		if(v == null){
			return;
		}

		ArrayList<Vertex> adjacentVertices = v.getAdjacentVerteces();
		for(Vertex adjVertex : adjacentVertices){
			adjVertex.removeEdge(v);
		}	
		vertices.remove(v);
	}
	
		
}
