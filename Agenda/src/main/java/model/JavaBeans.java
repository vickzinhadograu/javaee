package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {

	/** The idcon. */
	//Atributos do Servidor de BD dbagendas
	private int idcon;
	
	/** The nome. */
	private String nome;
	
	/** The fone. */
	private String fone;
	
	/** The email. */
	private String email;
	
	
	/**
	 * Instantiates a new java beans.
	 */
	//Construtor Superclasse
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param idcon the idcon
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 */
	//Construtor com Campos
	public JavaBeans(int idcon, String nome, String fone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	
	/**
	 * Gets the idcon.
	 *
	 * @return the idcon
	 */
	//Métodos Getters and Setters:
	public int getIdcon() {
		return idcon;
	}
	
	/**
	 * Sets the idcon.
	 *
	 * @param idcon the new idcon
	 */
	public void setIdcon(int idcon) {
		this.idcon = idcon;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}
	
	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
