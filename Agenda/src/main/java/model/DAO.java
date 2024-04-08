package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	//Modulo de Conexão
	//Parâmetros para Conexão
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "backend@24";
	
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	//Método de conexão 
	private Connection conectar() {
		Connection  con = null; 
		//Exception Treatments:
		try {			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu Erro na Conexão");
			return null;
			
		}
	}
	
	/**
	 * Inserir contatos.
	 *
	 * @param contato the contato
	 */
	//Crud -> Create
	public void inserirContatos(JavaBeans contato) {
		
		
		
		String create = "insert into contatos(nome, fone,email) values (?, ?, ?)";
		try {
			//abrir a conexão 
			Connection con = conectar();
			//Preparar a consultar(query) para execução no Bnaco de dados
			PreparedStatement pst = con.prepareStatement(create);
			//Substituir os parâmetros (?) pelo conteúdo dos atributos da classe JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			//Executar a query (Crtl + Enter)
			pst.executeUpdate();
			//Encerrar a conexão com o banco
			con.close();
			
		} catch (Exception e) {
			System.out.println("Deu Erro no Insert");
		}
		
	}
	//Crud -> Read
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		//Criando um objeto para acessar a classe JavaBeans
				ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select *  from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//O laço abaixo está executado eqto houver contatos
			while(rs.next()) {
				//variáveis de apoio que recebem os dados de apoio do Banco
				int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getNString(3);
				String email = rs.getNString(4);
				//Populando o ArrayList 
				contatos.add(new JavaBeans(idcon, nome, fone, email));
				
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	//Crud Update
			/**
	 * Selecao contato.
	 *
	 * @param contato the contato
	 */
	//Selecionar contato
		public void selecaoContato(JavaBeans contato) {
			String read2 = "select * from contatos where idcon = ?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read2);
				pst.setInt(1, contato.getIdcon());
				ResultSet rs = pst.executeQuery();
				//Laço while para receber dados do banco do BD e enviar para a classe JavaBeans 
				while(rs.next()) {
					//setar as variáveis JavaBeans
					contato.setIdcon(rs.getInt(1));
					contato.setNome(rs.getString(2)); 
					contato.setFone(rs.getString(3));
					contato.setEmail(rs.getString(4));
					
					
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
		}
		
		/**
		 * Atualizar contato.
		 *
		 * @param contato the contato
		 */
		public void atualizarContato(JavaBeans contato) {
			String read3 = "update contatos set nome=?,fone=?,email=? where idcon=?;";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read3);
				pst.setInt(1, contato.getIdcon());
				pst.setString(2, contato.getNome());
				pst.setString(3, contato.getFone());
				pst.setString(4, contato.getEmail());
				pst.executeUpdate();
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/**
		 * Remover contato.
		 *
		 * @param contato the contato
		 */
		public void removerContato(JavaBeans contato) {
			String  delete =   "delete from contatos where idcon=?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setInt(1, contato.getIdcon());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/**
		 * Gerar relatorio.
		 *
		 * @param contato the contato
		 */
		public void gerarRelatorio(JavaBeans contato) {
			
		}
	
		//teste de Conexão 
		
	/*public void testeConexao() {
			try {
				Connection con = conectar();
				System.out.println(con);
				con.close();
			}catch (Exception e)  {
				System.out.println(e);
			}
		
		
	}*/	
}
	

