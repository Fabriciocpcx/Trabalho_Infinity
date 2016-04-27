import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.Infinity.model.Cliente;
import br.com.Infinity.model.Funcionario;



public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BancoPostgres"); 
		EntityManager em = factory.createEntityManager();
		System.out.println("OK!");
		
		
		Cliente c = new Cliente("José", "2247", "01023", "Rua coronel Manoel Mariano", "96312374", "100");
		em.getTransaction().begin();
		em.persist(c); 
		em.getTransaction().commit();
		

		
		
//		Funcionario f = new Funcionario("senha123", false, 1200, "Adriana", "374", "121", "Rua das Dores", "100");
//		em.getTransaction().begin();
//		em.persist(f); 
//		em.getTransaction().commit();
		
//		List<Mercadoria> mercadorias =  new ArrayList<Mercadoria>();
//			
//		Mercadoria m = new Mercadoria(1,95, 120, 20);
//		em.getTransaction().begin();
//		em.persist(m);
//		em.getTransaction().commit();
//		
//		
//		Mercadoria temp = em.find(Mercadoria.class, 1);
//		
//		mercadorias.add(temp);			
//		
//		Venda v = new Venda(null, 200, mercadorias);
//		em.getTransaction().begin();
//		em.persist(v); 
//		em.getTransaction().commit();
		
		

	}

}
