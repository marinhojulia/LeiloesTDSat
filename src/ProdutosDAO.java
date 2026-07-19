
/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public ProdutosDAO(){
        conectaDAO dao = new conectaDAO();
        conn = dao.connectDB();
    }
        
        public boolean cadastrarProduto(ProdutosDTO produtos){
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES " + "(?,?,?)";
        try{
            prep = this.conn.prepareStatement(sql);
            prep.setString(1, produtos.getNome());
            prep.setInt(2, produtos.getValor());
            prep.setString(3, produtos.getStatus());
            prep.execute();
            
            return true ;
        } catch (Exception e){
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
    }
        
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        

        return listagem;
    }
    
    
    
        
}

