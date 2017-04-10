package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.IOException;

import org.junit.*;
import org.mockito.Mock;

import aula.Cadastro;

public class CadastroTest {
	@Mock
	private Cadastro cadastro;

	@Test
	public void insert_Test1() {
		try {
			assertTrue(cadastro.insert(1,"De Volta para o Futuro I"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void insert_Test2() {
		try {
			assertFalse(cadastro.insert(2,""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void insert_Test3() {
		try {
			assertFalse(cadastro.insert(3, null));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(expected = Exception.class)
	public void testExecaoImprimir() throws Exception {
		doThrow(new Exception("Teste de Imprimir")).when(cadastro).imprimir();
	}
	
	@Before
	public void set() {
	cadastro = mock(Cadastro.class);
	try {
		when(cadastro.insert(1, "De Volta para o Futuro I")).thenReturn(true);
		when(cadastro.insert(2, "")).thenReturn(false);
		when(cadastro.insert(3, null)).thenReturn(false);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
