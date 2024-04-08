package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;


// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns= {"/Controller", "/main", "/listadecontatos", "/insert", "/select", "/editar", "/delete", "/report"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
       /** The dao. */
       DAO dao = new DAO();
       
       /** The contato. */
       JavaBeans contato = new JavaBeans();
       
    /**
     * Instantiates a new controller.
     */
    public Controller() {
        super();
     
    }

	
	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Teste de conexao
		//dao.testeConexao();
		String requisicao = request.getServletPath();
		System.out.println(requisicao);
		if (requisicao.equals("/main")) {
			contatos(request, response);
		}
		else if (requisicao.equals("/insert")) {
			novoContato(request, response);
		}
		
		else if (requisicao.equals("/listadecontatos")) {
			listadecontatos(request, response);
		}
		else if(requisicao.equals("/select")) {
			selecionarContatos(request, response);
		}
		else if(requisicao.equals("/editar")) {
			updateContato(request, response);
		}
		else if (requisicao.equals("/delete")) {
			removerContatos(request, response);
		}
		else if(requisicao.equals("/report")) {
			gerarRelatorio(request, response);
		}
		else {
			response.sendRedirect("index.html");
		}
	}
	
	/**
	 * Listadecontatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listadecontatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("listadecontatos.jsp");
	}
	
	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("agenda.jsp");
		//Criando um objeto que irá receber os dados da Classe JavaBeans 
		ArrayList<JavaBeans> lista = dao.listarContatos();
		//Encaminhamento do objeto lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
		
		/**
		 * Selecionar contatos.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		//Editar Contato
	protected void selecionarContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recebimento do id de contatos que será editado
		String idcon = request.getParameter("idcon");
		
		//System.out.println(idcon);
		
		contato.setIdcon(Integer.parseInt(idcon));
		//Executar o método selecionarContato pelo DAO
		dao.selecaoContato(contato);
		/*System.out.println(contato.getIdcon());
		System.out.println(contato.getNome());
		System.out.println(contato.getFone());
		System.out.println(contato.getEmail());*/
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		
	}
	
	/**
	 * Update contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void updateContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*System.out.println(request.getParameter("idcon"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));*/
		
		//settar os atributos de classe Javabeans.java
		contato.setIdcon(Integer.parseInt(request.getParameter("idcon")));
		contato.setNome(request.getParameter("nome"));
		contato.setNome(request.getParameter("fone"));
		contato.setNome(request.getParameter("email"));
		
		dao.atualizarContato(contato);
		//redirecionar para a Pagina agenda.jsp
		response.sendRedirect("main");
		
	}
	
	/**
	 * Novo contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void novoContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		contato.setIdcon(Integer.parseInt(request.getParameter("idcon")));
		contato.setNome(request.getParameter("nome"));
		contato.setNome(request.getParameter("fone"));
		contato.setNome(request.getParameter("email"));
		
		dao.removerContato(contato);
		
		response.sendRedirect("main");
	}
	
	/**
	 * Remover contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idcon = request.getParameter("idcon");
			System.out.println(idcon);
			contato.setIdcon(Integer.parseInt(idcon));
			
			dao.removerContato(contato);
			response.sendRedirect("main");
	}
	
	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Gerar Relatório em PDF
		Document documento = new Document();
		try {
			//tipo de conteúdo 
			response.setContentType("application/pdf");
			//nome do Arquivo
			response.addHeader("Content-Disposition", "inline; filename="+"contatos.pdf");
			//Criar documeto
			PdfWriter.getInstance(documento, response.getOutputStream());
			//Abrir o documento -> conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de Contatos"));
			
			//Lista de Contatos
			documento.add(new Paragraph(""));
			
			
			//criar tabela no pdf
			PdfPTable tabela = new PdfPTable(3);
			//Cabecalho
			PdfPCell coll1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell coll2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell coll3 = new PdfPCell(new Paragraph("Email"));
			tabela.addCell(coll1);
			tabela.addCell(coll2);
			tabela.addCell(coll3);
			
			//Popular a tabela com os contatos
			ArrayList<JavaBeans> lista = dao.listarContatos();
			for(int i= 0; i<lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getEmail());
				
			}
			
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			documento.close();
		}
	}
	
	
		
		//teste de recebimento de lista
		/*for(int i=0; i<lista.size(); i++) {
			System.out.println(lista.get(i).getIdcon());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
		 	System.out.println(lista.get(i).getEmail());
		}*/
	
	/**
		 * Novo contato.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		//Novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*teste de recebimento de dados do Formulario novo.html
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		*/
		//Setar as atributos da Classe JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		//Invocar o método inserirContato passando o objeto Contato
		dao.inserirContatos(contato);
		//redirecionar para a página...
		response.sendRedirect("main");
		
	}
}
	