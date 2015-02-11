package co.com.edu.udea.micine.model;
// Generated 11/02/2015 07:39:26 AM by Hibernate Tools 3.6.0



/**
 * SalaId generated by hbm2java
 */
public class SalaId  implements java.io.Serializable {


     private int idSala;
     private int cineIdCine;

    public SalaId() {
    }

    public SalaId(int idSala, int cineIdCine) {
       this.idSala = idSala;
       this.cineIdCine = cineIdCine;
    }
   
    public int getIdSala() {
        return this.idSala;
    }
    
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
    public int getCineIdCine() {
        return this.cineIdCine;
    }
    
    public void setCineIdCine(int cineIdCine) {
        this.cineIdCine = cineIdCine;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SalaId) ) return false;
		 SalaId castOther = ( SalaId ) other; 
         
		 return (this.getIdSala()==castOther.getIdSala())
 && (this.getCineIdCine()==castOther.getCineIdCine());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdSala();
         result = 37 * result + this.getCineIdCine();
         return result;
   }   


}


