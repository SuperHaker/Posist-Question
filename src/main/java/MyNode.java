class MyNode {

    private String timeStamp;
    private String nodeId, referenceNodeId, genesisReferenceNodeId;
    private String[] childReferenceNodeId;
    private int nodeNumber,hashValue;
    private MyNodeStruct data;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public MyNodeStruct getData() {
        return data;
    }

    public void setData(MyNodeStruct data) {
        this.data = data;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getReferenceNodeId() {
        return referenceNodeId;
    }

    public void setReferenceNodeId(String referenceNodeId) {
        this.referenceNodeId = referenceNodeId;
    }

    public String getGenesisReferenceNodeId() {
        return genesisReferenceNodeId;
    }

    public void setGenesisReferenceNodeId(String genesisReferenceNodeId) {
        this.genesisReferenceNodeId = genesisReferenceNodeId;
    }

    public int getHashValue() {
        return hashValue;
    }

    public void setHashValue(int hashValue) {
        this.hashValue = hashValue;
    }

    public String[] getChildReferenceNodeId() {
        return childReferenceNodeId;
    }

    public void setChildReferenceNodeId(String[] childReferenceNodeId) {
        this.childReferenceNodeId = childReferenceNodeId;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

}
