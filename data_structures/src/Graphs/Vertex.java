package Graphs;

import java.util.ArrayList;

public class Vertex {
	private String name;
	private ArrayList<Edge> edgeList;
	
	public Vertex(String name) {
		this.name = name;
		edgeList = new ArrayList<>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addEdge(Edge e){
		edgeList.add(e);
	}
	
	public int numOfEdges(){
		return edgeList.size();
	}
	
	public boolean isAdjacent(Vertex v){
		for(Edge e : edgeList){
			if(e.first == v || e.second == v){
				return true;
			}
		}
		return false;
	}
	
	public Edge removeEdge(Vertex v){
		Edge temp = null;
		int i = 0;
		for(Edge e : edgeList){
			if(e.first == v || e.second == v){
				temp = e;
				break;
			}
			i++;
		}
		edgeList.remove(i);
		return temp;		
	}
	
	public ArrayList<Vertex> getAdjacentVerteces(){
		ArrayList<Vertex> adjV = new ArrayList<>();
		for(Edge e : edgeList){
			if(e.first == this){
				adjV.add(e.second);
			}else{
				adjV.add(e.first);
			}
		}
		return adjV;
	}
	
	public void print(){
		System.out.println(this+" : ");
		String temp = "";
		for(Edge e : edgeList){
			if(e.first == this){
				temp += e.second.getName() + " ";
			}else{
				temp += e.first.getName() + " ";
			}
		}
		System.out.print(temp);
	}
}
