package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Array;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import aula.Sena;

@SuppressWarnings("unused")
public class SenaTest {

	@Mock
	private Sena s;
	private int[] nmrs;

	@Before
	public void init() {
		s = mock(Sena.class);
		when(s.create(5)).thenThrow(new NullPointerException());// retorna erro
																// pois e menor
																// do que 6
		when(s.create(13)).thenThrow(new NullPointerException());// retorn erro
																	// // pois e
																	// maior do
																	// que 12
		when(s.create(6)).thenReturn(new int[] { 1, 2, 3, 4, 5, 6 });
		when(s.create(12)).thenReturn(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
		nmrs = s.create(12);
	}

	@Test(expected = NullPointerException.class)
	public void testMenor() {
		s.create(5);
		verify(s,atLeastOnce()).create(anyInt());

	}
	@Test(expected = NullPointerException.class)
	public void testMaior() {
		s.create(13);
		verify(s,atLeastOnce()).create(anyInt());
	}
	@Test
	public void testNormal6() {
		assertEquals(6,Array.getLength(s.create(6)));
	}
	@Test
	public void testNormal12() {
		assertEquals(12,Array.getLength(s.create(12)));
	}
	@Test
	public void testAllHigher() {
		for( int element: nmrs) {
			assertFalse("Numero Maior 60 ou Menor que 1:"+element,element<1 || element>60 );
		}
	}
	@Test
	public void testEquals() {
		for (int i=0;i<nmrs.length -1;i++) {
			if(nmrs[i] == nmrs[i+1]) {
				fail("DOIS NUMEROS IGUAIS !");
			}
		}
	}
	
}
