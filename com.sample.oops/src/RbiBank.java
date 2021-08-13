public abstract class RbiBank {                 //Abstraction
    
    protected String type="Government Bank";

    public abstract int interest();                 //abstract method

    public String typeOfBank(){                     //Non abstract method
        return type;
    }
}
