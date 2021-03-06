package serpis.ad;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateCategoria {
	public static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		entityManagerFactory = 
				Persistence.createEntityManagerFactory("serpis.ad.jpa.mysql");
		
		
		System.out.println("Añado categorias "+new Date());
		persistNuevasCategorias();
		
		showCategorias();
		deleteCategoria((long)12);
		editCategoria((long)1);
		showCategorias();
		entityManagerFactory.close();
	}
	
	public static void persistNuevasCategorias(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setNombre("Hibernate "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		entityManager.persist(categoria);
		//(entityManager.g
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public static void showCategorias() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		List<Categoria> categorias = entityManager.createQuery("from Categoria", Categoria.class).getResultList();
		for (Categoria categoria : categorias)
			System.out.printf("id=%d nombre=%s\n", categoria.getId(), categoria.getNombre());
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public static void deleteCategoria(long id){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = entityManager.find(Categoria.class, id);
		entityManager.remove(categoria);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public static void editCategoria(long id){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = entityManager.find(Categoria.class, id);
		categoria.setNombre("nombreEditado");
		
		entityManager.merge(categoria);
		entityManager.getTransaction().commit();
		entityManager.close();
		}
}
