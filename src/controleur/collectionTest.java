package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controleur.collection;

public class collectionTest {

	@Test
	public final void testCollection() {
		
		collection col = new collection(4, "Berserk", "Miura", "enCours", 26);
		assertTrue(col.getAuteur() == "Miura");
		assertTrue(col.getTitre() == "Berserk");
		assertTrue(col.getStatus() == "enCours");
		assertTrue(col.getNbrTome() == 26);
		assertFalse(col.getAuteur() == "Berserk");
	}
	
	@Test 
	public void testToString() {
		collection col = new collection(4, "Berserk", "Miura", "enCours", 26);
		assertEquals("id=4, titre=Berserk, auteur=Miura, status=enCours, nbrTome=26", col.toString());
	}		
		
}
