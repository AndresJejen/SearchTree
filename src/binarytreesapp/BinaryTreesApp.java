/*
 * Este código implementa un arbol binario de busqueda.
 */
package binarytreesapp;

/**
 *
 * @author andres Jejen Cortes
 * @email gajcam@gmail.com
 * @twitter @andres_jejen
 */
public class BinaryTreesApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        searchTree<Integer> arbol = new searchTree<Integer>();
        
        
        arbol.insert(10,1);
        /*
        arbol.insert(8,2);
        arbol.insert(16,3);
        arbol.insert(21,4);
        arbol.insert(9,5);
        arbol.insert(4,6);
        arbol.insert(15,7);
        */
        arbol.display(arbol.getRoot());
        
        //System.out.println(arbol.find(9));
        
        //arbol.delete(4);
        
        //arbol.display(arbol.getRoot());
        
        System.out.println("-------------PRE ORDEN--------------------");
        arbol.displayPre(arbol.getRoot());
        
        System.out.println("-------------POST ORDEN--------------------");
        arbol.displayPost(arbol.getRoot());
        
        System.out.println("-------------IN ORDEN--------------------");
        arbol.display(arbol.getRoot());
       
        System.out.println("-------------ELIMINAR--------------------");
        arbol.delete(1);
        
        System.out.println("-------------IN ORDEN--------------------");
        arbol.display(arbol.getRoot());
    }
    
}
