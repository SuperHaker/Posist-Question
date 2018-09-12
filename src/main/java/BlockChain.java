import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BlockChain {

    static String rootId = "00000000000000000000000000000000";

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String sNull[]=null;
        String[] sChild = new String[]{"1", "2","3"};

        //Creation of B node
        MyNode B = new MyNode();
        MyNodeStruct dataB = new MyNodeStruct();
        dataB.setOwnerId(rootId);
        dataB.setOwnerName("root");
        dataB.setValue(17);
        dataB.setHashCode((rootId + "root" + 17).hashCode());
        B.setTimeStamp(dtf.format(LocalDateTime.now()));
        B.setNodeNumber(2);
        B.setNodeId(Integer.toString((rootId + "root" + 17).hashCode()));
        B.setChildReferenceNodeId(sNull);

        //Creation of C node
        MyNode C = new MyNode();
        MyNodeStruct dataC = new MyNodeStruct();
        dataC.setOwnerId(rootId);
        dataC.setOwnerName("root");
        dataC.setValue(10);
        dataC.setHashCode((rootId + "root" + 10).hashCode());
        C.setTimeStamp(dtf.format(LocalDateTime.now()));
        C.setNodeNumber(3);
        C.setNodeId(Integer.toString((rootId + "root" + 10).hashCode()));
        C.setChildReferenceNodeId(sNull);

        //Creation of D node
        MyNode D = new MyNode();
        MyNodeStruct dataD = new MyNodeStruct();
        dataD.setOwnerId(rootId);
        dataD.setOwnerName("root");
        dataD.setValue(3);
        dataD.setHashCode((rootId + "root" + 3).hashCode());
        D.setTimeStamp(dtf.format(LocalDateTime.now()));
        D.setNodeNumber(3);
        D.setNodeId(Integer.toString((rootId + "root" + 3).hashCode()));
        D.setChildReferenceNodeId(sNull);

        //Creation of Genesis Node
        MyNode root = new MyNode();
        MyNodeStruct data = new MyNodeStruct();
        data.setOwnerId(null);
        data.setOwnerName("root");
        data.setValue(30);
        data.setHashCode((rootId + "root" + 30).hashCode());
        root.setTimeStamp(dtf.format(LocalDateTime.now()));
        root.setNodeNumber(0);
        root.setNodeId(rootId);
        root.setChildReferenceNodeId(sChild);

    }
}