
package ds.socket.server.model;

public class Supermarket implements java.io.Serializable{
    
    private String productID;
   
    
    
    public Supermarket(){
    }
    
    public Supermarket(String productID){
        this.productID = productID;
    }       

    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }
  
 }   
         

