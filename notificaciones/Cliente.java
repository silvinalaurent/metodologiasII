public class Cliente { 
    private String nombre; 
    private String email; 
    private String telefono; 
    private String dni;
    private boolean prefiereEmail; 
    private boolean prefiereSMS; 
     
    public Cliente(String nombre, String email, String telefono, String dni) { 
        this.nombre = nombre; 
        this.email = email; 
        this.telefono = telefono; 
        this.dni = dni;
    } 
     
    // Getters y setters 
    public String getNombre() { return nombre; } 
    public String getEmail() { return email; } 
    public String getTelefono() { return telefono; } 
    public String getDni() { return dni; } 
    
    public void setPreferencias(boolean email, boolean sms) { 
        this.prefiereEmail = email; 
        this.prefiereSMS = sms; 
    } 
     
    public boolean prefiereEmail() { return prefiereEmail; } 
    public boolean prefiereSMS() { return prefiereSMS; } 
}