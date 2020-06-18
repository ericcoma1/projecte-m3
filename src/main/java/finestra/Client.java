package finestra;

public class Client{
    String nomClient;
    String cognomsCLient;
    String dniClient;

    public Client(String nomClient, String cognomsCLient, String dniClient) {
        this.nomClient = nomClient;
        this.cognomsCLient = cognomsCLient;
        this.dniClient = dniClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getCognomsCLient() {
        return cognomsCLient;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setCognomsCLient(String cognomsCLient) {
        this.cognomsCLient = cognomsCLient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    @Override
    public String toString() {
        return "Client{" + "nomClient=" + nomClient + ", cognomsCLient=" + cognomsCLient + ", dniClient=" + dniClient + '}';
    }

   

    
    
    

}