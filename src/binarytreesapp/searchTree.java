/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreesapp;

/**
 *
 * @author andres
 * @param <T>
 */
public class searchTree<T> {
     
    private Node root;
    
    public searchTree(){
        this.root = null;
    }
    
    public boolean find(int id){
    
        Node current = root;
        
        while(current != null){
        
            if(current.getId() == id){
                return true;
            }
            else if(current.getId() > id){
                current = current.getLeft();
            }
            else{
                current = current.getRight();
            }   
        }
        return false;
    }
    
    public boolean delete(int id){
        
        Node parent = root;
        Node current = root;
        
        boolean isLeftChild = false;
        
        //Encontrar con currenr el elemento
        while(current.getId() != id){
            parent = current;
            if(current.getId() > id){
                isLeftChild = true;
                current = current.getLeft();
            }
            else{
                isLeftChild = false;
                current = current.getRight();
            }
            
            if (current == null){
                return false;
            }
        }
        
        //Evaluacion de casos posibles con los hijos del current encontrado
        //Case 1 ( Caso Current Hoja - Sin hijos )
       if(current.getLeft() == null && current.getRight() == null){
           // Si es el mismo root Eliminar el root
           if(current==root){
               root = null;
           }
           if(isLeftChild == true){
               parent.setLeft(null);
           }
           else{
               parent.setRight(null);
           }
       }
       
       //Case 2 ( Caso Current hoja tiene ambos hijos )
       else if(current.getLeft() != null && current.getRight() != null){
            
            Node successor = getSuccessor(current);
            if(current==root){
                root = successor;
            }
            else if(isLeftChild){
                parent.setLeft(successor); 
            }
            else{
                parent.setLeft(current.getLeft());
            }
        }
        else if(current.getRight() != null){
           if(current == root){
               root = current.getLeft();
           }
           else if(isLeftChild){
               parent.setLeft(current.getLeft());
           }
           else{
               parent.setRight(current.getLeft());
           }
        }
        else if(current.getLeft() != null){
           if(current==root){
               root = current.getRight();
           }
           else if(isLeftChild){
               parent.setLeft(current.getRight());
           }
           else{
               parent.setRight(current.getRight());
           }
        }
        
          return true;
    } 
    
    public Node getSuccessor(Node deleteNode){

        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.getRight();

        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

        if(successor != deleteNode.getRight()){
            successorParent.setLeft(successor.getRight());
            successor.setRight(deleteNode.getRight());
        }

        return successor;
    }


    public void insert(T Element,int id){


        Node<T> newNode = new Node<T>(Element,id);

        //If tree is empty
        if(root == null){
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id < current.getId()){
                current = current.getLeft();
                if(current == null){
                    parent.setLeft(newNode);
                    return;
                }
            }
            else{
                current = current.getRight();
                if(current == null){
                    parent.setRight(newNode); 
                    return;
                }
            }
        }
    }

    public void display(Node root){
        if(root!=null){
            displayPre(root.getLeft());
            System.out.print(" Id:      "+root.getId());
            System.out.println(" Element: "+root.getElemento());
            displayPre(root.getRight());
        }
    }

    public void displayPre(Node root){
        if(root!=null){
            System.out.print(" Id:      " + root.getId());
            System.out.println(" Element: " + root.getElemento());
            displayPre(root.getLeft());
            displayPre(root.getRight());
        }
    }

    public void displayPost(Node root){
        if(root!=null){
            displayPost(root.getLeft());
            displayPost(root.getRight());
            System.out.print(" Id:      "+root.getId());
            System.out.println(" Element: "+root.getElemento());
        }
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root){
        this.root = root;
    }
 
}
