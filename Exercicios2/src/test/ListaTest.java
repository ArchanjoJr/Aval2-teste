package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;
import org.mockito.*;

import aula.Lista;

public class ListaTest {
	@Mock
	private Lista lista = null;
	@Before
	public void set() throws Exception{
		lista = mock(Lista.class);
		when(lista.get(anyInt())).thenReturn("aaa","bbb").thenThrow(new ArrayIndexOutOfBoundsException());
		when(lista.get(-1)).thenThrow(new ArrayIndexOutOfBoundsException());
	}
	
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testValorNegativo() {
		lista.get(-1);
	}
	
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testExercicio5() {
		System.out.println(lista.get(0));
		System.out.println(lista.get(1));
		System.out.println(lista.get(2));
	}
	
}
