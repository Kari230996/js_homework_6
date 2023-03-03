import java.util.HashSet;
import java.util.Set;

public class Notebook {
    private String name;
    private String storage;
    private String operationSystem;
    private int price;
    private boolean touchScreen;
    private Set<Notebook> notebooks;

    public Notebook(String name, String storage, String operationSystem, int price, boolean touchScreen ) {
        this.name = name;
        this.storage = storage;
        this.operationSystem = operationSystem;
        this.price = price;
        this.touchScreen = touchScreen;
        this.notebooks = new HashSet<>();
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((storage == null) ? 0 : storage.hashCode());
        result = prime * result + ((operationSystem == null) ? 0 : operationSystem.hashCode());
        result = prime * result + price;
        result = prime * result + (touchScreen ? 1231 : 1237);
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (storage == null) {
            if (other.storage != null)
                return false;
        } else if (!storage.equals(other.storage))
            return false;
        if (operationSystem == null) {
            if (other.operationSystem != null)
                return false;
        } else if (!operationSystem.equals(other.operationSystem))
            return false;
        if (price != other.price)
            return false;
        if (touchScreen != other.touchScreen)
            return false;
        return true;
    }








    @Override
    public String toString() {
        return "Notebook [name=" + name + ", storage=" + storage + ", operationSystem=" + operationSystem + ", price="
                + price + ", touchScreen=" + touchScreen + "]\n";
    }


    
    public void add(Notebook notebook) {
        notebooks.add(notebook);
    }
     
   

    public String getName() {
        return name;
    }

    public String getStorage() {
        return storage;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getTouchScreen() {
        return touchScreen;
    }
}
