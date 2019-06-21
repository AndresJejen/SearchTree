/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreesapp;

/**
 *
 * @author andres
 */
public class Node<T> {
    
    //Fields
    private Node Right;
    private Node Left;
    private T Elemento;
    private int Altura;
    private int id;
    
    //Encapsulate Fields
    public Node getRight() {
        return Right;
    }

    public void setRight(Node Right) {
        this.Right = Right;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }
    
    public Node getLeft() {
        return Left;
    }

    public void setLeft(Node Left) {
        this.Left = Left;
    }

    public T getElemento() {
        return Elemento;
    }

    public void setElemento(T Elemento) {
        this.Elemento = Elemento;
    }
    
    //Constructor
    public Node(T Elemento, int id){
        this.Elemento = Elemento;
        this.Left = null;
        this.Right = null;
        this.Altura = 0;
        this.id = id;
    }
   
}
