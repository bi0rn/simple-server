package ch.bearware.rest;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class HelloResourceTest extends JerseyTest {
	
	@Override
	protected Application configure() {
		return new ResourceConfig(HelloResource.class);
	}

	@Test
	public void test() {
		String hello = target("/").request().accept("text/plain").get(String.class);
		assertEquals("Hello world!", hello);
	}

}
