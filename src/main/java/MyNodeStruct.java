public class MyNodeStruct {

    private int hashCode;
    private String ownerName,ownerId;
    private double value;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = Math.round(value * 100.0) / 100.0;
    }


}