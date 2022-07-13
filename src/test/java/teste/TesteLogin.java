package teste;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	
	private WebDriver driver;
	
	@Before
	public void ConfigurarTeste() {
		System.setProperty("webdriver.chrome.driver","C:\\Programas\\jogo\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4200/");
		driver.findElement(By.className("contato_logar")).click();
	}
	
	@Test
	public void TestarLogin() {
		
		WebElement campoEmail = driver.findElement(By.className("input100"));
		WebElement campoSenha = driver.findElement(By.id("senha"));
		WebElement botao = driver.findElement(By.className("login100-form-btn"));
		
		String[] listaEmails = {"giselesilva@gmail.com", "giselerosa@gmail.com", "carlos@gmail.com"};
		String[] listasenhas = {"123458", "123458", "carlos"};
		
		try {
			
			for(int contador = 0; contador <3; contador++) {
				Thread.sleep(2000);
				campoEmail.sendKeys(listaEmails[contador]);
				campoSenha.sendKeys(listasenhas[contador]);
				botao.click();
				
				Thread.sleep(2000);
				
				campoEmail.clear();
				campoSenha.clear();
			}
			
			/*
			// Teste login de e-email incorreto
			campoEmail.sendKeys("giselesilva@gmail.com");
			campoSenha.sendKeys("123458");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			// Teste senha incorreta
			campoEmail.sendKeys("giselerosa@gmail.com");
			campoSenha.sendKeys("123458");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			campoEmail.sendKeys("carlos@gmail.com");
			campoSenha.sendKeys("carlos");
			botao.click();
			
			Thread.sleep(5000);
			*/
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void EncerrarTeste() {
		driver.quit();
	}

}
