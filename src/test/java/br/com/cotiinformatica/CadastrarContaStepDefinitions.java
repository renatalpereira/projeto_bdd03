package br.com.cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastrarContaStepDefinitions {

	WebDriver driver;

	@Given("Acessar a página de cadastro de contas")
	public void acessar_a_página_de_cadastro_de_contas() {

		// apontar o local onde está o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");

		// abrir o navegador
		driver = new ChromeDriver();
		// maximizar o navegador
		driver.manage().window().maximize();
		// acessar a página do sistema que será testada
		driver.get("http://testesoftware-001-site1.atempurl.com/exercicios/tarefa05");

	}

	@Given("Informar o nome do cliente")
	public void informar_o_nome_do_cliente() {

		// acessando o campo para preenchimento do nome
		WebElement element = driver.findElement(By.xpath("//*[@id=\"NomeConta\"]"));

		// limpar campo
		element.clear();

		// preenchendo o campo
		element.sendKeys("Renata Lourenço");

	}

	@Given("Informar a data da conta")
	public void informar_a_data_da_conta() {

		// acessando o campo para preenchimento da data
		WebElement element = driver.findElement(By.xpath("//*[@id=\"DataConta\"]"));

		// limpar campo
		element.clear();

		// preenchendo o campo
		element.sendKeys("04/12/2022");

	}

	@Given("Informar o valor da conta")
	public void informar_o_valor_da_conta() {

		// acessando o campo para preenchimento do valor
		WebElement element = driver.findElement(By.xpath("//*[@id=\"ValorConta\"]"));

		// limpar campo
		element.clear();

		// preenchendo o campo
		element.sendKeys("4.000,00");

	}

	@Given("Informar as observações")
	public void informar_as_observações() {

		// acessando o campo para preenchimento das observações
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Observacoes\"]"));

		// limpar campo
		element.clear();

		// preenchendo o campo
		element.sendKeys("Exercício 2");

	}

	@Given("Informar o tipo de conta a pagar")
	public void informar_o_tipo_de_conta_a_pagar() {

		// acessando o campo para preenchimento do tipo de campo
		WebElement element = driver.findElement(By.xpath("//*[@id=\"TipoConta\"]"));

		Select select = new Select(element);
		select.selectByVisibleText("Conta a Pagar");
	}
	
	@Given("Informar o tipo de conta a receber")
	public void informar_o_tipo_de_conta_a_receber() {

		// acessando o campo para preenchimento do tipo de campo
		WebElement element = driver.findElement(By.xpath("//*[@id=\"TipoConta\"]"));

		Select select = new Select(element);
		select.selectByVisibleText("Conta a Receber");

	}

	@When("Solicitar o cadastro da conta")
	public void solicitar_o_cadastro_da_conta() {

		// acessando o botão para confirmação do formulário
		WebElement element = driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]"));

		// Clicando no botão
		element.click();

	}

	@Then("Sistema cadastra a conta com sucesso")
	public void sistema_cadastra_a_conta_com_sucesso() {

		// acessando o campo com a mensagem de sucesso
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));

		// criando uma asserção de teste
		assertTrue(element.getText().contains("Conta cadastrada com sucesso."));
		
		//Criando o arquivo com a evidencia de teste
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String data = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
			FileUtils.copyFile(arquivo, new File("Cadastrar conta com sucesso_" + data + ".png"));
		}

		catch (Exception e) {
			e.printStackTrace();
		} 
		
		finally {
			driver.close();		
		}

	}
	
	

}
