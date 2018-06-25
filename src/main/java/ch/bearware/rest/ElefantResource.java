package ch.bearware.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("elefants")
@Transactional
public class ElefantResource {

	@PersistenceContext(name = "elefants")
	private EntityManager entityManager;

	@GET
	@Produces("text/plain")
	public String get() {
		List<Elefant> elefants = entityManager.createQuery("from Elefant", Elefant.class).getResultList();
		String list = elefants.stream().map(Elefant::getName).collect(Collectors.joining("\n", "", "\n"));
		return "Elefants:\n\n" + list;
	}

	@POST
	@Produces("text/plain")
	public String createElefant(String name) {
		Elefant elefant = new Elefant(name);
		entityManager.persist(elefant);
		return "Created new elefant: " + elefant.getName() + "\n";
	}

}
