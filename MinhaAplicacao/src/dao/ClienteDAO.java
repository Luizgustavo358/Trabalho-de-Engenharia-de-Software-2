package dao;
import factory.ConnectionFactory;
import modelo.Cliente;
import java.sql.*;
import java.sql.PreparedStatement;
public class ClienteDAO { 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;
    public ClienteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Cliente cliente){ 
        String sql = "INSERT INTO cliente(tipusu,nomcli,cpfcnpj) VALUES(?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getTipcli());
            stmt.setString(2, cliente.getNomcli());
            stmt.setString(3, cliente.getCpfcnpj());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}