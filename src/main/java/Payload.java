import java.io.Serializable;

public class Payload implements Serializable {

    private static final long serialVersionUID = 5031142193097262566L;
    public int pktSize;
    public String message;
    public String fileSize;
    public String fileName;
    public byte[] file;

    public Payload() {
    }



}
