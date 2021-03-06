package aluguelCarros;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class TestaCarroLuxo {

	private String placa = "HVH-1404";
	
	@Test
	public void testaValoresAditivos() {
		assertTrue(AluguelCarro.getValorTanqueCheio() == 150);
		assertTrue(AluguelCarro.getValorSeguro() == 100);
		
		CarroLuxo carro1 = new CarroLuxo(placa, false, false);
		assertTrue(carro1.temTanqueCheio() == false);
		assertTrue(carro1.temSeguro() == false);
		assertTrue(carro1.getAditivos() == 0);
		
		CarroLuxo carro2 = new CarroLuxo(placa, true, false);
		assertTrue(carro2.temTanqueCheio() == true);
		assertTrue(carro2.temSeguro() == false);
		assertTrue(carro2.getAditivos() == 150);
		
		CarroLuxo carro3 = new CarroLuxo(placa, false, true);
		assertTrue(carro3.temTanqueCheio() == false);
		assertTrue(carro3.temSeguro() == true);
		assertTrue(carro3.getAditivos() == 100);
		
		CarroLuxo carro4 = new CarroLuxo(placa, true, true);
		assertTrue(carro4.temTanqueCheio() == true);
		assertTrue(carro4.temSeguro() == true);
		assertTrue(carro4.getAditivos() == 250);
		
	}// fim do m�todo testaValoresAditivos()

	@Test
	public void testaCustosDeAluguelCaso1(){
		// Criando um carro de luxo sem valores aditivos
		CarroLuxo carro1 = new CarroLuxo(placa, false, false);
		
		// Criando um objeto Calendar para representar a data e hora atuais 
		Calendar dataAluguel = Calendar.getInstance();
		
		// Configurando a data de solicitacao de aluguel do carro como sendo esse objeto Calendar
		carro1.setDataSolicitacao(dataAluguel);
		
		// Criando outro objeto Calendar que posteriormente ser� a data de devolu��o do carro
		Calendar dataDevolucao = Calendar.getInstance();
		
		// Alterando o dia do objeto Calendar para que seja o mesmo dia da solicita��o de aluguel do carro.  
		dataDevolucao.set(Calendar.DATE, dataAluguel.get(Calendar.DATE));
		
		// Configurando a data de devolu��o do carro como sendo esse objeto Calendar 'dataDevolucao'.
		carro1.setDataDevolucao(dataDevolucao);
		
		// Assegurando que o custo de aluguel do carro ser� o valor referente a uma �nica di�ria, j� que foi devolvido no mesmo dia.
		assertTrue(carro1.custo() == 100);
				
	}// fim de testaCustosDeAluguelCaso1()
	
	@Test
	public void testaCustosDeAluguelCaso2(){
		// Criando um carro de luxo com seguro incluso
		CarroLuxo carro1 = new CarroLuxo(placa, false, true);
		
		// Criando um objeto Calendar para representar a data e hora atuais 
		Calendar dataAluguel = Calendar.getInstance();
		
		// Configurando a data de solicitacao de aluguel do carro como sendo esse objeto Calendar
		carro1.setDataSolicitacao(dataAluguel);
		
		// Criando outro objeto Calendar que posteriormente ser� a data de devolu��o do carro
		Calendar dataDevolucao = Calendar.getInstance();
		
		// Alterando o dia do objeto Calendar para que seja um dia � frente da data de solicita��o de aluguel do carro.  
		dataDevolucao.set(Calendar.DATE, dataAluguel.get(Calendar.DATE) + 1);
		
		// Configurando a data de devolu��o do carro como sendo esse objeto Calendar 'dataDevolucao'.
		carro1.setDataDevolucao(dataDevolucao);
		
		// Assegurando que o custo de aluguel do carro ser� o valor referente a duas di�rias (R$ 200) 
		// mais o valor do seguro (R$ 100).
		assertTrue(carro1.custo() == 300);
				
	}// fim de testaCustosDeAluguelCaso2()
	
	@Test
	public void testaCustosDeAluguelCaso3(){
		// Criando um carro de luxo com tanque cheio
		CarroLuxo carro1 = new CarroLuxo(placa, true, false);
		
		// Criando um objeto Calendar para representar a data e hora atuais 
		Calendar dataAluguel = Calendar.getInstance();
		
		// Configurando a data de solicitacao de aluguel do carro como sendo esse objeto Calendar
		carro1.setDataSolicitacao(dataAluguel);
		
		// Criando outro objeto Calendar que posteriormente ser� a data de devolu��o do carro
		Calendar dataDevolucao = Calendar.getInstance();
		
		// Alterando o dia do objeto Calendar para que seja dois dias � frente da data de solicita��o de aluguel do carro.  
		dataDevolucao.set(Calendar.DATE, dataAluguel.get(Calendar.DATE) + 2);
		
		// Configurando a data de devolu��o do carro como sendo esse objeto Calendar 'dataDevolucao'.
		carro1.setDataDevolucao(dataDevolucao);
		
		// Assegurando que o custo de aluguel do carro ser� o valor referente a tr�s di�rias (R$ 300) 
		// mais o valor do tanque cheio (R$ 150).
		assertTrue(carro1.custo() == 450);
				
	}// fim de testaCustosDeAluguelCaso3()

	@Test
	public void testaCustosDeAluguelCaso4(){
		// Criando um carro de luxo com tanque cheio e seguro inclusos
		CarroLuxo carro1 = new CarroLuxo(placa, true, true);
		
		// Criando um objeto Calendar para representar a data e hora atuais 
		Calendar dataAluguel = Calendar.getInstance();
		
		// Configurando a data de solicitacao de aluguel do carro como sendo esse objeto Calendar
		carro1.setDataSolicitacao(dataAluguel);
		
		// Criando outro objeto Calendar que posteriormente ser� a data de devolu��o do carro
		Calendar dataDevolucao = Calendar.getInstance();
		
		// Alterando o dia do objeto Calendar para que seja tr�s dias � frente da data de solicita��o de aluguel do carro.  
		dataDevolucao.set(Calendar.DATE, dataAluguel.get(Calendar.DATE) + 3);
		
		// Configurando a data de devolu��o do carro como sendo esse objeto Calendar 'dataDevolucao'.
		carro1.setDataDevolucao(dataDevolucao);
		
		// Assegurando que o custo de aluguel do carro ser� o valor referente a quatro di�rias (R$ 400) 
		// mais o valor do tanque cheio (R$ 150) e seguro (100).
		assertTrue(carro1.custo() == 650);
				
	}// fim de testaCustosDeAluguelCaso4()
	
}// fim da classe
