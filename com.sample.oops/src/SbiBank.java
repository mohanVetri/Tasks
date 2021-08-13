public class SbiBank extends RbiBank {

    public int interest() {                 //method Overriding
        return 14;
    }

    public String typeOfBank() {
        return super.type;
    }

	public String getRbitypeOfBank() {
		return super.typeOfBank();
	}

}
